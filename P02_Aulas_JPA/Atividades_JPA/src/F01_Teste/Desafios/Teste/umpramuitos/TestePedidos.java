package F01_Teste.Desafios.Teste.umpramuitos;

import F01_Teste.Desafios.Modelo.UmpraMuitos.Cliente;
//import F01_Teste.Desafios.Modelo.UmpraMuitos.Pedido;
import F03_Infra.A12_DAO;

public class TestePedidos {

    public static void main(String[] args) {

        A12_DAO<Cliente> daoCliente = new A12_DAO<Cliente>(Cliente.class);

        System.out.println(daoCliente.getforId(2L).getPedidos().toString());
    }

}