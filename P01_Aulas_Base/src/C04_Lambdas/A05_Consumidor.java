package C04_Lambdas;

import java.util.function.Consumer;

public class A05_Consumidor {
    
    public static void main(String[] args) {
        
        Consumer<A04_Produto> imprimir = p -> System.out.println(p.nome);

        A04_Produto p1= new A04_Produto("Lava e Seca", 3200.0, 0.2);

        /*Apartir do código "accept" podemos executar o "consumer"  */
        imprimir.accept(p1);
    }
}
