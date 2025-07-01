package F02_Modelo.MuitospraMuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class A21_Ator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;

    /* Toda vez que um ator for persistido um filme tbm será persistido. */
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<A21_Filme> filmes = new ArrayList<>();

    /* Construtor padrão */
    public A21_Ator() {
    }

    /* Construtor para criar um ator */
    public A21_Ator(String nome) {
        this.nome = nome;
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

    public List<A21_Filme> getFilme() {
        return filmes;
    }

    public void setFilme(List<A21_Filme> filme) {
        this.filmes = filme;
    }

}
