package C05_Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class A05_Reduce2 {
    
    public static void main(String[] args) {
        
        A04_Aluno a1 = new A04_Aluno("gui", 8);
        A04_Aluno a2 = new A04_Aluno("leo", 5);
        A04_Aluno a3 = new A04_Aluno("bia", 7);
        A04_Aluno a4 = new A04_Aluno("lia", 9);

        List<A04_Aluno> alunos = Arrays.asList(a1,a2,a3,a4);

        /*O "predicate" retorna apenas true or false, ou seja para todas as notas maiores ou
         * iguais a 7 ele ira retornar true.
         */
        Predicate<A04_Aluno> aprovados = a -> a.nota >= 7 ;

        /*Essa function ira apenas nos retornar as notas dos alunos */
        Function<A04_Aluno,Double> notaAluno = a -> a.nota;

        /*Esse " BinaryOperator" ira receber  duas notas e ira fazer a soma entre elas.  */
        BinaryOperator<Double> somatorio = (a,b) -> a + b;

        alunos.stream().filter(aprovados).map(notaAluno).reduce(somatorio).ifPresent(System.out::println);;

    
    }
}
