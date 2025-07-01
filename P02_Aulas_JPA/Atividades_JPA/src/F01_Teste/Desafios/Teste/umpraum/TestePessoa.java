package F01_Teste.Desafios.Teste.umpraum;

import F01_Teste.Desafios.Modelo.umpraum.Pessoa;
import F03_Infra.A12_DAO;

public class TestePessoa {

    public static void main(String[] args) {

        A12_DAO<Pessoa> dao = new A12_DAO<>(Pessoa.class);

        dao.removePorId(2);

    }
}