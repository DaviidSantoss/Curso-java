package C04_Lambdas;

import java.util.function.Predicate;

public class A07_PredicadoComp {
    

    public static void main(String[] args) {
        
        /*Predicado é uma função que recebe uma parâmetro
         * de entrada e retorna verdadeiro ou falso.
         */

        Predicate<Integer> isPar = num -> num % 2 == 0;
        Predicate<Integer> isTresDigirtos = tres -> tres >= 100 && tres <= 999;

        if (isPar.test(3)) {
            System.out.println("É par");
        }else{
            System.out.println("É impar");
        }
       
         if (isTresDigirtos.test(999)) {
            System.out.println("O numero possui 3 digitos!");
         }else{
            System.out.println("O número é menor que três digitos!");
         }
    }
}
