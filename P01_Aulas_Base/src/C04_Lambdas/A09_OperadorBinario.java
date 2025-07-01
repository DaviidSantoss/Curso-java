package C04_Lambdas;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class A09_OperadorBinario {
    
    public static void main(String[] args) {
        
        /*Um operador binario recebe dois valores de entrada do mesmo tipo, e retorna
         * um valor de saida do mesmo tipo, não é possivel utilizar composição com um
         * operador binario pois ele contém dois parâmetros de entrada, porém é possivel
         * fazer composição com o valor que ele retorna.
         */
        BinaryOperator<Double> media = (Double n1, Double n2) -> (n1 + n2) / 2;
        System.out.println(media.apply(10.0, 8.5));

        /*Uma "BiFunction" recebe dois valores de entrada e pode vir a retornar um valor diferente na saida,
         * como nessa função que recebe "double" como parâmetro e retorna uma "String".
         */
        BiFunction<Double,Double,String> mediaCompleta = (n1,n2) -> ((n1+n2) / 2) >= 7 ? "Aprovado" : "Reprovado";
        System.out.println(mediaCompleta.apply(10.0, 4.3));

        Function<Double,String> conceito = m -> m >=7 ? "Aprovado" : "Reprovado";

        System.out.println(media.andThen(conceito).apply(7.0, 6.8));
    }
}
