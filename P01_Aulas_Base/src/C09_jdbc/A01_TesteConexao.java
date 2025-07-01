package C09_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A01_TesteConexao {

    public static void main(String[] args) throws SQLException {

        /* JBDC = "Java Database Connectivity" */

        /*
         * Iniciamos essa String colocando o nome da nossa API que no nosso caso é o
         * "JDBC", em seguida definimos qual drive iremos acessar que no nosso caso é o
         * "mysql", e por final eu indico o nome do servidor que desejamos e a sua porta
         * de entrada.
         */
        final String url = "jdbc:mysql://localhost:3306";
        final String usuario = "root";
        final String senha = "12345";

        /*
         * Para iniciarmos uma conexão importamos uma interface chamada "Connection" da
         * biblioteca "java.sql" e o chamamos de "conexao", em seguida adicionamos o
         * método "DriverManager.getConnection" porém este método lança uma exceção
         * checada, ou seja precisamos obrigatoriamente trata-la,como não usamos o
         * try catch declamos explicitamente na estrutura da nossa classe que estamos
         * lançando uma exceção do tipo sql com o comando "throws SQLException".
         * 
         */
        Connection conexao = DriverManager.getConnection(url, usuario, senha);

        /*
         * Criamos um "Statement" ou em português "Declaração" com o nome de "stmt", e
         * para criarmos esse statement usamos a "conexao" através do comando
         * "conexao.createStatement()",em seguida executamos um comando sql através
         * desse statement usando o código "stmt.execute()",e por final utilizamos o
         * comando sql "create database if not exists (nome do banco de dados)".
         */
        Statement stmt = conexao.createStatement();
        stmt.execute("Create database if not exists curso_java");

        System.out.println("Banco Criado com sucesso!");

        /* Fechamos a conexão */
        conexao.close();
    }
}