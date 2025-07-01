package C06_excecao.PersonalizadaB;

import C06_excecao.A01_Aluno;

public class A04_TesteValidacao {

    public static void main(String[] args) {

        try {
            A01_Aluno a1 = new A01_Aluno("Ana", -2);
            A04_Valida.aluno(a1);
        } catch (A04_StringVaziaExcp e) {
            System.out.println(e.getMessage());
        } catch (A04_NumForaIntervaloExcp b) {
            System.out.println(b.getMessage());
        }

        System.out.println("fim :)");

    }
}