package C05_Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class A07_MinMax {

    public static void main(String[] args) {

        A04_Aluno a1 = new A04_Aluno("gui", 8);
        A04_Aluno a2 = new A04_Aluno("leo", 5);
        A04_Aluno a3 = new A04_Aluno("bia", 7);
        A04_Aluno a4 = new A04_Aluno("lia", 9);

        List<A04_Aluno> alunos = Arrays.asList(a1, a2, a3, a4);

        /*
         * Utilizamos o "comparator" para comparar a nota entre dois alunos
         */
        Comparator<A04_Aluno> melhorNota = (aluno1, aluno2) -> {
            if (aluno1.nota > aluno2.nota)
                return 1;
            if (aluno1.nota < aluno2.nota)
                return -1;
            return 0;

        };

        System.out.println(alunos.stream().max(melhorNota).get());
    }

}
