package F02_Modelo.umpraum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "assentos")
public class A15_Assento {

    // criando id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    /*
     * Para podermos realizar uma relação bidirecional, usamos o atributo
     * "mappedBy", que significa "mapeado em". Esse atributo indica onde a relação
     * principal está definida, ou seja, nesse caso, dizemos que a relação principal
     * está mapeada no atributo "assento" dentro da classe "A15_cliente".
     * Isso torna essa relação o lado não proprietário.
     */
    @OneToOne(mappedBy = "assento")
    private A15_cliente cliente;

    // construtor padrão
    public A15_Assento() {
    }

    // contrutor para criar um novo assento
    public A15_Assento(String nome) {
        this.nome = nome;
    }

    // getters and setters:

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

    public A15_cliente getCliente() {
        return cliente;
    }

    public void setCliente(A15_cliente cliente) {
        this.cliente = cliente;
    }

    /*
     * RESUMO:
     * 
     * A classe A15_Assento representa um assento em um sistema, com um
     * identificador único (id) gerado automaticamente e um nome associado ao
     * assento. Ela possui um relacionamento "um para um" com a classe A15_cliente,
     * ou seja, um assento pode estar vinculado a um único cliente, e um cliente
     * pode estar associado a um único assento. A anotação @OneToOne é usada para
     * mapear esse relacionamento, e o atributo "mappedBy" é utilizado para indicar
     * que a relação é mapeada na classe A15_cliente no campo "assento", tornando a
     * classe A15_Assento o lado não proprietário da relação. A classe possui um
     * construtor padrão e outro que recebe o nome do assento como parâmetro.
     */

}
