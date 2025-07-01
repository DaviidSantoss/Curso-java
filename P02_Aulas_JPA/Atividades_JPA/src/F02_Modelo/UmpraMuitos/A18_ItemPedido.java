package F02_Modelo.UmpraMuitos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import F02_Modelo.basico.A11_Produto;

@Entity
public class A18_ItemPedido {

    /*
     * Definindo o Id, e definindo a geração automatica dos id utilizando
     * a estrategia "identity" que permitira que cada id seja unico.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /*
     * O @ManyToOne indica que cada "ItemPedido" (ex: uma pizza) PERTENCE A UM ÚNICO
     * PEDIDO (Pedido1), MAS UM PEDIDO (Pedido1) PODE TER MUITOS "ItemPedido" (ou
     * seja,vários itens dentro dele, como várias pizzas ou outros produtos).
     */
    @ManyToOne
    private A18_Pedido pedido;

    /*
     * O @ManyToOne para "Produto" significa que cada "ItemPedido" (uma pizza, por
     * exemplo) está relacionado a um único produto, mas um produto (pizza) pode
     * estar presente em muitos pedidos diferentes. OU SEJA, MUITAS PESSOAS PODEM
     * PEDIR A MESMA PIZZA,"CRIANDO VARIOS  "ItemPedido" PARA O MESMO"Produto".
     * 
     * O "FetchType.EAGER" indica que os itens associados à entidade serão
     * carregados imediatamente,assim que a entidade principal for carregada. Ou
     * seja, ao buscar a entidade principal,todos os itens da lista serão carregados
     * de uma vez, sem esperar que a lista seja acessada.
     * 
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private A11_Produto produto;

    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = false)
    private Double preco;

    // construtor padrão
    public A18_ItemPedido() {
    }

    public A18_ItemPedido(A18_Pedido pedido, A11_Produto produto, int quantidade) {
        this.setPedido(pedido);
        this.setProduto(produto);
        this.setQuantidade(quantidade);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public A18_Pedido getPedido() {
        return pedido;
    }

    public void setPedido(A18_Pedido pedido) {
        this.pedido = pedido;
    }

    public A11_Produto getProduto() {
        return produto;
    }

    /*
     * Quando você define um produto usando o setProduto, o método verifica se o
     * preço ainda está vazio. Se estiver, ele automaticamente pega o preço do
     * produto e define como o preço atual."
     */
    public void setProduto(A11_Produto produto) {
        this.produto = produto;

        if (produto != null && this.preco == null) {
            this.setPreco(produto.getPreco());
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    /*
     * RESUMO:
     * 
     * A classe A18_ItemPedido representa um item dentro de um pedido. Ela possui um
     * identificador único (id), um relacionamento de muitos-para-um com a classe
     * A18_Pedido, indicando que cada item pertence a um único pedido.Também há um
     * relacionamento de muitos-para-um com a classe A11_Produto, o que significa
     * que cada item de pedido está relacionado a um único produto, mas um produto
     * pode aparecer em muitos pedidos diferentes. A quantidade e o preço do produto
     * são armazenados e o preço é automaticamente atribuído quando o produto é
     * definido. A anotação @ManyToOne com fetch = EAGER garante que os produtos
     * associados sejam carregados imediatamente junto ao item do pedido.A classe
     * utiliza um construtor padrão e um construtor parametrizado para facilitar a
     * criação de objetos com os dados necessários.
     */

}
