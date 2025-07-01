package C09_jdbc.Desafios.Projetim;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Metodos {

    public static void Loop1() throws SQLException {
        Scanner tec = new Scanner(System.in);
        System.out.println();
        System.out.println("Deseja Criar uma Conta?");
        System.out.println("1-Sim!");
        System.out.println("2-Não, já possuo cadastro!");
        String r1 = tec.nextLine();

        // OPÇÃO 1
        if (r1.equalsIgnoreCase("1")) {
            System.out.print("Email: ");
            String email = tec.nextLine();
            System.out.print("Senha: ");
            String senha = tec.nextLine();

            Connection conexao = Conexão.getConexao();

            // COMANDO SQL
            String add = "insert into usuario (email,senha) values  (?,?)";

            // EXECUÇÃO DO COMANDO SQL
            PreparedStatement stmt = conexao.prepareStatement(add);
            stmt.setString(1, email);
            stmt.setString(2, senha);

            // EXECUTANDO O COMANDO SQL.
            stmt.execute();
            System.out.println("\nConta criada com sucesso!");
            System.out.println();

            Loop1();

            // OPÇÃO 2
        } else if (r1.equalsIgnoreCase("2")) {
            System.out.println();
            System.out.println("Para fazer o Login Digite: ");
            System.out.print("Email: ");
            String emailVal = tec.nextLine();
            System.out.print("Senha: ");
            String senhaVal = tec.nextLine();

            Connection conexao = Conexão.getConexao();

            /*
             * O código sql irá procurar se o email e senha digitados pelo usuário
             * existem, e ele fará isso atravez do "select"
             */
            String valido = "select * from usuario where email = ? and senha = ?";

            PreparedStatement stmt = conexao.prepareStatement(valido);
            stmt.setString(1, emailVal);
            stmt.setString(2, senhaVal);

            // O resultado do select será armazenado aqui.
            ResultSet resultado = stmt.executeQuery();

            // Si o exisiter um email e senha condizentes com oq o usuário digitou
            // então o login será feito
            if (resultado.next()) {
                System.out.println("\nLogin Bem-sucedido!");
                System.out.println();
                menu();
                // Si não existir esse login e senha o método sera chamado novamente.
            } else {
                System.out.println("\nEmail ou Senha Incorretos, Tente novamente!");
                System.out.println();
                Loop1();
            }
        } else {
            System.out.println("\nOpção Inválida !");
            System.out.println();
            Loop1();
        }

        tec.close();
    }

    // Esse método retornará os emais e senhas atuais do banco de dados
    public static void getPessoas() throws SQLException {

        // criamos a conexão
        Connection conexao2 = Conexão.getConexao();

        // Declaramos a conexão criando um "Statement"
        Statement stmt = conexao2.createStatement();

        // codigo "slq"
        String proc = "select codigo, email from usuario";

        // O "Resultset" onde será armazenado o resultado do "select"
        ResultSet resultado = stmt.executeQuery(proc);

        // criamos uma lista para adicionar o emails e o codigo dos usuários
        List<usuario> user = new ArrayList<>();

        // Enquanto houver conteudo dentro de "resultado" o codigo abaixo
        // sera executado.
        while (resultado.next()) {
            // pegamos o "codigo" e o "email" e adicionamos dentro de uma String
            String codigo = resultado.getString("codigo");
            String email = resultado.getString("email");
            // Criamos um novo usuário apartir do código e email.
            user.add(new usuario(codigo, email));
        }
        // foreach que percorre a lista de usuários e a exibe na tela.
        for (usuario usuario : user) {
            System.out.println("ID: " + usuario.getCodigo() + " " + "email: " + usuario.getEmail());
        }
    }

    public static void menu() throws SQLException {

        Scanner tec2 = new Scanner(System.in);
        System.out.println("\n1-Deseja Adicionar um novo usuário?");
        System.out.println("2-Deseja Editar algum usuário?");
        System.out.println("3-Deseja Deletar algum usuário?");
        System.out.println("4- Sair!");
        String result = tec2.nextLine();

        // OPÇÃO 1
        if (result.equalsIgnoreCase("1")) {

            System.out.println("\nOs Usuários atuais são: ");
            System.out.println();
            getPessoas();

            System.out.print("\nEmail: ");
            String emailnew = tec2.nextLine();
            System.out.print("Senha: ");
            String senhanew = tec2.nextLine();

            Connection conect = Conexão.getConexao();

            String comand = "insert into usuario (email,senha) values (?,?)";

            PreparedStatement stmt = conect.prepareStatement(comand);

            stmt.setString(1, emailnew);
            stmt.setString(2, senhanew);

            stmt.execute();

            System.out.println("\nNovo Usuário adicionado com sucesso!");
            menu();

            // OPÇÃO 2
        } else if (result.equalsIgnoreCase("2")) {
            System.out.println("\nOs Usuários atuais são: ");
            System.out.println();
            getPessoas();

            System.out.print("\nDigite o ID do usuário que deseja Editar: ");
            String iduser = tec2.nextLine();

            System.out.print("Digite o novo email: ");
            String emailuser = tec2.nextLine();

            Connection conect = Conexão.getConexao();

            String comand2 = "update usuario set email = '" + emailuser + "'where codigo = " + iduser;

            PreparedStatement stmt = conect.prepareStatement(comand2);

            stmt.execute();

            System.out.println("\nEdição bem sucedida: ");
            System.out.println();
            getPessoas();

            System.out.println();

            menu();

            // OPÇÃO 3
        } else if (result.equalsIgnoreCase("3")) {
            System.out.println("\nOs Usuários atuais são: ");
            System.out.println();
            getPessoas();

            System.out.print("\nDigite o ID do usuário que deseja Excluir: ");
            String deletuser = tec2.nextLine();

            System.out.print("\nPara confirmar a exclusão digite sua senha:  ");
            String senhaval = tec2.nextLine();

            Connection conect = Conexão.getConexao();

            String comand3 = "select * from usuario where senha = ?";

            PreparedStatement stmt = conect.prepareStatement(comand3);
            stmt.setString(1, senhaval);

            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {

                Connection conectado = Conexão.getConexao();

                String comand4 = "delete from usuario where codigo = " + deletuser;

                Statement stmt2 = conectado.createStatement();

                stmt2.execute(comand4);
                System.out.println("\nExclusão bem sucedida! ");
                System.out.println();
                getPessoas();

                System.out.println();

                stmt2.close();
                menu();
            } else {
                System.out.println("\nSenha invalida tente novamente !");
                System.out.println();
                menu();
            }

            // String valido =
        } else if (result.equalsIgnoreCase("4")) {
            System.out.println("\nVolte sempre!");
        } else {
            System.out.println("\nOpção Invalida!");
            menu();
        }

        tec2.close();
    }

}
