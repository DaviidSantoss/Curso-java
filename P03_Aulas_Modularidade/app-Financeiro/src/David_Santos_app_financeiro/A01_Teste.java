package David_Santos_app_financeiro;

import java.lang.reflect.Field;

import David_Santos_app_calculo.A01_Calculadora;
import David_Santos_app_calculo.Interno.A01_OpsAritmeticas;

public class A01_Teste {

    public static void main(String[] args) {

	/* Importamos a classe "A01_Calculadora" do projeto "app-Calculo" */
	A01_Calculadora c1 = new A01_Calculadora();

	/*
	 * Dentro de calculadora temos o método soma, que por sua vez pertence ao modulo
	 * "app-Calculo", e esse módulo requeriu um método chamado "info" de "logger" do
	 * módulo "app-Loggin" onde nos é exibido a data e a hora.
	 */
	System.out.println(c1.soma(2, 4, 3));

	A01_OpsAritmeticas a1 = new A01_OpsAritmeticas();

	/*
	 * utilizamos diretamente o método soma da pasta "Interno" do módulo
	 * "app-Calculo" graças ao "export to".
	 */
	System.out.println(a1.soma(3, 4, 5));

	try {
	    // Obtém o primeiro atributo (campo) declarado dentro da classe A01_Calculadora
	    Field fildId = A01_Calculadora.class.getDeclaredFields()[0];

	    // Permite acesso ao campo privado ou protegido
	    fildId.setAccessible(true);

	    // Define o valor do campo para "def" no objeto c1
	    fildId.set(c1, "def");

	    // Exibe o valor atualizado do campo no console
	    System.out.println(fildId.get(c1));

	    // Restaura a configuração original de acessibilidade do campo
	    fildId.setAccessible(false);
	} catch (Exception e) {
	    // Captura e imprime qualquer erro que ocorra durante a manipulação do campo
	    e.printStackTrace();
	}

    }

}
