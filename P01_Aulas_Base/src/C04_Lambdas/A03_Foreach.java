package C04_Lambdas;

import java.util.Arrays;
import java.util.List;

public class A03_Foreach {
    

    public static void main(String[] args) {
        

        List<String> aprovados = Arrays.asList("Ana","pedro","gui");

        
        System.out.println("Metodo Tradicional: ");
        for (String alunos : aprovados) {
            System.out.println(alunos);
        }

        System.out.println("\nLambda #01");

        /*Esse codigo nos quer dizer o seguinte, para cada elemento da lista execute
         * a função print.
         */
        aprovados.forEach(nome -> System.out.println(nome + "!!"));

        /*Para cada elemento da lista "Aprovados" chame a referência "println" */
        System.out.println("\nMethod Reference: ");
        aprovados.forEach(System.out::println);

        /*Percorra a lista "aprovados" e chame o método "meuImprimir" */
        System.out.println("\nLambda #02 ");
        aprovados.forEach(nome -> meuImprimir(nome));


        
    }
    static void meuImprimir(String nome){
        System.out.println("Ola Mundo, eu sou "+ nome);
    }
}
