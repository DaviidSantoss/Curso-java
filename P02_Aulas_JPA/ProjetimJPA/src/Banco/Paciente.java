package Banco;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*mapeamos a classe "Paciente" para o banco de dados através do comando "@Entity" */
@Entity
public class Paciente {

    /* Definimos o id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    /*
     * Utilizamos a notação "OneToMany" para nos dizer que um paciente
     * pode ter muitas consultas, tbm utilizamos o atributo "mappedBy" para
     * nos lembrar que a classe dominante é a classe "Consultas".
     */
    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;

    /* Construtor padrão */
    public Paciente() {
    }

    /* Construtor para um novo Paciente */
    public Paciente(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

}
