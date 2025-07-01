package C05_Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class A06_Match {
    
    public static void main(String[] args) {
        
         A04_Aluno a1 = new A04_Aluno("gui", 8);
        A04_Aluno a2 = new A04_Aluno("leo", 5);
        A04_Aluno a3 = new A04_Aluno("bia", 7);
        A04_Aluno a4 = new A04_Aluno("lia", 9);

        List<A04_Aluno> alunos = Arrays.asList(a1,a2,a3,a4);


        Predicate<A04_Aluno> aprovados = a -> a.nota >= 7 ;

        /*A stream "allMatch" nos diz o seguinte "todos os alunos estão
        aprovados?", como um aluno não esta aprovado o resultado sera "false" */
        System.out.println(alunos.stream().allMatch(aprovados));

        /*Já o "anyMatch" nos diz o seguinte "algum aluno foi aprovado?" como
         * varios alunos foram aprovados o resultado sera "true".
         */
        System.out.println(alunos.stream().anyMatch(aprovados));

        /*O codigo "noneMatch" nos diz "Ninguem está aprovado?" como há 
         * pessoas aprovadas o resultado sera "false".
         */
        System.out.println(alunos.stream().noneMatch(aprovados));
    }
}
