package C06_excecao;

public class A01_Basico {

    public static void main(String[] args) {

        A01_Aluno a1 = null;

        /*
         * O erro ocorrido aqui foi o "NullPointerException" pois passamos
         * um aluno "nulo";
         */
        // imprimirAluno(a1);

        /*
         * Dentro do meu código "try" colocamos um código que pode vir a dar
         * problema, e dentro do "catch" é onde tratamos esse erro
         */
        try {
            imprimirAluno(a1);
        } catch (Exception excecao) {
            System.out.println("Ocorreu um erro pois o aluno é Nullo.");
        }

        /*
         * Ira gerar um erro matemático, pois não é possivel dividir
         * um número por zero
         */
        try {
            System.out.println(7 / 0);
        } catch (ArithmeticException e) {
            /*
             * Com o "printStackTrace" ele nos mostra em que ponto aconteceu
             * o nosso erro
             */
            e.printStackTrace();
        }

        System.out.println("Fim :)");

    }

    public static void imprimirAluno(A01_Aluno aluno) {
        System.out.println(aluno.nome);
    }
}
