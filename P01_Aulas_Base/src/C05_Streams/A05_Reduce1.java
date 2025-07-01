package C05_Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class A05_Reduce1 {
    
    public static void main(String[] args) {
        
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);


      BinaryOperator<Integer> soma = (ac,n) -> ac + n;
    
      //o reduce retorna um "opcional de inteiro" e por isso 
      //utilizamos o get para pegar o valor gerado.
      int total = nums.stream().reduce(soma).get();

      System.out.println(total);

      //como passamos o número 100 como o número inicial, o resultado
      //gerado sera do tipo int, sendo assim não precisamos utilizar o "get".
      int total2 = nums.stream().reduce(100, soma);

      System.out.println(total2);

      /*Nesse codigo utilizamos o filter para pegar apenas os números maiores que 5,
       * após isso aplicamos o reduce "soma" que ira somar todos os números maiores
       * que 5, i si o valor gerado estiver "presente" ou seja não nulo, o print
       * sera executado.
       */
      nums.stream().filter(n -> n > 5).reduce(soma).ifPresent(System.out::println);
    }
}
