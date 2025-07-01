package AulasSb.models.repositories;

import org.springframework.data.repository.CrudRepository;

import AulasSb.models.entities.A05_Produto;

/* 
 * Você entrega sua classe `A05_Produto` e o tipo da sua chave primária (`Integer`) 
 * — e em troca, o Spring cria automaticamente **um repositório completo** pra você. 
 * */
public interface A05_ProdutoRepository extends CrudRepository<A05_Produto, Integer> {

	public Iterable<A05_Produto> findBynomeContaining(String parteNome);

	/*
	 * O `CrudRepository` já vem com **métodos prontos** como:
	 * 
	 * 
	 * 
	 * `save(entity)` : Cria ou atualiza uma entidade no banco.
	 * 
	 * `findById(id)` : Busca uma entidade pelo ID.
	 * 
	 * `existsById(id)`: Verifica se existe no banco com esse ID.
	 * 
	 * `deleteById(id)`: Deleta a entidade com esse ID.
	 * 
	 * `findAll()`: Retorna todos os registros.
	 * 
	 * `count()` : Retorna a quantidade total de registros.
	 */

}
