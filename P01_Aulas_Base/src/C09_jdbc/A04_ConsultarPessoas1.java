package C09_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class A04_ConsultarPessoas1 {

    public static void main(String[] args) throws SQLException {

        // Criei uma conexao
        Connection conexao = A02_FabricaConexao.getConexao();

        // Declarei a criação da minha conexão.
        Statement stmt = conexao.createStatement();

        // Meu comando SQL
        String sql = "select * from pessoas";

        /*
         * Executa a consulta SQL definido anteriormente e armazena o resultado
         * no objeto "resultado","stmt.executeQuery(sql)" envia a consulta ao
         * banco de dados e retorna um "ResultSet",que é essencialmente uma tabela
         * de dados contendo os resultados da consulta.
         */
        ResultSet resultado = stmt.executeQuery(sql);

        List<Pessoa> pessoas = new ArrayList<>();
        // Equanto tiver um proximo resultado, o codigo abaixo sera executado
        while (resultado.next()) {
            /*
             * Como as informações da consulta ficaram armazenadas na variável "resultado"
             * então pegamos o "codigo" e o "nome" contidos nessa variável e criamos uma
             * nova pessoa através da lista "Pessoas".
             */
            int codigo = resultado.getInt("codigo");
            String nome = resultado.getString("nome");
            pessoas.add(new Pessoa(codigo, nome));
        }

        for (Pessoa p : pessoas) {
            System.out.println(p.getCodigo() + " ==> " + p.getNome());
        }

        conexao.close();
    }
}
