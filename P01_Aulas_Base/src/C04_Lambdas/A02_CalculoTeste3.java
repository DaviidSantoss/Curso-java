package C04_Lambdas;

import java.util.function.BinaryOperator;

public class A02_CalculoTeste3 {
    
    public static void main(String[] args) {
        
        
        /*a função "BinaryOperator" recebe dois valores do mesmo tipo e
         * retorna um valor do mesmo tipo indicado.
         */
       BinaryOperator<Double> soma = (x,y) -> {return x + y;};

        System.out.println(soma.apply(2.0, 3.0));
        
        /*Quando não si coloca par de chaves de forma explicita
         * o "return" fica implicito.
         */
        soma = (x,y) -> x * y;

        System.out.println(soma.apply(2.0, 3.0));

    }
}
