package F02_Modelo.MuitospraMuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class A20_Tio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;

    @ManyToMany
    List<A20_Sobrinho> sobrinhos = new ArrayList<>();

    /* Construtor padrão */
    public A20_Tio() {
    }

    /* Construtor para criar um novo tio */
    public A20_Tio(String nome) {
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

    /* Método para pegar a lista de sobrinhos */
    public List<A20_Sobrinho> getSobrinhos() {
        return sobrinhos;
    }

    public void setSobrinhos(List<A20_Sobrinho> sobrinhos) {
        this.sobrinhos = sobrinhos;
    }

}
