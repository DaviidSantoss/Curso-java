package C05_Streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class A01_imprimindoObjetos {
    
    public static void main(String[] args) {
        
        List<String> aprovados = Arrays.asList("bia","lia","gui","leo");


            System.out.println("\nUsando foreach: ");
            for (String nome : aprovados) {
                System.out.println(nome);
            }

            /*Com o iterator, podemos utilizar o código "hasNext" ou em português "tem proximo",
             * enquanto tiver algum elemento proximo ele continuara executando o código.
             */
            System.out.println("\nUsando Iterator: ");
             Iterator<String> it = aprovados.iterator();
             
             while (it.hasNext()) {
                System.out.println(it.next());
             }

             System.out.println("\nUsando Stream: ");
             Stream<String> stream = aprovados.stream();
             stream.forEach(System.out::println);
    }
}
