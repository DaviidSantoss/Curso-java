package Principal;

import java.util.Scanner;
import Banco.AdmGeral;
import Banco.Medico;
import Banco.Paciente;
import Banco.Recepcionista;
import Infra.DAO;
import Metodos.M_LoginPadrao;

public class TestePrincipal {

    /* DAOs instânciados */
    static DAO<Medico> daoMedico = new DAO<>(Medico.class);
    static DAO<Paciente> daoPaciente = new DAO<>(Paciente.class);
    static DAO<Recepcionista> daoRecepcionista = new DAO<>(Recepcionista.class);
    static DAO<AdmGeral> daoAdmGeral = new DAO<>(AdmGeral.class);

    public static void main(String[] args) {

        /* Método Login Instânciado */
        M_LoginPadrao lg1 = new M_LoginPadrao();

        /* Scanner */
        Scanner tec = new Scanner(System.in);

        /* Requisição Inicial */
        System.out.println();
        System.out.print("Já Possui Cadastro (S/n)? ");
        String r1 = tec.nextLine();
        int erro = 0;

        if (r1.equalsIgnoreCase("s") || erro == 1) {
            lg1.Login();

            /* Caso a resposta seja não os códigos abaixos serão executados */
        } else if (r1.equalsIgnoreCase("n")) {

            /*
             * Enquanto while permanecer true essa parte do código sera executada, e
             * quando chegarmos ao fim de algum bloco de execução o "break" será chamado
             * enterrompendo assim o loop do while.
             */
            while (true) {

                System.out.println();
                System.out.println("Deseja-se Cadastrar Como: ");
                System.out.println();

                System.out.println("1-Médico");
                System.out.println("2-Paciente");
                System.out.println("3-Recepscionista");
                System.out.println("4-Administrador Geral");
                System.out.println();
                System.out.print("Digite sua Opção: ");
                String r2 = String.valueOf(tec.nextLine());

                /* Si a opção 1 for escolhida */
                if (r2.equals("1")) {

                    System.out.println();
                    System.out.print("Digite seu Nome: ");
                    String m1 = String.valueOf(tec.nextLine().trim());

                    System.out.println();
                    System.out.println("Digite seu CRM (6 Digitos):");
                    String m2 = String.valueOf(tec.nextLine().trim());

                    System.out.println();
                    System.out.print("Digite sua Senha: ");
                    String m3 = String.valueOf(tec.nextLine().trim());

                    /*
                     * Si o nome,CRM e senha forem diferentes de nulo o usuário médico
                     * será adicionado e o break sera chamado fazendo com que o loop seja
                     * enterrompido.
                     */
                    if (!m1.isEmpty() || m2.length() == 6 || !m3.isEmpty()) {

                        Medico a1 = new Medico(m1, m3, m2);

                        /* DAO que add ao banco de dados */
                        daoMedico.addAtomic(a1);

                        System.out.println();
                        System.out.println("Cadastro Realizado com Sucesso!");

                        break;

                        /*
                         * Caso houver algum item nulo o código acima não será executado fazendo
                         * com que o loop continua até que o usuário digite conforme for pedido.
                         */
                    } else {
                        M_LoginPadrao.TenteNovamente();

                    }

                }

                /* Si a opção 2 for escolhida */
                else if (r2.equals("2")) {

                    System.out.println();
                    System.out.print("Digite seu Nome: ");
                    String p1 = String.valueOf(tec.nextLine().trim());

                    System.out.println();
                    System.out.print("Digite seu Email: ");
                    String p2 = String.valueOf(tec.nextLine().trim());

                    System.out.println();
                    System.out.print("Digite sua Senha: ");
                    String p3 = String.valueOf(tec.nextLine().trim());

                    if (p1 != null || p2 != null || p3 != null) {

                        Paciente pnew = new Paciente(p1, p2, p3);

                        /* DAO que adiciona um novo paciente ao Banco de dados */
                        daoPaciente.addAtomic(pnew);

                        System.out.println();
                        System.out.println("Cadastro Realizado com Sucesso!");

                        break;

                    } else {
                        M_LoginPadrao.TenteNovamente();

                    }

                    /* Si a opção 3 for escolhida */
                } else if (r2.equals("3")) {

                    System.out.println();
                    System.out.print("Digite seu Nome: ");
                    String p1 = String.valueOf(tec.nextLine().trim());

                    System.out.println();
                    System.out.print("Digite seu Senha: ");
                    String p2 = String.valueOf(tec.nextLine().trim());

                    System.out.println();
                    System.out.print("Digite seu CPF: ");
                    String p3 = String.valueOf(tec.nextLine().trim());

                    if (p1 != null || p2 != null || p3.length() == 11) {

                        Recepcionista rec1 = new Recepcionista(p1, p2, p3);

                        /* DAO que adiciona uma nova recepcionista no banco de dados */
                        daoRecepcionista.addAtomic(rec1);

                        System.out.println();
                        System.out.println("Cadastro Realizado com Sucesso!");

                        break;

                    } else {
                        M_LoginPadrao.TenteNovamente();
                    }

                    /* Si a opção 4 for escolhida */
                } else if (r2.equals("4")) {

                    System.out.println();
                    System.out.print("Digite seu Nome: ");
                    String p1 = String.valueOf(tec.nextLine().trim());

                    System.out.println();
                    System.out.print("Digite seu CPF: ");
                    String p2 = String.valueOf(tec.nextLine().trim());

                    System.out.println();
                    System.out.print("Digite seu CRM (6 Digitos):");
                    String p3 = String.valueOf(tec.nextLine().trim());

                    if (p1 != null || p2.length() == 11 || p3.length() == 6) {

                        AdmGeral adm1 = new AdmGeral(p1, p2, p3);

                        /* DAO que adiciona um novo admGeral no banco de dados */
                        daoAdmGeral.addAtomic(adm1);

                        System.out.println();
                        System.out.println("Cadastro Realizado com Sucesso!");

                        break;

                    } else {
                        M_LoginPadrao.TenteNovamente();
                    }

                }

            }

            /*
             * Após o cados ser realizado em qualquer opção selecionada o "break" será
             * acionado,
             * encerrando o loop fazendo com que o método "Login()" seja executado
             */
            System.out.println();
            lg1.Login();

        }

        tec.close();

    }

}
