package C09_jdbc.Desafios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import C09_jdbc.A02_FabricaConexao;
import C09_jdbc.Pessoa;

public class DesafioUpdate {

    public static void main(String[] args) throws SQLException {

        // Scanner
        Scanner tec = new Scanner(System.in);

        // requisição 1
        System.out.print("Digite qual o ID que deseja Atulizar? ");
        String id = tec.nextLine();

        // conexão criada
        Connection ponte = A02_FabricaConexao.getConexao();

        // declarando a conexão
        Statement stmt = ponte.createStatement();

        // executando o "sql" e armazenando na variável "resulti"
        String sql = "select * from pessoas where codigo = " + id;

        ResultSet resulti = stmt.executeQuery(sql);

        // MOSTRAR Pessoa atual
        List<C09_jdbc.Pessoa> pessoas = new ArrayList<>();

        while (resulti.next()) {
            int codigo = resulti.getInt("codigo");
            String nome = resulti.getString("nome");
            pessoas.add(new Pessoa(codigo, nome));
        }

        for (Pessoa p : pessoas) {
            System.out.println("\nO nome atual do ID " + p.getCodigo() + " é " + p.getNome());
        }

        // REQUISIÇÃO PARA FAZER O UPDATE
        System.out.print("Digite o novo Nome para ser Atualizado: ");
        String newName = tec.nextLine();

        // comando sql
        String comandSql = "UPDATE pessoas SET nome = '" + newName + "' WHERE codigo = " + id;
        stmt.execute(comandSql);

        // select para mostrada o id atualizado
        String newbusca = "select * from pessoas where codigo = " + id;

        ResultSet resultado = stmt.executeQuery(newbusca);

        // MOSTRAR Pessoa NOVA
        List<C09_jdbc.Pessoa> newpessoas = new ArrayList<>();

        while (resultado.next()) {
            int codigo = resultado.getInt("codigo");
            String nome = resultado.getString("nome");
            newpessoas.add(new Pessoa(codigo, nome));
        }

        for (Pessoa p2 : newpessoas) {
            System.out.println("\nO nome atual é " + p2.getNome());
        }

        tec.close();
        stmt.close();
    }
}
