package C06_excecao.PersonalizadaA;

import C06_excecao.A01_Aluno;

public class A03_TesteValidacao {

    public static void main(String[] args) {

        try {
            A01_Aluno a1 = new A01_Aluno("Ana", -2);
            A03_Valida.aluno(a1);
        } catch (A03_StringVaziaExcp e) {
            System.out.println(e.getMessage());
        } catch (A03_NumForaIntervaloExcp b) {
            System.out.println(b.getMessage());
        }

        System.out.println("fim :)");

    }
}