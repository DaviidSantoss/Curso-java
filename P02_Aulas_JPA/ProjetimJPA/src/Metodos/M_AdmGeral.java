package Metodos;

import java.util.List;
import java.util.Scanner;

import Banco.AdmGeral;
import Banco.Medico;
import Banco.Recepcionista;
import Infra.DAO;

public class M_AdmGeral {

    Scanner tec = new Scanner(System.in);

    DAO<AdmGeral> daoAdm = new DAO<>(AdmGeral.class);
    DAO<Medico> daoMedico = new DAO<>(Medico.class);
    DAO<Recepcionista> daoRec = new DAO<>(Recepcionista.class);

    public void LoginAdmGeral() {

        while (true) {

            /* Requisição para o login */
            System.out.print("Digite seu CRM(6 Digitos):");
            String crm = String.valueOf(tec.nextLine().trim());

            System.out.print("Digite seu CPF(11 Digitos)");
            String cpf = String.valueOf(tec.nextLine().trim());

            if (!crm.trim().isEmpty() || !cpf.trim().isEmpty()) {

                Boolean verificacao = daoAdm.VerificarLogin(crm, cpf, "CRM", "cpf", "AdmGeral");

                if (verificacao) {

                    System.out.println();

                    System.out.println();

                    OpcoesAdmGeral(crm, cpf);

                } else {
                    System.out.println();
                    System.out.println("Cpf ou Crm inválidos, Tente Novamente");
                    System.out.println();

                }
            }

        }

    }

    public void OpcoesAdmGeral(String crm, String cpf) {

        while (true) {

            /*
             * Método que pega o nome do usuário no banco de dados através do que foi
             * passado como parâmetro
             */
            String nome = daoAdm.PegarNome(crm, cpf, "CRM", "cpf", "AdmGeral");
            System.out.println("Usuário: " + nome);

            System.out.println();
            System.out.println("Opções:");
            System.out.println();

            System.out.println("1-Gerênciar Médicos");
            System.out.println("2-Gerênciar Recepcionista");
            System.out.println("3-Desligar");

            String op1 = String.valueOf(tec.nextLine());

            if (op1.equalsIgnoreCase("1")) {

                System.out.println();
                System.out.println("Medicos: ");
                System.out.println();
                System.out.println("1-Demitir");
                System.out.println("2-Contratar");

                String op2 = String.valueOf(tec.nextLine());

                if (op2.equalsIgnoreCase("1")) {

                    System.out.println();
                    selectMedicos();

                    System.out.println();
                    System.out.print("Digite o Id que deseja Remover: ");
                    Long opc3 = Long.valueOf(tec.nextLong());

                    tec.nextLine();

                    if (opc3 != null) {

                        /* Dao que remove o usuário do banco de dados */
                        daoMedico.removeForId(opc3);

                        System.out.println();
                        System.out.println("Usuário Demitido com Sucesso!");
                        System.out.println();

                    } else {

                        System.out.println();
                        System.out.println("Erro.Tente Novamente!");
                        System.out.println();
                    }

                } else if (op2.equalsIgnoreCase("2")) {

                    System.out.println();
                    System.out.print("Digite o ID: ");
                    Long id = Long.valueOf(tec.nextLong());

                    tec.nextLine();

                    System.out.println();
                    System.out.print("Digite o nome: ");
                    String nomeM = String.valueOf(tec.nextLine().trim());

                    System.out.println();
                    System.out.print("Digite o senha: ");
                    String senhaM = String.valueOf(tec.nextLine().trim());

                    System.out.println();
                    System.out.print("Digite o CRM: ");
                    String crmM = String.valueOf(tec.nextLine().trim());

                    if (!nomeM.trim().isEmpty() && !senhaM.trim().isEmpty() && !crmM.trim().isEmpty()) {

                        /* Criando um novo médico */
                        Medico m1 = new Medico(nomeM, senhaM, crmM, id);

                        /* Adicionando o médico ao banco de dados */
                        daoMedico.addAtomic(m1);

                        System.out.println();
                        System.out.println("Contratado com Sucesso!");
                        System.out.println();

                    } else {

                        System.out.println();
                        System.out.println("Erro.Tente Novamente!");
                        System.out.println();

                    }

                }

            } else if (op1.equalsIgnoreCase("2")) {

                System.out.println();
                System.out.println("Recepcionista: ");
                System.out.println();
                System.out.println("1-Demitir");
                System.out.println("2-Contratar");

                String opc4 = String.valueOf(tec.nextLine());

                if (opc4.equalsIgnoreCase("1")) {

                    System.out.println();
                    selectRec();

                    System.out.println();
                    System.out.print("Digite o Id que deseja Remover: ");
                    Long recp1 = Long.valueOf(tec.nextLong());

                    /* Limpar cache */
                    tec.nextLine();

                    if (recp1 != null) {

                        /* Método que remove o usuário do banco de dados */
                        daoRec.removeForId(recp1);

                        System.out.println();
                        System.out.println("Usuário Demitido com Sucesso!");
                        System.out.println();

                    } else {

                        System.out.println();
                        System.out.println("Erro.Tente Novamente!");
                        System.out.println();

                    }

                } else if (opc4.equalsIgnoreCase("2")) {

                    System.out.println();
                    System.out.print("Digite o ID: ");
                    Long idR = Long.valueOf(tec.nextLong());

                    /* Limpar cache */
                    tec.nextLine();

                    System.out.println();
                    System.out.print("Digite o nome: ");
                    String nomeR = String.valueOf(tec.nextLine());

                    System.out.println();
                    System.out.print("Digite o senha: ");
                    String senhaR = String.valueOf(tec.nextLine());

                    System.out.println();
                    System.out.print("Digite o CPF: ");
                    String cpfR = String.valueOf(tec.nextLine());

                    if (!nomeR.trim().isEmpty() && !senhaR.trim().isEmpty() && !cpfR.trim().isEmpty()) {

                        /* Criando uma nova recepcionista */
                        Recepcionista rc1 = new Recepcionista(nomeR, senhaR, cpfR, idR);

                        /* Adicionando a recepcionista no banco de dados */
                        daoRec.addAtomic(rc1);

                        System.out.println();
                        System.out.println("Contratado com Sucesso!");
                        System.out.println();

                    } else {
                        System.out.println();
                        System.out.println("Erro.Tente Novamente!");
                        System.out.println();
                    }

                }

            }

        }

    }

    /* Método para procurar os médicos */
    public void selectMedicos() {

        List<Medico> medicos = daoMedico.buscarObjetos("Medico");

        for (Medico medico : medicos) {
            System.out.println(
                    "ID: " + medico.getId() + ", Nome: " + medico.getNome() + ", CRM: " + medico.getCRM());
        }
    }

    /* Método para procurar as Recepcionista */
    public void selectRec() {

        List<Recepcionista> recepcionistas = daoRec.buscarObjetos("Recepcionista");

        for (Recepcionista recp : recepcionistas) {
            System.out.println(
                    "ID: " + recp.getId() + ", Nome: " + recp.getNome());
        }
    }

}
