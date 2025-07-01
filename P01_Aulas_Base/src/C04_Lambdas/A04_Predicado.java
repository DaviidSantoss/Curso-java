package C04_Lambdas;

import java.util.function.Predicate;

public class A04_Predicado {
    
    public static void main(String[] args) {
        
        /*A função predicate do tipo produto retornará um valor boolean, e esse código nos
         * diz o seguinte, si "prod" vezes o desconto for maior ou igual a "750" então sera
         * retornado true
         */
        Predicate<A04_Produto> isCaro = prod -> (prod.preco * (1 - prod.desconto)) >= 750; 

        A04_Produto p1 = new A04_Produto("Relogio", 1500.0, 0.2);

        /*Si a expressão "isCaro" for verdadeira o print sera executado */
        if(isCaro.test(p1) == true ){
            System.out.println("O produto é muito caro! ");
        }else{
            System.out.println("Compra que ta barato! ");
        }
    
    
    
    }
}
