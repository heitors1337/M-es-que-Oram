package dao;

import factory.ConnectionFactory;
import modelo.Servico;
import modelo.Mae;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicoDAO {

    public void inserir(Servico servico) {
        String sql = "INSERT INTO encontro_servico (encontro_id, servico_tipo_id, mae_id, descricao) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, servico.getId());
            ps.setInt(2, 1);
            ps.setInt(3, servico.getMaeResponsavel().getId());
            ps.setString(4, servico.getDescricao());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Servico> listarTodos() {
        List<Servico> lista = new ArrayList<>();

        String sql = """
            SELECT es.id, es.descricao, m.id AS mae_id, m.nome AS mae_nome
            FROM encontro_servico es
            LEFT JOIN mae m ON es.mae_id = m.id
        """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Servico s = new Servico();
                s.setId(rs.getInt("id"));
                s.setDescricao(rs.getString("descricao"));

                Mae m = new Mae();
                m.setId(rs.getInt("mae_id"));
                m.setNome(rs.getString("mae_nome"));
                s.setMaeResponsavel(m);

                lista.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
