package F01_Teste.UmpraMuitos;

import F02_Modelo.UmpraMuitos.A18_ItemPedido;
import F02_Modelo.UmpraMuitos.A18_Pedido;
import F03_Infra.A12_DAO;

public class A19_ObterPedido {

    public static void main(String[] args) {

        /*
         * Criamos um dao e passamos o "Pedido" como parâmetro para que possamos
         * usar os atributos dessa classe.
         */
        A12_DAO<A18_Pedido> dao = new A12_DAO<>(A18_Pedido.class);

        /* criamos um novo pedido */
        A18_Pedido pedido = dao.getforId(1L);

        /*
         * Utilizanmos o forech para percorrer nossa classe "A18_ItemPedido" para
         * podermos utilizar seus atributos como "quantidade","produto" e etc.
         *
         */
        for (A18_ItemPedido item : pedido.getItens()) {
            System.out.println(item.getQuantidade());
            System.out.println(item.getProduto().getNome());
        }

        dao.closeall();
    }

}
