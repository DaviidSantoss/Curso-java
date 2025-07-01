package F02_Modelo.umpraum;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//mapeando a classe pro banco de dados
@Entity
@Table(name = "clientes")
public class A15_cliente {

    /*
     * Ao definirmos um sistema devemos fazer a seguinte pergunta,
     * "é mais comum identificar um cliente pelo assento, ou identificar
     * um assento pelo cliente?"
     */

    // definindo id e a geração do id automática
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome", length = 255)
    private String nome;

    /*
     * Criamos um atributo do tipo "Assento", sendo assim vamos não só
     * ter acesso ao seu id mas qualquer outro atributo dentro da classe
     * "Assento", e tbm adicionamos uma notação do tipo "@OnetoOne", ou seja
     * um pra um.É importante lembrar que possuimos atributos de "assento"
     * apenas dentro da classe cliente, tornando assim um relacionamento 1 pra 1.
     * E dentro da tabela "clientes" ira ser criada uma coluna chamada "assento_id"
     * 
     * Usamos tbm a notação "@JoinColumn" que é especifica para mapear a campos que
     * representão junção, e tabem definimos que ela será um campo unico não
     * permitindo duplicações através do comando "unique = true".
     * 
     * Na notação "@OneToOne" existe um atributo chamado "cascade", onde esse
     * atributo pode receber um array de dados, onde ele irá fazer um operação
     * em cascata para o "persist", ou seja quando vc estiver persistindo um
     * cliente ele tbm irá persistin um assento automáticamente.
     */
    @OneToOne(cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "assento_id", unique = true)
    private A15_Assento assento;

    // construtor padrão
    public A15_cliente() {
    }

    // construtor para criar um novo cliente
    public A15_cliente(String nome, A15_Assento assento) {
        this.nome = nome;
        this.assento = assento;
    }

    // getters and setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public A15_Assento getAssento() {
        return assento;
    }

    public void setAssento(A15_Assento assento) {
        this.assento = assento;
    }

    /*
     * RESUMO:
     * 
     * A classe A15_cliente representa um cliente em um sistema, com um
     * identificador único (id) gerado automaticamente e um nome associado ao
     * cliente. A classe possui um relacionamento "um para um" com a classe
     * A15_Assento, ou seja, um cliente pode estar associado a um único assento, e
     * um assento pode ser vinculado a um único cliente. A anotação @OneToOne mapeia
     * esse relacionamento, e a anotação @JoinColumn define a coluna "assento_id" na
     * tabela "clientes",garantindo que ela seja única. O atributo "cascade" com o
     * valor CascadeType.PERSIST garante que, ao persistir um cliente, o assento
     * também será automaticamente persistido. A classe possui um construtor padrão
     * e outro que recebe o nome do cliente e o assento como parâmetros.
     */

}
