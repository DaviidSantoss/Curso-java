package F02_Modelo.Herenca;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*Usamos "@Entity" para essa classe ser mapeada para dentro
 * do banco de dados.E tbm utilizando o "extends" para indicar
 * que essa classe herda atributos da classe "A25_Pessoa".Tbm 
 * usamos a notação "@DiscriminatorValue" para definirmos o 
 * "valor" que será usado dentro da coluna tipo da classe "A25_Pessoa",
 * como essa é a tabela funcionario sera usado "FC".
 */
@Entity
@DiscriminatorValue("FC")
public class A25_Funcionario extends A25_Pessoa {

    private double salario;

    /* Construtor pesonalizado para funcionario */
    public A25_Funcionario(String nome, int idade, double salario) {
        super(nome, idade);
        this.salario = salario;
    }

    /* Construtor Padrão */
    public A25_Funcionario() {

    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
