package C05_Streams;

import java.util.Arrays;
import java.util.List;

public class A08_Outros {

    public static void main(String[] args) {

        A04_Aluno a1 = new A04_Aluno("gui", 8);
        A04_Aluno a2 = new A04_Aluno("leo", 5);
        A04_Aluno a3 = new A04_Aluno("bia", 7);
        A04_Aluno a4 = new A04_Aluno("lia", 9);
        A04_Aluno a5 = new A04_Aluno("sof", 8);
        A04_Aluno a6 = new A04_Aluno("leo", 5);
        A04_Aluno a7 = new A04_Aluno("bia", 7);
        A04_Aluno a8 = new A04_Aluno("let", 9);

        List<A04_Aluno> alunos = Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8);

        /* A stream "distinct" separa os elementos duplicados e não os exibe */
        System.out.println("\nDistintc...");
        alunos.stream().distinct().forEach(System.out::println);

        /*
         * Utilizando o "skip" ele ira pular a quantida de elementos que desejarmos, e o
         * "limit" ira limitar aa quantidade de elementos que "desejarmos".
         */
        System.out.println("\nSkip/Limit");
        alunos.stream().distinct().skip(2).limit(2).forEach(System.out::println);

        /*
         * Já o "takeWhile" faz o seguinte, ele continuara pegando elementos enquanto
         * certa condição
         * for atendida.
         */
        System.out.println("\ntakeWhile");
        alunos.stream().distinct().takeWhile(a -> a.nota >= 7).forEach(System.out::println);
    }
}
