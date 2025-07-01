package F01_Teste.Desafios.Modelo.UmpraMuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {

    /* Definimos o id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    /*
     * Criamos uma lista de pedidos utilizando a notação "OneToMany" oq nos indica
     * que um cliente pode ter muitos pedidos, tbm utilizamos o atributo "mappedBy"
     * para indicar que esse não é o lado dominante da relação e tbm utilizamos
     * outro atributo chamado "cascade" que nos diz que assim que um cliente for
     * persistido um pedido tbm será "persistido".
     * 
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Pedido> pedidos = new ArrayList<>();

    /* Construtor padrão */
    public Cliente() {
    }

    /* Construtor para criar um novo Cliente */
    public Cliente(String nome) {
        this.nome = nome;
    }

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

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    /*
     * Esse método "setPedidos" funciona da seguinte maneira:
     * ele recebe uma lista do tipo "Pedido" chamada "pedidos" como parâmetro.
     * Em seguida, a lista de pedidos do cliente ("this.pedidos") é atribuída à
     * lista passada como parâmetro. Por fim, usamos um "foreach" para percorrer
     * cada pedido da lista "pedidos" e sincronizamos o cliente associado a esses
     * pedidos, definindo o cliente atual (this) em cada pedido.
     */

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
        for (Pedido pedido : pedidos) {
            pedido.setCliente(this); // Sincroniza o cliente com os pedidos
        }
    }

    /*
     * Criamos um método para adicionar pedidos e ele funciona da seguinte forma:
     * Iniciamos passando um "pedido" do tipo "Pedido" como parâmetro,logo em
     * seguida adicionamos esse "pedido" a nossa lista do tipo "Pedido" que criamos
     * no inicio do nosso código, e por final sincronizamos o cliente associado a
     * esses pedidos, definindo o cliente atual (this) em cada pedido.
     */
    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
        pedido.setCliente(this);
    }

    public void removerPedido(Pedido pedido) {
        pedidos.remove(pedido);
        pedido.setCliente(null); // Remove a referência ao cliente
    }
}
