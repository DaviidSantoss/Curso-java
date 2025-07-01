package F01_Teste.basico;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import F02_Modelo.basico.A11_Produto;
import F03_Infra.A12_ProdutoDAO;

public class A14_ObeterProdutos {

    public static void main(String[] args) {

        // removendo os logs do codigo
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        // instanciamos uma classe que extende da classe DAO
        A12_ProdutoDAO dao = new A12_ProdutoDAO();

        /*
         * criamos uma lista de produtos que contem o método "select" que
         * nos mostra todos os produtos do banco de dados.
         */
        List<A11_Produto> produtos = dao.getAll(4, 0);

        // fizemos um foreach que irá percorrer toda a lista de produtos e tbm
        // ira exibir os produtos através do print.
        for (A11_Produto produto : produtos) {
            System.out.println(
                    "ID: " + produto.getId() + " Nome: " + produto.getNome() + " Preço R$: " + produto.getPreco());
        }

        // método para obter o valor total.
        double precoTotal = produtos.
        // Converte a lista de produtos em um stream, permitindo processamento funcional
                stream().
                // Aplica uma transformação em cada produto para obter apenas o preço
                map(p -> p.getPreco()).
                // Reduz a lista de preços a um único valor somando-os.
                // Inicia a soma em '0.0'. 't' é o total acumulado, 'p' é o próximo preço; 't +
                // p' adiciona o preço atual ao total.
                reduce(0.0, (t, p) -> t + p).
                // Converte o resultado para o tipo primitivo 'double'.
                doubleValue();

        System.out.println("O valor total é R$: " + precoTotal);

    }
}
