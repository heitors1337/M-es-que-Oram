package dao;

import factory.Conexao;
import modelo.Mae;
import modelo.Servico;
import modelo.ServicoTipo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicoDAO {

    public void inserir(Servico servico, int encontroId) {
        String sql = "INSERT INTO encontro_servico (encontro_id, servico_tipo_id, mae_id, descricao) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, encontroId);
            stmt.setInt(2, servico.getTipo().getId());
            stmt.setInt(3, servico.getMaeResponsavel() != null ? servico.getMaeResponsavel().getId() : null);
            stmt.setString(4, servico.getDescricao());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Servico> listarPorEncontro(int encontroId) {
        List<Servico> lista = new ArrayList<>();

        String sql = """
            SELECT es.id, st.id as tipo_id, st.nome as tipo_nome,
                   m.id as mae_id, m.nome as mae_nome, es.descricao
            FROM encontro_servico es
            JOIN servico_tipo st ON es.servico_tipo_id = st.id
            LEFT JOIN mae m ON es.mae_id = m.id
            WHERE es.encontro_id = ?
            ORDER BY st.id
        """;

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, encontroId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Servico s = new Servico();

                s.setId(rs.getInt("id"));


                ServicoTipo tipo = new ServicoTipo();
                tipo.setId(rs.getInt("tipo_id"));
                tipo.setNome(rs.getString("tipo_nome"));
                s.setTipo(tipo);


                if (rs.getObject("mae_id") != null) {
                    Mae mae = new Mae();
                    mae.setId(rs.getInt("mae_id"));
                    mae.setNome(rs.getString("mae_nome"));
                    s.setMaeResponsavel(mae);
                }

                s.setDescricao(rs.getString("descricao"));

                lista.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
