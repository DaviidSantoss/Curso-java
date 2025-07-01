package C04_Lambdas;

import java.util.function.UnaryOperator;

public class A09_OperadorUnario {
    
    public static void main(String[] args) {
        
        UnaryOperator<Integer> maisDois = n -> n + 2;
        UnaryOperator<Integer> vezesDois = n -> n * 2;
        UnaryOperator<Integer> aoQuadrado = n -> n * n;


        System.out.println(" 4 + 2 => "+maisDois.apply(4));
        System.out.println(" 4 * 2 => "+vezesDois.apply(4));
        System.out.println(" 4 elevado a  2 => "+aoQuadrado.apply(4));

        /*Através do comando "andThen" as funções serão executadas em sequência, e o 
         * resultado esperado é 144.
         */
        int resultado = maisDois.andThen(vezesDois).andThen(aoQuadrado).apply(4);

        System.out.println("O resultado é -> "+resultado);

        /*Já o compose executa as funções de trás pra frente, ou seja a primeira
         * função a ser executada será o "maisDois" depois o "vezesDois" e por final
         * o "aoQuadrado", e o resultado esperado tbm é 1144.
         */
        int resultado2 = aoQuadrado.compose(vezesDois).compose(maisDois).apply(4);
        System.out.println("O resultado é -> "+resultado2);
    }
}
