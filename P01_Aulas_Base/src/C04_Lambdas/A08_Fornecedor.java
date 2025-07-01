package C04_Lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class A08_Fornecedor {
    
    public static void main(String[] args) {
        
        /*A função Supplier não recebe nenhum parametro 
         * mas te retorna algo.
         */

         Supplier<List<String>> umaLista = () -> Arrays.asList("Bia","Lia","Gui","Leo");

         System.out.println(umaLista.get());
    }
}
