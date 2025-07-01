package F01_Teste.MuitospraMuitos;

import F02_Modelo.MuitospraMuitos.A21_Ator;
import F02_Modelo.MuitospraMuitos.A21_Filme;
import F03_Infra.A12_DAO;

public class A21_NovoFilmeAtor {

    public static void main(String[] args) {

        A21_Filme filme1 = new A21_Filme("Carros", 10.0);
        A21_Filme filme2 = new A21_Filme("Velzoes e furiosos", 9.2);

        A21_Ator ator1 = new A21_Ator("relampago macqueen");
        A21_Ator ator2 = new A21_Ator("Brayn");

        filme1.addAtores(ator1);
        filme2.addAtores(ator2);

        filme2.addAtores(ator1);

        A12_DAO<A21_Filme> dao = new A12_DAO<>();

        /*
         * Como utilizamos o atribudo "cascade" assim que inserimos o "filme1" o "ator1"
         * tbm será inserido, e como utilizamos o "cascade" em "A21_Ator" assim que o
         * "ator1" for inserido o "filme2" será inserido fazendo com que o "ator2" tbm
         * seja inserido por consequência.
         */
        dao.addAll(filme1);
    }
}
