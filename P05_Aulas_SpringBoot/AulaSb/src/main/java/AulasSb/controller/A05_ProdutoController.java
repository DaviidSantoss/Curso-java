package AulasSb.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import AulasSb.models.entities.A05_Produto;
import AulasSb.models.repositories.A05_ProdutoRepository;
import jakarta.validation.Valid;

/* Define que essa classe será um controlador REST (responde requisições HTTP com dados, como JSON) */
@RestController
/*
 * Define que todas as requisições feitas para "/api/produtos" serão tratadas
 * por essa classe.
 */
@RequestMapping("/api/produtos")
public class A05_ProdutoController {

	/*
	 * Essa linha declara a variável que vai receber uma implementação automática do
	 * Spring Data JPA, capaz de fazer operações CRUD com a entidade A05_Produto sem
	 * que você escreva nem um SELECT.
	 */

	/*
	 * @Autowired diz ao Spring para injetar automaticamente uma instância da classe
	 * (ou interface) necessária nesta variável. Não instanciamos manualmente, o
	 * Spring cuida disso com base na configuração da aplicação e nas dependências
	 * declaradas.Se remover o @Autowired (ou não injetar pelo construtor), essa
	 * variável será nula, e o código vai explodir com NullPointerException na
	 * execução.
	 */
	@Autowired
	private A05_ProdutoRepository produtoRepository;

	/* ***********************CRIAÇÃO E ATUALIZAÇÃO*********************** */

	// @PostMapping
	/*
	 * Este endpoint responde tanto a requisições POST quanto PUT. - POST: usado
	 * para criar um novo produto. - PUT: usado para atualizar um produto existente.
	 *
	 * A decisão de usar um único método para ambos pode simplificar o código, mas
	 * exige atenção: o comportamento de salvar (insert ou update) depende da
	 * presença ou ausência do ID no objeto recebido.
	 */
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
	public @ResponseBody A05_Produto novoProduto(@Valid A05_Produto produto) {

			/* salva no banco. */
			produtoRepository.save(produto);

			/* retornaproduto salvo. */
			return produto;

	}

	/* ***********************BUSCA POR TODOS OS PRODUTOS*********************** */

	/*
	 * Mapeia requisições GET para o endpoint "/api/produtos", se o getmapping
	 * estiver vazio ele aponta para o dominio raiz.
	 */
	@GetMapping
	/*
	 * Iterable Ele significa: “isso pode ser iterado”, ou seja, você pode usar um
	 * for pra andar por isso. Pense numa lista, mas mais genérica.
	 */
	public Iterable<A05_Produto> obterProdutos() {
		/*
		 * produtoRepository é um objeto que estende JpaRepository,findAll() é um método
		 * pré-pronto que o Spring Data JPA fornece pra buscar todos os registros da
		 * tabela correspondente à entidade A05_Produto
		 */
		return produtoRepository.findAll();
	}

	/* ***********************BUSCA POR ID*********************** */

	/*
	 * Quando alguém fizer uma requisição GET para /algum-numero-aqui, executa esse
	 * método.GET = BUSCAR.
	 */
	@GetMapping(path = "/{id}")

	/*
	 * "@PathVariable int id" quer dizer:
	 * "Pega o valor que veio na URL no lugar de {id} e joga dentro dessa variável
	 * id aqui.
	 */
	public Optional<A05_Produto> obterProdutoporId(@PathVariable int id) {
		return produtoRepository.findById(id);
	}

	/* ***********************ALTERAÇÃO *********************** */

	/*
	 * Quando utilizamos o Put o sistema já entenda que existe um objeto já criado
	 * anteriormente e que estamos modificando ou atualizando esse objeto já
	 * existente.
	 */
	@PutMapping
	/*
	 * Criamos esse método publico do tipo A05_Produto que recebe como parâmetro um
	 * produto, a notação "@Valid faz uma validação automática dos dos campos dentro
	 * de produto, logo em seguida, encontramos o "produtoRepository.save(produto);"
	 * que é um repositório que extende do JPA, e o método "save" faz um uptade ou
	 * insert com base no que a gente mandar.E por final retornamos o produto.
	 */
	public A05_Produto alterarProduto(@Valid A05_Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}

	/* ***********************EXCLUSÃO POR ID*********************** */

	/*
	 * Através da notação "@DeleteMapping(path = "/{id}" criamos um método publico
	 * do tipo "String"(apenas para obter um resposta após exclusão), com esse
	 * método recebendo um id como parâmetro, em seguida utilizamos o
	 * "produtoRepository.deleteById(id);" fornecido pelo Spring Data JPA através do
	 * dele podemos utilizar o "deleteById(id)", após o objeto ser deletado é
	 * retornado um mensagem informando que o produto foi deletado e tbm informando
	 * qual é o id do objeto deletado.
	 */
	@DeleteMapping(path = "/{id}")
	public String excluirProduto(@PathVariable int id) {
		produtoRepository.deleteById(id);

		return "Produto de id = " + id + " Foi excluido com sucesso";

	}

	/* ***********************BUSCA POR NOME*********************** */

	/*
	 * Criamos um método público onde iniciamos utilizando a
	 * notação @GetMapping(path = "/nome/{partenome}") onde passamos o end point
	 * "/nome" e parte do nome que desejamos buscar, ou seja a notação get ira nos
	 * trazer todos os produtos que conterem o nome que passarmos.
	 */
	@GetMapping(path = "/nome/{partenome}")
	public Iterable<A05_Produto> obterProdutosporNome(@PathVariable String partenome) {
		return produtoRepository.findBynomeContaining(partenome);

	}



}
