package F01_Teste.Desafios.Modelo.umpraum;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Pessoa {

    /* Criação do id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;

    /*
     * Instânciamos a classe documento utilizando a entidade "OneToone" indicando
     * assim uma relação de um pra um, tbm utilizamos uma entidade chamade
     * "@joimColumn" onde ela irá criar um coluna na tabela "Pessoa" chamada
     * "documento_id" nos mostrando o id referente ao documento do usuário.
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "documento_id", unique = true)
    Documento documento;

    /* Construtor padrão */
    public Pessoa() {
    }

    /* Contrutor para criar uma nova pessoa */
    public Pessoa(String nome, Documento documento) {
        this.nome = nome;
        this.documento = documento;
    }

    /* getters and setters */
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

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

}
