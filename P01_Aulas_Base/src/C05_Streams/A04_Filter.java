package C05_Streams;

import java.util.Arrays;
import java.util.List;

public class A04_Filter {
    
    public static void main(String[] args) {
        

        A04_Aluno a1 = new A04_Aluno("David", 10);
        A04_Aluno a2 = new A04_Aluno("gui", 8);
        A04_Aluno a3 = new A04_Aluno("bia", 6);
        A04_Aluno a4 = new A04_Aluno("lia", 7);

        List<A04_Aluno> aprovados =  Arrays.asList(a1,a2,a3,a4);

        /*Utilizamos a stream "filter" onde ela faz o filtro baseado nos parâmtros que passamos, 
         * nesse caso o nosso "filter" filtra as notas maiores ou igual a 7.
         */
        aprovados.stream().filter(a -> a.nota >=  7).map(a -> "Parabens " + a.nome + " Você foi aprovado .").forEach(System.out::println);
    }
}
