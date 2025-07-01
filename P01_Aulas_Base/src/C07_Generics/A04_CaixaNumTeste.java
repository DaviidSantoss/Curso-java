package C07_Generics;

public class A04_CaixaNumTeste {

    public static void main(String[] args) {

        A04_CaixaNum<Double> a = new A04_CaixaNum<>();
        a.guardar(2.3);
        System.out.println(a.abrir());

        A04_CaixaNum<Integer> b = new A04_CaixaNum<>();
        b.guardar(42);
        System.out.println(b.abrir());
    }
}
