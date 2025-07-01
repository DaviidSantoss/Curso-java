package Metodos;

import java.util.List;
import java.util.Scanner;

import Banco.Consulta;
import Banco.Medico;
import Banco.Paciente;
import Infra.DAO;

public class M_Medico {

    /* DAOs instânciados */
    DAO<Medico> daoMedico = new DAO<>(Medico.class);
    DAO<Consulta> daoConsultas = new DAO<>(Consulta.class);
    DAO<Paciente> daoPaciente = new DAO<>(Paciente.class);

    /* Scanner */
    Scanner tec = new Scanner(System.in);

    /* Método de login */
    public void loginMedico() {

        while (true) {

            /* Criamos um Dao do tipo médico */

            /* Requisição para o login */
            System.out.print("Digite seu CRM(6 Digitos):");
            String crm = tec.nextLine();

            System.out.print("Digite sua Senha:");
            String senha = tec.nextLine();

            /*
             * método que verifica os dados que foram digitados para realizar o login,
             * si o "crm" não estiver vazio e se a "senha" não estiver vazia então
             * execute o método de baixo.
             */
            if (!crm.trim().isEmpty() || !senha.trim().isEmpty()) {

                /*
                 * Método do tipo "boolean" (true or false) que verifica se o crm e senha
                 * informados pelo usuário realmente existem.
                 */
                Boolean verificacao = daoMedico.VerificarLogin(crm, senha, "CRM", "senha", "Medico");

                /*
                 * Si os dados forem "true" então o método "pegarNome" será executado,
                 * fazendo com que o nome do usuário logado no sistema fique sendo
                 * exibido.
                 */
                if (verificacao) {
                    System.out.println();

                    System.out.println();
                    opcoesMedico(crm, senha);

                } else {
                    System.out.println();
                    System.out.println("Crm ou senha inválidos.Tente Novamente!");
                    System.out.println();
                }
            }

        }

    }

    /* Opções do que o médico possui */
    public void opcoesMedico(String crm, String senha) {

        /* Enquanto a condição permanecer verdadeira execute o código abaixo */
        while (true) {

            /*
             * Método que pega o nome do médico, tendo como parâmetro a senha e o
             * crm.
             */
            System.out.println();
            String nome = daoMedico.PegarNome(crm, senha, "CRM", "senha", "Medico");
            System.out.println("Usuario: " + nome);

            System.out.println();
            System.out.println("1-Consultas.");
            System.out.println("2-Agendar Consultas.");
            System.out.println("3-Desmarcar Consultas.");
            System.out.println("4-Alterar Consultas.");
            System.out.println("5-Desligar.");

            String m1 = String.valueOf(tec.nextLine().trim());

            /* VER AS CONSULTAS */
            if (m1.equalsIgnoreCase("1")) {

                System.out.println();
                System.out.println("Suas Consultas do dia São: ");

                Consultas();

                /* AGENDAR CONSULTAS */
            } else if (m1.equalsIgnoreCase("2")) {

                System.out.println();
                Pacientes();

                System.out.println();
                System.out.print("Digite a Descrição da Consulta: ");
                String desc = String.valueOf(tec.nextLine().trim());

                System.out.println();
                System.out.print("Digite o Horário: ");
                String hora = String.valueOf(tec.nextLine().trim());

                System.out.println();
                System.out.print("Digite o ID do Paciente: ");
                Long idPaciente = Long.valueOf(tec.nextLong());

                /* Método que busca o usuário no banco de dados atráves do Id do usuário */
                Paciente paciente = daoPaciente.BuscasUsuario(Paciente.class, idPaciente);

                if (paciente == null) {

                    System.out.println("Usuário não encontrado!");
                }

                /* Criando a nova consulta */
                Consulta c1 = new Consulta(desc, hora, paciente);

                /* Adicionando a nova consulta no banco de dados */
                daoConsultas.addAtomic(c1);

                System.out.println();
                System.out.println("Consulta Agendada com Sucesso!");
                System.out.println();

                /* DESMARCAR CONSULTAS */
            } else if (m1.equalsIgnoreCase("3")) {

                System.out.println();
                System.out.println("Consultas: ");

                Consultas();

                System.out.println();
                System.out.print("Digite a consulta que deseja Desmarcar: ");
                Long cs = Long.valueOf(tec.nextLong());

                /* Removendo a consulta do banco de dados */
                daoConsultas.removeForId(cs);

                System.out.println();
                System.out.println("Consulta Desmarcada com Sucesso!");
                System.out.println();

                /* ALTERAR CONSULTA */
            } else if (m1.equalsIgnoreCase("4")) {

                Consultas();

                System.out.println();
                System.out.println("Digite a Consulta que deseja Editar: ");
                Long consId = Long.valueOf(tec.nextLong());

                if (consId != null) {

                    /* Dao que busca o usuário */
                    Consulta c1 = daoConsultas.BuscasUsuario(Consulta.class, consId);

                    System.out.println();
                    System.out.println("O que deseja Alterar?");

                    System.out.println();
                    System.out.println("1-Descrição ");
                    System.out.println("2-Horário.");
                    String alter1 = String.valueOf(tec.nextLine().trim());

                    if (alter1.equalsIgnoreCase("1")) {

                        System.out.print("Descrição: ");
                        String desc1 = tec.nextLine();

                        /* Setando a nova discrição no banco de dados */
                        c1.setDescrição(desc1);

                        /* Aplicando a nova discrição setada */
                        daoConsultas.addAtomic(c1);

                        System.out.println();
                        System.out.println("Descrição Alterada com Sucesso!");

                        break;

                    } else if (alter1.equalsIgnoreCase("2")) {

                        System.out.print("Horário: ");
                        String hor1 = String.valueOf(tec.nextLine().trim());

                        /* Setando o novo horario no banco de dados */
                        c1.setHorario(hor1);

                        /* Aplicando o novo horário setado */
                        daoConsultas.addAtomic(c1);

                        System.out.println();
                        System.out.println("Horário Alterado com Sucesso!");

                    }

                }

                /* Sair */
            } else if (m1.equalsIgnoreCase("5")) {

                break;

            }

        }

    }

    /* Metodo para buscar consulta */
    public void Consultas() {

        List<Consulta> consultas = daoConsultas.buscarObjetos("Consulta");

        System.out.println();
        System.out.println();

        for (Consulta consultaResult : consultas) {

            System.out.println("Consulta ID: " + consultaResult.getId() + ", Nome: "
                    + consultaResult.getPaciente().getNome() + ", Descrição: " + consultaResult.getDescrição()
                    + ", Horario: " + consultaResult.getHorario());

        }

    }

    /* Método para buscar os pacientes */
    public void Pacientes() {

        List<Paciente> Pacientes = daoPaciente.buscarObjetos("Paciente");

        System.out.println();
        System.out.println();

        for (Paciente paciente : Pacientes) {

            System.out.println("ID: " + paciente.getId() + " Nome: " + paciente.getNome());

        }
    }

}
