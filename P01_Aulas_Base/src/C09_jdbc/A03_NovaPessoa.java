package C09_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class A03_NovaPessoa {

    public static void main(String[] args) throws SQLException {

        /* Scanner */
        Scanner tec = new Scanner(System.in);

        /* Requisição */
        System.out.print("Informe o nome : ");
        String nome = tec.nextLine();

        /* Conexão com o banco de dados */
        Connection conexao = A02_FabricaConexao.getConexao();

        /* Comando sql para adicionar "nomes" ao banco de dados */
        String sql = "insert into pessoas (nome) values(?)";
        /*
         * O "PreparedStatement" nos permite definir os valores dos campos reservados
         * "?" com segurança.
         */
        PreparedStatement stmt = conexao.prepareStatement(sql);

        /*
         * Começamos definindo o nosso "stmt" como "String" logo em seguida Definimos
         * o valor do primeiro (e único) dos campos reservados "?" na instrução SQL(1),
         * O valor é atribuído a partir da variável "nome", que será inserido na coluna
         * "nome" da tabela "pessoas".
         */
        stmt.setString(1, nome);

        /* Executamos a instrução SQL, que insere o nome no banco de dados. */
        stmt.execute();

        System.out.println("Pessoa incluida com sucesso");

        tec.close();
    }
}
