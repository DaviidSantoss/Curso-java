package F01_Teste.Consulta;

import java.util.List;

import F02_Modelo.MuitospraMuitos.A21_Filme;
import F03_Infra.A12_DAO;

public class A22_ObterFilmes {

    public static void main(String[] args) {

        A12_DAO<A21_Filme> dao = new A12_DAO<>(A21_Filme.class);

        List<A21_Filme> filmes = dao.consultar("vaiii", "nota", 8.0);

        // System.out.println(filmes.size());

        for (A21_Filme filme : filmes) {
            System.out.println(filme.getNome());
        }
    }

}

/*
 * Para criarmos uma consulta do tipo "Named Query" ou seja uma consulta nomeada
 * precisamos fazer as seguintes coisas:
 * 
 * 1- Criar um arquivo XML:
 * 
 * "Criamos um arquivo xml chamado "consultas.xml" onde nele tem o nome da nossa
 * "Named Quary" e o nosso comando "JPQL" que será executado para fazer as
 * consultas".
 * 
 * 2- Criar um método que ira fazer as consultas:
 * 
 * "Dentro da pasta "A12_DAO" criamos um método chamado "consultar" onde nele
 * passamos todos os parâmetros necessários para utilizar os comandos "JPQL" que
 * inserimos dentro na nossa classe "consultas.xml", facilitando assim nossas
 * consultas.
 * 
 * 3- Criar um Main para testar o código:
 * 
 * "Devemos começar instânciando uma DAO do tipo "A21_Filme" passando como
 * parâmetro "A21_Filme.class" para que possamos acessar os atributos da classe
 * filme através do DAO, logo em seguida criamos uma lista tbm do tipo filmes, e
 * na criação dessa lista utilizamos o método que criamos para fazer as
 * consultas com o código ficando assim:
 * "List<A21_Filme> filmes = dao.consultar("vaiii", "nota", 8.0);"
 * 
 * e por final fizemos um foreach para pegarmos o nome dos filmes que atendem
 * aos parâmetros estabelecidos.
 * "
 */