package C07_Generics;

public class A02_CaixaTeste {

    public static void main(String[] args) {

        /*
         * Ao utilizar o generics precisamos especificar o tipo
         * do objeto que desejamos criar.
         */
        A02_Caixa<String> a = new A02_Caixa<>();

        a.guardar("Achou !!");
        System.out.println(a.abrir());
    }
}
