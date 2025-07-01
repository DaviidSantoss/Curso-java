package C01_classe;


//Criamos uma classe produtos e definimos seus atributos
public class A02_Produto {

    String nome;
    double preço;
    final static double desconto = 0.25;

	/*
	 * Criamos um contrutor passando um String chamada "nomeInicial" como parâmetro.
	 */
    A02_Produto(String nomeInicial){
        nome = nomeInicial;
    }

    //Não precisamos receber parâmetros pois todos os parâmetros
    //que precisamos está dentro da classe
    double desconto(){
        return  preço - (preço * desconto);
    }

	/*
	 * criamos um método do tipo double chamado "Teladesconto" onde retornamos nossa
	 * variável "desconto = 0.25" vezez 100 para que calculo do desconto seja feito.
	 */
    double Teladesconto(){
        return desconto * 100;
    }


    
    
}
