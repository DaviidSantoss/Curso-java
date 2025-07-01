package F02_Modelo.MuitospraMuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class A21_Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;

    private Double nota;

    /*
     * Utilizando a notação "@JoinTable" podemos definir o nome da terceira tabela
     * que fara o relacionamento de muitos pra muitos entra as duas tabelas.
     * 
     * @JoinTable(
     * // Define o nome da tabela intermediária que vai ser criada no banco de
     * dados.
     * name = "atores_filmes",
     * 
     * // Especifica a coluna que vai armazenar o ID do filme.
     * joinColumns = @JoinColumn(name = "filme_id", referencedColumnName = "id"),
     * 
     * // Especifica a coluna que vai armazenar o ID do ator.
     * inverseJoinColumns = @JoinColumn(name = "ator_id", referencedColumnName =
     * "id")
     * )
     * 
     * utilizamos o atributo "cascade" para que os atores sejam persistidos todas
     * vez que um filme for persistido.
     */
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "atores_filmes", joinColumns = @JoinColumn(name = "filme_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ator_id", referencedColumnName = "id"))
    private List<A21_Ator> atores = new ArrayList<>();

    /* Construtor padrão */
    public A21_Filme() {
    }

    /* Construtor para criar um filme */
    public A21_Filme(String nome, Double nota) {
        this.nome = nome;
        this.nota = nota;
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

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    /*
     * Si for passado nulo na lista de atores ele retornará uma lista
     * vazia porém não nula assim evitando "erros".
     */
    public List<A21_Ator> getAtores() {
        if (atores == null) {
            atores = new ArrayList<>();

        }
        return atores;
    }

    public void setAtor(List<A21_Ator> ator) {
        this.atores = ator;
    }

    /*
     * Fizemos um método que adiciona atores e filmes, que funciona da seguinte
     * forma, si o "ator" que foi passado como parâmetro for diferente de nulo
     * e não conter o "ator" que foi passado dentro de "ator" impedindo assim
     * duplicidade ai sim o ator será adicionado.
     * 
     * Nossa outra condição nos diz que si "ator" não conter nossa classe no caso
     * "A21_Filme(this)" então a nosa classe filme será adicionada dentro de "ator"
     */
    public void addAtores(A21_Ator ator) {
        if (ator != null && !getAtores().contains(ator)) {
            getAtores().add(ator);
        }

        if (!ator.getFilme().contains(this)) {
            ator.getFilme().add(this);
        }

    }

}
