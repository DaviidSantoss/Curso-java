package F01_Teste.MuitospraMuitos;

import F02_Modelo.MuitospraMuitos.A20_Sobrinho;
import F02_Modelo.MuitospraMuitos.A20_Tio;
import F03_Infra.A12_DAO;

public class A20_NovoTioSobrinho {

    public static void main(String[] args) {

        A20_Sobrinho sobrinho1 = new A20_Sobrinho("João");
        A20_Sobrinho sobrinho2 = new A20_Sobrinho("Maria");

        A20_Tio tia1 = new A20_Tio("Darci");
        A20_Tio tio2 = new A20_Tio("josé");

        /*
         * "Tia1" é tia do "sobrio1" e "sobrinho1" é sobrinho da "tia1",
         * assim fazendo a relação bidirecional.
         */
        tia1.getSobrinhos().add(sobrinho1);
        sobrinho1.getTios().add(tia1);

        tia1.getSobrinhos().add(sobrinho2);
        sobrinho2.getTios().add(tia1);

        tio2.getSobrinhos().add(sobrinho1);
        sobrinho1.getTios().add(tio2);

        tio2.getSobrinhos().add(sobrinho2);
        sobrinho2.getTios().add(tio2);

        A12_DAO<Object> dao = new A12_DAO<>();

        dao.openT().add(tia1).add(tio2).add(sobrinho1).add(sobrinho2).closeT().closeall();
    }
}
