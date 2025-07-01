package C05_Streams;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class A02_CriandoStreams {
    
    public static void main(String[] args) {
        
        Consumer<String> print = System.out::println;

        /*Essa é uma das maneiras de se criar uma "Stream", utilizando  o código "Strem.of"
         * que é um método statico.
         */
        Stream<String> langs = Stream.of("\njava","lua","js","kobol");
        langs.forEach(print);

        String[] maisLangs = {"\nPython","lisp","Perl","go"};
        Stream.of(maisLangs).forEach(print);

        
    }
}
