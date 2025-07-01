package C07_Generics;

public class A06_ParesTeste {

    public static void main(String[] args) {

        A06_Pares<Integer, String> resultadoConcurso = new A06_Pares<>();

        resultadoConcurso.add(1, "joão");
        resultadoConcurso.add(2, "gui");
        resultadoConcurso.add(3, "lia");
        resultadoConcurso.add(1, "Julia");

        System.out.println(resultadoConcurso.getvalor(1));
    }
}
