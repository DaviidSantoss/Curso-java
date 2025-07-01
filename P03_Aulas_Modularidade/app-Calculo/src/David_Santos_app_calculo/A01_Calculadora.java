package David_Santos_app_calculo;

import David_Santos_app_Loggin.A02_Logger;
import David_Santos_app_calculo.Interno.A01_OpsAritmeticas;

public class A01_Calculadora {

    @SuppressWarnings("unused")
    private String idString = "abc";

    /*
     * Criamos uma classe interna onde teremos a implementação real do método
     * "soma", porém não queremos torna-la visível fora do módulo, então criamos a
     * classe "A01_Calculadora" onde essa classe usa a classe interna e essa classe
     * "A01_Calculadora" será exposta para fora do módulo.
     */
    private A01_OpsAritmeticas OpAritimeticas = new A01_OpsAritmeticas();

    /*
     * Utilizamos a função "Delegate Methods" onde delegamos o método da classe
     * "A01_OpsAritmeticas" para a classe "A01_Calculadora" que será exposta fora do
     * módulo.
     */
    public double soma(double... nums) {

	A02_Logger.info("Somando");
	return OpAritimeticas.soma(nums);
    }

}
