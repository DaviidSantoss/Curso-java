package Banco;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*Mapemamos a classe para o banco de dados através da notação "@Entity" e definimos
 * o valor do discriminador como "MD".
 */
@DiscriminatorValue("MD")
@Entity
public class Medico extends Funcionario {

    /* Definimos o id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String CRM;

    /* Construto para criar um novo médico */
    public Medico(String nome, String senha, String CRM) {
        super(nome, senha);
        this.CRM = CRM;
    }

    /* Construtor para criar um médico */
    public Medico(String nome, String senha, String CRM, Long id) {
        super(nome, senha);
        this.CRM = CRM;
        this.id = id;
    }

    /* Construtor padrão */
    public Medico() {

    }

    /* Getters and setters */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String cRM) {
        CRM = cRM;
    }

}