package Metodos;

import java.util.Scanner;

public class M_LoginPadrao {

    Scanner tec = new Scanner(System.in);

    /* Classes Instânciadas */
    M_Medico m1 = new M_Medico();
    static M_Paciente p1 = new M_Paciente();
    static M_Recepcionista r1 = new M_Recepcionista();
    static M_AdmGeral a1 = new M_AdmGeral();

    /* Método estatico que contém as opções */
    public static void Opcoes() {

        System.out.println();
        System.out.println("Efetuar Login Como: ");
        System.out.println();

        System.out.println("1-Médico");
        System.out.println("2-Paciente");
        System.out.println("3-Recepscionista");
        System.out.println("4-Administrador Geral");
        System.out.println();
        System.out.print("Digite sua Opção: ");

    }

    public void Login() {

        /* Método "Opcoes" */
        Opcoes();

        String r2 = tec.nextLine();

        if (r2.equalsIgnoreCase("1")) {

            /* Instânciamos a classe médico */

            /* Método de login do médico */
            m1.loginMedico();

        } else if (r2.equalsIgnoreCase("2")) {

            p1.LoginPaciente();

        } else if (r2.equalsIgnoreCase("3")) {

            r1.LoginRecp();

        } else if (r2.equalsIgnoreCase("4")) {

            a1.LoginAdmGeral();

        }

    }

    /*
     * Método para retornar a mensagem de erro.OBS: métodos estáticos pertencem à
     * classe em vez de pertencerem a uma instância específica da classe, sendo
     * assim esse método "TenteNovamente" pertence somente a nossa classe
     * "TestePrincipal" podendo ser chamado da seguinte forma "TenteNovamente();"
     */
    public static void TenteNovamente() {
        System.out.println();
        System.out.println("Tente Novamente!");
    }

}
