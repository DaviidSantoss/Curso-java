package C05_Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class A03_Map {
    
    public static void main(String[] args) {
        
        Consumer<String> print =  System.out::println;

        List<String> marcas = Arrays.asList("ferrari","bmw","audi");

        /*Utilizamos o map junto com uma expressão lambda, onde deixamos cada
         * elemento em letra maiuscula.
         */
        marcas.stream().map(( m -> m.toUpperCase())).forEach(print);

        UnaryOperator<String> maiuscula = n -> n.toUpperCase();
        /*Como não podemos retornar um "Caracter" porque sempre temos que 
         * retornar um valor do mesmo tipo, então concatenamos com uma string 
         * vazia.
         */
        UnaryOperator<String> primeiraLetra = n -> n.charAt(0) + " ";
        UnaryOperator<String> grito = n -> n + "!!!!";

        System.out.println("\nUsando composição: ");
        marcas.stream().map(maiuscula).map(primeiraLetra).map(grito).forEach(print);

    }
}
