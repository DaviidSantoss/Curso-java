package C06_excecao.PersonalizadaA;

import C06_excecao.A01_Aluno;

public class A03_Valida {

    A03_Valida() {
    }

    public static void aluno(A01_Aluno aluno) {
        /*
         * Si o alunos for nulo será lançado um erro do tipo "IllegalArgumentException"
         */
        if (aluno == null) {
            throw new IllegalArgumentException("O aluno está nulo!");
        }

        /*
         * Si o nome do aluno for nulo ou se apenas tiver espaços em branco, sera
         * lançada a excecao personalizada que nós criamos.
         */
        if (aluno.nome == null || aluno.nome.trim().isEmpty()) {
            throw new A03_StringVaziaExcp("nome");
        }

        /*
         * Si a nota do aluno for menor que 0 ou maior que 10, então sera lançada a
         * nossa excecao personalizada.
         */
        if (aluno.nota < 0 || aluno.nota > 10) {
            throw new A03_NumForaIntervaloExcp("nota");
        }
    }

}
