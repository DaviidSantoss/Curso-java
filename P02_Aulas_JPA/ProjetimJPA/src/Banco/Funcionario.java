package Banco;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/*Através do comando "Inheritance" ou em português "Herança" definimos que essa classe será a classe "pai",e 
 * que outras classes herdaram seus atributos.Tbm definimos o nome da coluna que 
 * sera exibido no banco de dados como "tipo", sendos os tipo "MD" para médico e
 * "RC" para recepcionista.
  */
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@DiscriminatorColumn(name = "Tipo", length = 2, discriminatorType = DiscriminatorType.STRING)
public class Funcionario {

    /* Definimos o ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String senha;

    /* Construtor para um novo Funcionário */
    public Funcionario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    /* Construtor Padrão */
    public Funcionario() {
    }

    /* Getters and Setters */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
