package F02_Modelo.Herenca;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*Usamos "@Entity" para essa classe ser mapeada para dentro
 * do banco de dados.Tbm usamos a notação "@DiscriminatorValue"
 * para definirmos o "valor" que será usado dentro da coluna
 * tipo da classe "A25_Pessoa", como essa é a tabela cliente
 * sera usado "CL".
 */
@Entity
@DiscriminatorValue("CL")
public class A25_Cliente extends A25_Pessoa {

    private double limiteCredito;

    /* Construtor pesonalizado para cliente */
    public A25_Cliente(String nome, int idade, double limiteCredito) {
        super(nome, idade);
        this.limiteCredito = limiteCredito;
    }

    /* Construtor Padrão */
    public A25_Cliente() {

    }

    /* Metodo para pegar o limite do cartão */
    public double getLimiteCredito() {
        return limiteCredito;
    }

    /* Metodo para setar o valor do limite do cartão */
    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

}
