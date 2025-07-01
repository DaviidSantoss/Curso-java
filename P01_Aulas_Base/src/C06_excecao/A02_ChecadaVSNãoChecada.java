package C06_excecao;

public class A02_ChecadaVSNãoChecada {

    public static void main(String[] args) {

        /*
         * Utilizamos o try para envolver um código que possa a vir a dar problema,
         * e utilizamos o "catch" para tratar o erro, e como nós lançamos o erro e
         * definimos para ele uma mensagem, utilizamos o "e.getMessage" para podermos
         * pegar a mensagem que escrevemos.
         */
        try {
            geraErro1();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            geraErro2();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("fim");

    }

    // NÃO CHECADA
    static void geraErro1() {
        /*
         * Não basta apenas instânciar um erro é preciso "lançar", e para
         * lançar um erro utilizamos o comando "throw".
         */
        throw new RuntimeException("Ocorreu o primeiro erro!");
    }

    // CHECADA
    static void geraErro2() throws Exception {
        /*
         * Com uma execao checada precisamos deixar claro na assinatura do método
         * que estamos lançando um excecao, e por se tratar de um excecao checada
         * precisamos obrigatoriamente trata-la.
         */
        throw new Exception("Ocorreu o segundo erro!");
    }
}
