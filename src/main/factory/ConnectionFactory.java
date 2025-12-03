package factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/bancosql";
    private static final String USER = "root";
    private static final String PASSWORD = "1337";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Erro na conexão com o banco: " + e.getMessage());
        }
    }
}
