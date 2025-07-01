package C09_jdbc.Desafios.Projetim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexão {

    public static Connection getConexao() {

        try {
            String url = "jdbc:mysql://localhost:3306/projetim";
            String usuario = "root";
            String senha = "12345";
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
