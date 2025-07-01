package F01_Teste.umpraum;

import java.util.logging.Level;
import java.util.logging.Logger;

import F02_Modelo.umpraum.A15_Assento;
import F02_Modelo.umpraum.A15_cliente;
import F03_Infra.A12_DAO;

public class A17_ObterNovoCliente {

    public static void main(String[] args) {
        // removendo os logs do codigo
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        /*
         * Passamos a nossa classe "A15_cliente.class" pq queros utilizar
         * seus atributos atráves da nossa classe "DAO".
         */
        @SuppressWarnings("unused")
        A12_DAO<A15_cliente> daoCliente = new A12_DAO<>(A15_cliente.class);

        A15_cliente cliente = daoCliente.getforId(1L);

        /*
         * Fizemos um print onde, através do "daoCliente.getforId(1L)", conseguimos
         * pegar o assento que já estava carregado dentro da nossa classe "A15_cliente".
         * Como o assento já está associado ao cliente, conseguimos usar os métodos
         * dele, como o "getNome()", para pegar o nome do assento e mostrar no console.
         * 
         * Resumindo: pegamos o "Nome" do assento através do id do Usuário.
         */
        System.out.println(cliente.getAssento().getNome());
        daoCliente.closeall();

        A12_DAO<A15_Assento> daoAssento = new A12_DAO<>(A15_Assento.class);

        A15_Assento assento = daoAssento.getforId(1L);

        /*
         * Já nesse print pegamos o "nome do usuário" através do id do assento, nos
         * mostrando assim a relação bidirecional na prática.
         */
        System.out.println(assento.getCliente().getNome());

        daoAssento.closeall();

    }
}
