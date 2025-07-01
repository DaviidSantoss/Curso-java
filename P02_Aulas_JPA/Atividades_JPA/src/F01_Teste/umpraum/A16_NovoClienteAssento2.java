package F01_Teste.umpraum;

import F02_Modelo.umpraum.A15_Assento;
import F02_Modelo.umpraum.A15_cliente;
import F03_Infra.A12_DAO;

public class A16_NovoClienteAssento2 {

    public static void main(String[] args) {

        A15_Assento assento = new A15_Assento("4F");
        /*
         * Para podermos criar um cliente devemos passar seu nome e um objeto do
         * tipo "A15_Assento", porque na classe "A15_cliente" instânciamos a classe
         * "assento" e definimos que para criar um novo cliente deve ser passado
         * um assento.
         */
        A15_cliente cliente = new A15_cliente("jaum", assento);

        A12_DAO<A15_cliente> dao = new A12_DAO<A15_cliente>();

        /*
         * Usamos a anotação "@OneToOne" com o atributo
         * "cascade = { CascadeType.PERSIST }" para que, ao persistir um cliente,
         * o assento associado também seja automaticamente persistido devido ao efeito
         * de cascata.
         */

        dao.addAll(cliente);

    }
}
