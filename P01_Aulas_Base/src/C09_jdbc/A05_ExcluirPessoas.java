package C09_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class A05_ExcluirPessoas {

    public static void main(String[] args) throws SQLException {

        // scanner
        Scanner tec = new Scanner(System.in);

        System.out.print("Informe o ID do usuário que deseja excluir: ");
        int id = tec.nextInt();

        // criando conexao
        Connection conexao = A02_FabricaConexao.getConexao();

        // comando sql
        String sql = "delete from pessoas where codigo = ?";

        // declaranto conexao
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setInt(1, id);

        if (!stmt.execute()) {
            System.out.println("Usuário excluido com sucesso! ");
        } else {
            System.out.println("Usuário não encontrado, tente novamente! ");
        }

        tec.close();
        stmt.close();
    }
}
