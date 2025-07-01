package C09_jdbc.Desafios.Projetim;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Tabelas {

    public static void main(String[] args) throws SQLException {

        Connection conecti = Conexão.getConexao();

        Statement stmt = conecti.createStatement();

        String sql = "create table if not exists Usuario(" + "codigo int auto_increment primary key,"
                + "email varchar(255) not null," + "senha varchar(80) not null" + ")";

        stmt.execute(sql);

        System.out.println("Tabela criada com sucesso!");

        conecti.close();
    }
}
