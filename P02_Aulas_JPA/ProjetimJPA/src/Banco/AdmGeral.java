package Banco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*Mapeamos a classe "AdmGeral para o banco de dados" */
@Entity
public class AdmGeral {

    /* Definimos o id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String cpf;

    private String CRM;

    /* Construtor padrão */
    public AdmGeral() {
    }

    /* contrutor para um novo admgeral */
    public AdmGeral(String nome, String cpf, String cRM) {
        this.nome = nome;
        this.cpf = cpf;
        CRM = cRM;
    }

    /* Getters and setters */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String cRM) {
        CRM = cRM;
    }

}
