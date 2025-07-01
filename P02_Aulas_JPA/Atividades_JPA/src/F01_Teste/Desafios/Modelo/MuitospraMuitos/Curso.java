package F01_Teste.Desafios.Modelo.MuitospraMuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String descricao;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "cursos_estudantes", joinColumns = @JoinColumn(name = "curso_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "estudante_id", referencedColumnName = "id"))
    List<Estudante> estudante = new ArrayList<>();

    public Curso() {
    }

    public Curso(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

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

    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Estudante> getEstudante() {
        return estudante;
    }

    public void setEstudante(List<Estudante> estudante) {
        this.estudante = estudante;
    }

    /*
     * Si "estudante" for diferente de nulo, e si a lista de "estudante" não
     * contiver o "estudante" que foi passado como parâmetro (evitando duplicidade)
     * então ai ele ira pegar o "estudante" (passado pelo usuário) e irá adiciona-lo
     * a lista.
     */
    public void AddEstudante(Estudante estudante) {
        if (estudante != null && !getEstudante().contains(estudante)) {
            getEstudante().add(estudante);
        }

    }

    
    public String toString(){
        return "Curso: "+ nome + " Descrição: "+descricao;
    }
}


