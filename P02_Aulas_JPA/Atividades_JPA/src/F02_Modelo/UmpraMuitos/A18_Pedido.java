package F02_Modelo.UmpraMuitos;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class A18_Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /*
     * Criamos um atributo do tipo "Date" para registramor a data e hora
     * de quando os produtos foram inseridos.
     */
    @Column(nullable = false)
    private Date data;

    /*
     * Relação "Um para Muitos" (OneToMany) entre Pedido e ItemPedido
     * ISSO SIGNIFICA QUE UM PEDIDO PODE TER VÁRIOS ITENS ASSOCIADOS A ELE.
     * O atributo "mappedBy" indica que essa relação está mapeada pelo campo
     * "pedido" na classe A18_ItemPedido, ou seja, é lá que está a chave
     * estrangeira. A lista "itens" vai armazenar todos os itens associados a um
     * Pedido.E vale ressaltar que sempre que vermos uma "mappedBy" estamos vendo
     * um relação bidirecional.
     * 
     * 
     * @OneToMany = "Um Pedido pode ter vários Itens."
     * 
     * @ManyToOne = "Um Item pertence a um único Pedido.
     * 
     * Como estamos utilizando uma lista que pode conter um número indeterminado de
     * itens,utilizamos o "FetchType.LAZY", que é um método de carregamento tardio.
     * Isso significa que os itens da lista não serão carregados automaticamente
     * quando a entidade principal for carregada. O carregamento só ocorrerá quando
     * a lista for acessada, o que pode melhorar a performance em muitos casos.
     */
    @OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY)
    private List<A18_ItemPedido> itens;

    // construtor padrao
    public A18_Pedido() {
        this(new Date());
    }

    // contrutor passando a data como parâmetro
    public A18_Pedido(Date data) {
        this.data = data;
    }

    // getter and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<A18_ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<A18_ItemPedido> itens) {
        this.itens = itens;
    }

    /*
     * RESUMO:
     * 
     * A classe A18_Pedido representa um pedido de produtos. Ela possui um
     * identificador único (id) gerado automaticamente e um campo de data que
     * registra o momento em que o pedido foi realizado. A classe tem um
     * relacionamento "um para muitos" com a classe A18_ItemPedido, ou seja,
     * um pedido pode ter vários itens associados a ele. Esse relacionamento é
     * mapeado pelo campo "pedido" na classe A18_ItemPedido, e os itens são
     * armazenados em uma lista. A anotação @OneToMany com "fetch = FetchType.LAZY"
     * significa que os itens não serão carregados automaticamente com o pedido, mas
     * somente quando a lista for acessada, o que pode melhorar o desempenho. A
     * classe possui dois construtores: um padrão e outro que recebe a data do
     * pedido como parâmetro.
     */

}
