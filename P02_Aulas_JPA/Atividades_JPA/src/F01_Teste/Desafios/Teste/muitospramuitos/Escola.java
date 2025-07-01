package F01_Teste.Desafios.Teste.muitospramuitos;

import F01_Teste.Desafios.Modelo.MuitospraMuitos.Curso;
import F03_Infra.A12_DAO;

public class Escola {

    public static void main(String[] args) {

        A12_DAO<Curso> daoCurso = new A12_DAO<>(Curso.class);

        System.out.println(daoCurso.getforId(2L).getEstudante().toString());
    }

}
