package C04_Lambdas;

import java.util.function.Function;

public class A06_Funcao {
    
    public static void main(String[] args) {
        
        /*Uma "function" receber dois valores um de entrada e um de saida,nessa caso ele 
         * ira receber um inteiro e ira retornar uma String.
        */
        Function<Integer, String> parOuImpar = num -> num % 2 == 0 ? "par" : "impar";
        System.out.println(parOuImpar.apply(3));

       // Function<String, String> oResultadoE = valor -> "O resultado é " + valor;

        /*Aqui concatenamos um função com a outra, através do código "andThen", ou
         * seja após a função "parOuImpar" ser executada então sera chamda a função
         * "oResultadoE"
         */
        //String resultfinal = parOuImpar.andThen(oResultadoE).apply(3);
    }
}
