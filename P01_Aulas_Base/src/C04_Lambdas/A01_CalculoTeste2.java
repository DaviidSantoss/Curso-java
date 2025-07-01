package C04_Lambdas;

public class A01_CalculoTeste2 {
    
    public static void main(String[] args) {
        
        /*"soma" é do tipo "Calculos", sendo assim conseguimos 
         * associar uma "lambda function" ao método da interface
         * "Calculos".
         */
        A01_Calculos soma = (x,y) -> {return x + y;};

        System.out.println(soma.executar(2, 3));
        
        /*Quando não si coloca par de chaves de forma explicita
         * o "return" fica implicito.
         */
        soma = (x,y) -> x * y;

        System.out.println(soma.executar(2, 3));

    }
}
