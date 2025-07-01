package C01_classe.Desafios;

public class Pessoa {
    
    Comida comida;
    String nome;
    double peso;
    
    //Construtor
    Pessoa(String nome, double peso){
        this.nome = nome;
        this.peso = peso;
    }

    //Método "Comer" que adiciona o peso da comida
    //ao pesoa da pessoa.
    double Comer(Comida comida){
        /*"+=" Incrementa o valor  "comida.peso" à variável "peso" da classe atual
         * ou seja a conta feita é "peso = peso + comida.peso"
         */
        return peso += comida.peso;
    }
}
