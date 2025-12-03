package dao;

import factory.ConnectionFactory;
import modelo.Mae;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaeDAO {

    public void inserir(Mae m) {
        String sql = "INSERT INTO mae (nome, telefone, endereco, data_aniversario) VALUES (?, ?, ?, ?)";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, m.getNome());
            ps.setString(2, m.getTelefone());
            ps.setString(3, m.getEndereco());
            ps.setDate(4, java.sql.Date.valueOf(m.getDataAniversario()));

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Mae> listar() {
        List<Mae> lista = new ArrayList<>();
        String sql = "SELECT * FROM mae";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Mae m = new Mae(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("endereco"),
                        rs.getDate("data_aniversario").toLocalDate()
                );
                lista.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
