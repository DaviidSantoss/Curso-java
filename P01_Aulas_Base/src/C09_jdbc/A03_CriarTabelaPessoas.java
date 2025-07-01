package C09_jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class A03_CriarTabelaPessoas {

    public static void main(String[] args) throws SQLException {

        // Criamos uma conexão apartir do "Fabrica Conexao"
        Connection conexao = A02_FabricaConexao.getConexao();

        // declaramos a criação de uma conexão
        Statement stmt = conexao.createStatement();

        // comando sql
        String sql = "create table if not exists Pessoas(" + "codigo int auto_increment primary key,"
                + "nome varchar(80) not null" + ")";

        // executando o comando sql
        stmt.execute(sql);

        System.out.println("Tabela criada com Sucesso!");
        conexao.close();

    }
}
