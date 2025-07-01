package C09_jdbc.Desafios.Projetim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conect {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306";
        String usuario = "root";
        String senha = "12345";

        Connection conexao = DriverManager.getConnection(url, usuario, senha);

        java.sql.Statement stmt = conexao.createStatement();
        stmt.execute("create database if not exists projetim");

        System.out.println("Criado com sucesso");

        conexao.close();
    }
}
