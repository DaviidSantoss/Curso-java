package F01_Teste.basico;

import F02_Modelo.basico.A11_Produto;
import F03_Infra.A12_DAO;

public class A13_NovoProduto {

    public static void main(String[] args) {

        /*
         * Instanciamos o dao passando a nosso obejto "produto" que
         * representa o banco de dados.
         */
        A12_DAO<A11_Produto> dao = new A12_DAO<>();

        // criamos novo produto
        A11_Produto produto = new A11_Produto("Caneta Azul", 2.50);

        // adicionamos o produto
        dao.openT().add(produto).closeT();

        A11_Produto produto2 = new A11_Produto("Bom atomixa", 99999.99);

        A11_Produto produto3 = new A11_Produto("Pc gamer", 5999.90);

        dao.addAll(produto3);

        System.out.println("Id do produto: " + produto3.getId());

        // adicionamos o produto de uma forma mais direta.
        dao.addAll(produto2);

    }
}
