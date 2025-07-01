package F01_Teste.UmpraMuitos;

import F02_Modelo.UmpraMuitos.A18_ItemPedido;
import F02_Modelo.UmpraMuitos.A18_Pedido;
import F02_Modelo.basico.A11_Produto;
import F03_Infra.A12_DAO;

public class A18_NovoPedido {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        /* Instânciamos o Dao */
        @SuppressWarnings("rawtypes")
        A12_DAO dao = new A12_DAO<>();

        /* Criamos um novo pedido que ira conter, o "Id" e a data do pedido. */
        A18_Pedido pedido = new A18_Pedido();

        /*
         * Criamos um novo produto reutilizando o "modelo" que criamos em outras aulas,
         * e para isso passamos o nome e o preço do produto.
         */
        A11_Produto produto = new A11_Produto("Geladeira", 3200.00);

        /* Criamos um "ItemPedido" que contem o pedido o produto e a quantidade. */
        A18_ItemPedido item = new A18_ItemPedido(pedido, produto, 10);

        dao.openT().add(produto).add(pedido).add(item).closeT().closeall();

    }
}
