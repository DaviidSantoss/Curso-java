package C09_jdbc.Desafios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import C09_jdbc.A02_FabricaConexao;

public class DesafioConsulta {

    public static void main(String[] args) throws SQLException {

        // escaner
        Scanner tec = new Scanner(System.in);

        // requisição
        System.out.print("Digite a parte do Nome que deseja Encontrar: ");
        String nomepart = tec.nextLine();

        // Criei minha conexão
        Connection conexao = A02_FabricaConexao.getConexao();

        // Fizemos a consulta apartir do que foi digitado pelo usuario
        String sqlComand = "select * from pessoas where nome like ?";

        // Declaria minha conexão
        PreparedStatement stmt = conexao.prepareStatement(sqlComand);

        // setamos nosso comando como "String" para que tenha uma maior segurança.
        stmt.setString(1, "%" + nomepart + "%");

        // Utilizamos o ResultSet onde as informações serão armazenadas.
        ResultSet resultado = stmt.executeQuery();

        // Criamos uma lista do tipo "jdbc.Pessoa"
        List<C09_jdbc.Pessoa> pessoas = new ArrayList<>();

        while (resultado.next()) {
            int codigo = resultado.getInt("codigo");
            String nome = resultado.getString("nome");
            pessoas.add(new C09_jdbc.Pessoa(codigo, nome));
        }

        for (C09_jdbc.Pessoa p : pessoas) {
            System.out.println(p.getNome());
        }
        tec.close();
    }
}
