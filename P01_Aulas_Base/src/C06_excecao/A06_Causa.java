package C06_excecao;

public class A06_Causa {

    public static void main(String[] args) {

        /*
         * O metodoA é passado como "nulo", i si "e.getCause" for não nulo então um
         * print
         * contendo o "e.getCasue().getMessage()" será exibido.
         */
        try {
            metodoA(null);
        } catch (IllegalArgumentException e) {
            if (e.getCause() != null) {
                System.out.println(e.getCause().getMessage());

            }
        }
    }

    /*
     * O metodoA recebe um aluno como parâmetro, e o metodoA contém dentro de si o
     * métodoB, i si o métodoB apresentar algum erro, sera lançado um
     * "IllegalArgumentException".
     */
    static void metodoA(A01_Aluno aluno) {
        try {
            metodoB(aluno);
        } catch (Exception causa) {
            throw new IllegalArgumentException(causa);
        }
    }

    /*
     * O metodoB recebe um aluno com parâmetro, i si o aluno for igual a "nullo
     * então um erro de " NullPointerException" sera lançado com a mensagem
     * "O aluno está nulo", caso contrario o nome do aluno será exibido.
     */
    static void metodoB(A01_Aluno aluno) {
        if (aluno == null) {
            throw new NullPointerException("O aluno está nulo");
        }
        System.out.println(aluno.nome);
    }
}
