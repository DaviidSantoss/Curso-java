package Metodos;

import java.util.Scanner;

import Banco.Consulta;
import Banco.Paciente;
import Infra.DAO;
import java.util.List;

public class M_Paciente {

    /* DAOs instânciados */
    DAO<Paciente> daoPaciente = new DAO<>(Paciente.class);
    DAO<Consulta> daoConsulta = new DAO<>(Consulta.class);

    /* Escaner */
    Scanner tec = new Scanner(System.in);

    /* Método de login */
    public void LoginPaciente() {

        while (true) {

            System.out.println();
            System.out.print("Digite seu email: ");
            String email = String.valueOf(tec.nextLine().trim());
            System.out.println();

            System.out.println();
            System.out.print("Digite sua senha: ");
            String senha = String.valueOf(tec.nextLine().trim());
            System.out.println();

            if (!email.trim().isEmpty() || !senha.trim().isEmpty()) {

                /*
                 * Método que verifica se o objetos informados pelo usuário estão no banco de
                 * dados
                 */
                boolean verificacao = daoPaciente.VerificarLogin(email, senha, "email", "senha", "Paciente");

                if (verificacao) {

                    System.out.println();
                    OpcoesPaciente(email, senha);

                    break;

                } else {
                    System.out.println();
                    System.out.println("Login inválido.Tente Novamente!");
                }

            }

        }

    }

    public void OpcoesPaciente(String email, String senha) {

        while (true) {

            /* Pegando o nome do Paciente */
            String nomePaciente = daoPaciente.PegarNome(email, senha, "email", "senha", "Paciente");
            System.out.println("Usuario: " + nomePaciente);

            System.out.println();
            System.out.println("1-Marcar Consulta.");
            System.out.println("2-Sair.");

            String p1 = String.valueOf(tec.nextLine().trim());

            if (p1.equalsIgnoreCase("1")) {

                System.out.println();
                System.out.print("Digite a Descrição da Consulta: ");
                String consul = String.valueOf(tec.nextLine().trim());

                System.out.println();
                System.out.print("Digite o Horário: ");
                String horario = String.valueOf(tec.nextLine().trim());

                // verifico o paciente

                List<Paciente> pacientes = daoPaciente.buscarObjetosEspecificos(
                        "Paciente", "email", "senha", email, senha, Paciente.class);

                if (pacientes != null && !pacientes.isEmpty()) {

                    Paciente paciente2 = pacientes.get(0);

                    // adiciono o paciente
                    daoPaciente.addAtomic(paciente2);

                    // crio a consulta
                    Consulta c1 = new Consulta(consul, horario);

                    // seto o paciente verificado na consulta
                    c1.setPaciente(paciente2);

                    // adiciono a consulta
                    daoConsulta.addAtomic(c1);

                    System.out.println();
                    System.out.println("Consulta Marcada com Sucesso!");
                    System.out.println();

                } else {
                    System.out.println();
                    System.out.println("Paciente não encontrado");
                }

            } else if (p1.equalsIgnoreCase("2")) {
                break;

            }

        }

    }
}