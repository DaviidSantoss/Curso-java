package C01_classe;

public class A03_Data {

	/* Definimos os atributos */
    int dia;
    int mes;
    int ano;

	/* Criamos um construtor padrão */
    A03_Data(){
        dia = 1;
        mes = 1;
        ano = 1970; 
     }
    
		/*
		 * Criamos um contrutor para seja feito a criação de uma nova data.
		 */
    A03_Data(int dia, int mes, int ano){

        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

	/*
	 * Criamos um método toString para formatar o estilo da saida do nosso código.
	 */
    public String toString(){
        return dia+"/"+ mes +"/"+ano;
    }
    
}
