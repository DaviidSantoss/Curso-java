package C01_classe;

public class A00_areaCirc {
    
    double raio;
    /*Quando um atributo é estatico o seu valor pertence a classe,
     * assim economizando memória, e ao muda-lo para "final" tornamos
     * a variável constante, ou seja ela não podera ser alterada.
     */
     final static double pi = 3.14;

		/*
		 * criamos um métodos um construtor pra essa nossa classe passando como
		 * parâmetro um double camado "raioInicial"
		 */
    A00_areaCirc(double raioInicial){
        raio = raioInicial;
    }

	/*
	 * criamos um método do tipo double chamado "areaDoCirculo" onde ele retorna
	 * nossa variável estatica "pi = 3.14" vezes o "raio" elevado a 2.
	 */
    double areaDoCirculo(){
        return pi * (Math.pow(raio, 2));
    }
}
