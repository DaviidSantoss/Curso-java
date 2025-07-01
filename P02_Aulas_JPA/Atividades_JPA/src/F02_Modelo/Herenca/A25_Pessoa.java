package F02_Modelo.Herenca;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
/*
 * Definimos que essa classe usará herança no banco de dados através da
 * notação "@Inheritance", com a estratégia JOINED, onde cada subclasse terá sua
 * própria tabela e a superclasse armazenará os atributos comuns.Tbm usamos a
 * notação "@DiscriminatorColumn", que ira criar uma coluna chamda "tipo" dentro
 * de "A25_Pessoa" onde ela nos mostrará oq tipo de "Pessoa" que estamos
 * relacionando, "CL = cliente", "FC = Funcionario".
 */
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo", length = 2, discriminatorType = DiscriminatorType.STRING)
public class A25_Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int idade;

    /* Construtor para criar uma nova pessoa */
    public A25_Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    /* Construtor padrão */
    public A25_Pessoa() {
    }

    /* Getters and setters */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
