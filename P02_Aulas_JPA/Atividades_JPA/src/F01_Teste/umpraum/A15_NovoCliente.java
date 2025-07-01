package F01_Teste.umpraum;

import F02_Modelo.umpraum.A15_Assento;
import F02_Modelo.umpraum.A15_cliente;
import F03_Infra.A12_DAO;

public class A15_NovoCliente {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        A15_Assento assento = new A15_Assento("25B");
        A15_cliente cliente = new A15_cliente("slaaa", assento);

        @SuppressWarnings("rawtypes")
        A12_DAO dao = new A12_DAO<>();

        dao.openT().add(assento).add(cliente).closeT().closeall();

    }
}
