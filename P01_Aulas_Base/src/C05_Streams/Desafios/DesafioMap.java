package C05_Streams.Desafios;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;



public class DesafioMap {
    
    public static void main(String[] args) {
        
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);

    
        Function<Integer,String>  bin = b -> Integer.toBinaryString(b);

        Function<String, String> reverse =  n ->  new StringBuilder(n).reverse().toString();

       Function<String, String> decimal = b -> Integer.toString(Integer.parseInt(b, 2));

      
        
       nums.stream().map(bin).map(reverse).map(decimal).forEach(System.out::println);
       
       
    }

    
}
