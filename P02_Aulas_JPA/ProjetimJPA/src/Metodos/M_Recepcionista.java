package Metodos;

import java.util.List;
import java.util.Scanner;

import Banco.Consulta;
import Banco.Medico;
import Banco.Paciente;
import Banco.Recepcionista;
import Infra.DAO;

public class M_Recepcionista {

    /* DAOs instânciados */
    DAO<Consulta> daoConsultas = new DAO<>(Consulta.class);
    DAO<Paciente> daoPaciente = new DAO<>(Paciente.class);
    DAO<Medico> daoMedico = new DAO<>(Medico.class);
    DAO<Recepcionista> daoRecp = new DAO<>(Recepcionista.class);

    /* Scanner */
    Scanner tec = new Scanner(System.in);

    /* Método login */
    public void LoginRecp() {

        while (true) {

            System.out.println();
            System.out.print("Digite Seu CPF: ");
            String cpf = String.valueOf(tec.nextLine().trim());

            System.out.println();
            System.out.print("Digite sua Senha: ");
            String senha = String.valueOf(tec.nextLine());

            if (!cpf.trim().isEmpty() && !senha.trim().isEmpty()) {

                /*
                 * Método que verifica se os objetos passados pelo usuário existem no banco de
                 * dados
                 */
                boolean verificaRecp = daoRecp.VerificarLogin(cpf, senha, "senha", "CPF", "Recepcionista");

                if (verificaRecp) {

                    System.out.println();
                    OpcoesRecp(cpf, senha);
                    break;

                } else {
                    System.out.println();
                    System.out.println("CPF ou senha Invalidos!");

                }
            }

        }

    }

    public void OpcoesRecp(String cfp, String senha) {

        while (true) {

            System.out.println();
            System.out.println("1-Médicos disponiveis");
            System.out.println("2-Agendar Consultas");
            System.out.println("3-Desligar");

            String recp1 = String.valueOf(tec.nextLine());

            if (recp1.equalsIgnoreCase("1")) {

                System.out.println();
                System.out.println("Médicos: ");

                System.out.println();
                Medicos();

            } else if (recp1.equalsIgnoreCase("2")) {

                System.out.println();
                System.out.println("Pacientes: ");
                Pacientes();

                System.out.println();
                System.out.print("Digite a Descrição da Consulta: ");
                String desc = String.valueOf(tec.nextLine());

                System.out.println();
                System.out.print("Digite o Horário: ");
                String hora = String.valueOf(tec.nextLine());

                System.out.println();
                System.out.print("Digite o ID do Paciente: ");
                Long idPaciente = Long.parseLong(tec.nextLine());

                Paciente paciente = daoPaciente.BuscasUsuario(Paciente.class, idPaciente);

                if (paciente == null) {
                    System.out.println("Usuário não encontrado! ");

                }

                /* Criando uma nova consulta */
                Consulta c1 = new Consulta(desc, hora, paciente);

                /* Adicionando a consulta no banco de dados */
                daoConsultas.addAtomic(c1);

                System.out.println();
                System.out.println("Consulta Agendada com Sucesso!");
                System.out.println();

            } else if (recp1.equalsIgnoreCase("3")) {
                break;
            } else {
                System.out.println();
                System.out.println("Comando inválido Tente Novamente!");
            }

        }

    }

    /* Método que exibe os médicos presente no banco de dados */
    public void Medicos() {

        List<Medico> medicos = daoMedico.buscarObjetos("Medico");

        for (Medico medico : medicos) {

            System.out.println("Nome: " + medico.getNome());
        }
    }

    /* Método que exibe os pacientes no banco de dados */
    public void Pacientes() {

        List<Paciente> Pacientes = daoPaciente.buscarObjetos("Paciente");

        System.out.println();
        System.out.println();

        for (Paciente paciente : Pacientes) {

            System.out.println("ID: " + paciente.getId() + " Nome: " + paciente.getNome());

        }
    }

}
