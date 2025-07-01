package C07_Generics;

public class A01_CaixaObjetoTeste {

    public static void main(String[] args) {

        /*
         * Essa é uma classe sem generics, onde estamos utilizando
         * o casting para fazer a conversão de tipos.
         */
        A01_CaixaObjeto caixaA = new A01_CaixaObjeto();

        caixaA.guardar(2.3);

        Double coisa = (Double) caixaA.abrir();
        System.out.println(coisa);
    }
}
