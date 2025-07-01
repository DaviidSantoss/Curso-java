package Banco;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*Mapeamos a classe "Recepcionista para o banco de dados através da
    notação "@Entity"" */
@Entity
@DiscriminatorValue("RC")
public class Recepcionista extends Funcionario {

    /* Definimos o ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String CPF;

    /* Construtor para um novo Recepcionista */
    public Recepcionista(String nome, String senha, String CPF) {
        super(nome, senha);
        this.CPF = CPF;
    }

    public Recepcionista(String nome, String senha, String CPF, Long id) {
        super(nome, senha);
        this.CPF = CPF;
        this.id = id;
    }

    /* Construto padrão */
    public Recepcionista() {

    }

    /* Getters and setters */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

}
