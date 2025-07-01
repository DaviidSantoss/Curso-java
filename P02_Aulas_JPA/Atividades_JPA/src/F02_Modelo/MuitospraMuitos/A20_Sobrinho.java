package F02_Modelo.MuitospraMuitos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class A20_Sobrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;

    /*
     * Através do "mappedBy" identificamos uma relação bidirecional, e indicamos
     * que a essa não a relação dominante na relação bidirecional e sim a denominada
     * "sobrinhos" na classe "A20_Tio", e em uma relção de muitos pra muitos é
     * criada uma terceira tabela que ira intermediar a relação entre as duas
     * tabelas, e sera criado um terceira tabela chamada "tios_sobrinhos" pois
     * através do "mappedBy" indicamos que essa não é a tabela dominante.
     */
    @ManyToMany(mappedBy = "sobrinhos")
    private List<A20_Tio> tios = new ArrayList<>();

    /* Construtor padrão */
    public A20_Sobrinho() {
    }

    /* Construtor para criar um novo sobrinho */
    public A20_Sobrinho(String nome) {
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

    /* Método para pegar a lista de tios */
    public List<A20_Tio> getTios() {
        return tios;
    }

    public void setTios(List<A20_Tio> tios) {
        this.tios = tios;
    }

}
