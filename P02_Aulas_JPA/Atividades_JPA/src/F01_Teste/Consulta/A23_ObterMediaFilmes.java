package F01_Teste.Consulta;

import F02_Modelo.Consulta.A23_NotaFilme;
import F03_Infra.A12_DAO;

public class A23_ObterMediaFilmes {

    public static void main(String[] args) {

        A12_DAO<A23_NotaFilme> dao = new A12_DAO<>(A23_NotaFilme.class);

        A23_NotaFilme nota = dao.consultarUm("obterMediaGeral");

        System.out.println(nota.getMedia());

        dao.closeall();

    }

}

/*
 * Para criarmos uma "Named Native Quary" devemos fazer as seguintes coisas:
 * 
 * 1-Criar uma classe que irá nos ajudar com a consulta(A23_NotaFilme):
 * 
 * "Dentro dessa classe temos apenas uma variável chamada média do tipo
 * double, e nessa classe criamos o construtor passando a variável média como
 * parâmetro, e por fim criamos os métodos getters and setters para podermos
 * manipular a variável "media".
 * 
 * 2- Estruturar devidamente a Named Native Quary no arquivo xml:
 * 
 * "Iniciamos declarando a named native quary passando seu nome como "
 * obterMediaGeral", em seguida definimos a "Quary" nativa ou seja o
 * sql puro, mais adiante configuramos o mapeamento do resultado na
 * nossa Named Native Query", após isso configuramos como o resultado
 * sera convertido para uma classe específica, e por fim mapeamos a
 * coluna media retornada pelo consulta sql.
 * 
 * 
 * 3- Criar uma classe para teste "Main":
 * 
 * "Criamos uma classe para teste main, onde instaciamos uma DAO do tipo
 * A23_NotaFilme" passando como parametro "A23_NotaFilme.class" para podermos
 * acessar os atributos dessa classe, logo após isso instânciamos a classe
 * "A23_NotaFilme" passando um método através do DAO que ira realizar a
 * consulta "Named Native Quary", e por fim usamos um print para nos mostrar
 * a média no console".
 * 
 * **OBS: a calculo da média foi feito através do comando JPQL.
 * 
 * 
 * $$$$$$ IMPORTANTE $$$$$$
 * 
 * A Named Native Query permite executar SQL puro diretamente no banco de dados,
 * sem precisar manipular as entidades mapeadas pelo JPA. Em vez de usar a
 * classe da entidade principal, podemos criar uma classe auxiliar (como
 * A23_NotaFilme) apenas para armazenar o resultado da consulta.
 * 
 * 
 */