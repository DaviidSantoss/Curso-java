package C06_excecao;

import java.util.Scanner;

public class A05_Finally {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        try {
            System.out.println(7 / tec.nextInt());
        } catch (Exception e) {
            System.out.println(e.getMessage());

            // O finally sempre sera chamado, esse código server
            // para forçar que um determinado código seja chamado
            // mesmo que ocorra algum tipo de erro
        } finally {
            System.out.println("Finally...");
            tec.close();
        }
    }
}
