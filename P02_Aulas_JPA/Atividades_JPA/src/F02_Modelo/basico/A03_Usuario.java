package F02_Modelo.basico;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*A anotação @Entity nos indica que a nossa classe
 * "Usuario" sera mapeada para dentro do banco de dados,
 * e seus atributos como "id","nome" e "email" representam
 * as colunas do nosso banco de dados
 */
@Entity
public class A03_Usuario {

	/*
	 * A notação "@Id" indica que essa será nossa pk "Primary Key" no
	 * nosso banco de dados, e o "@generatedValue" nos idica que o valor
	 * da nossa chave primaria sera gerado automaticamente, e tbm adicionamos
	 * uma estratégia do tipo entidade, assim ele irá garantir que o usuário
	 * tera sua própria sequencia de ID sendo ela unica.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String email;

	// construtor para criar um novo usuário
	public A03_Usuario(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	// Construtor padrão
	public A03_Usuario() {
	}

	// Metodos gets em setters ou em português pegar e setar
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
