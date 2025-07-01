package C04_Lambdas;

/*Implementamos a inteface "Calculos" assim tornado
    obrigatorio  a adição dos métodos.
 */
public class A01_Soma implements A01_Calculos{
    
    @Override
    public double executar(double a, double b) {
       return a + b;
    }
}
