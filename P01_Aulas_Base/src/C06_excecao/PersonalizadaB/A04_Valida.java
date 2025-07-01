package C06_excecao.PersonalizadaB;

import C06_excecao.A01_Aluno;

public class A04_Valida {

    A04_Valida() {
    }

    /*
     * Como nossos "erros personalizados" são checados precisamos declarar de forma
     * explicita na assinatura do método que estamos lançando uma excecao do tipo
     * "StringVaziaExcp" e "IllegalArgumentException"
     */
    public static void aluno(A01_Aluno aluno) throws A04_StringVaziaExcp, A04_NumForaIntervaloExcp {
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
            throw new A04_StringVaziaExcp("nome");
        }

        /*
         * Si a nota do aluno for menor que 0 ou maior que 10, então sera lançada a
         * nossa excecao personalizada.
         */
        if (aluno.nota < 0 || aluno.nota > 10) {
            throw new A04_NumForaIntervaloExcp("nota");
        }
    }

}
