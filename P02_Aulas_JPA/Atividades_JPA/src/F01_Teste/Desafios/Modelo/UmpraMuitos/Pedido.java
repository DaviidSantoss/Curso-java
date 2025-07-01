package F01_Teste.Desafios.Modelo.UmpraMuitos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data;

    private Double valorTotal;

    /* Um pedido pode pertencer a um único cliente */
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    /* Construtor padrão necessário para o Hibernate */
    public Pedido() {
    }

    /* Construtor personalizado */
    public Pedido(Double valorTotal) {
        this.data = new Date();
        this.valorTotal = valorTotal;
    }

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

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /*
     * Método que irá transformar as "Saidas" em string para que elas possam
     * ser exibidas na tela.
     */
    public String toString() {
        return "Pedido{id=" + id + ", valor=" + valorTotal + "}";
    }

}
