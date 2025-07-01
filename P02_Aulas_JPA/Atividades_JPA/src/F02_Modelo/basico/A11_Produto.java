package F02_Modelo.basico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*Com a notação "@Entity" nós mapeamos nossa classe para dentro do banco de dados
 * e através da notação "@Table(name = "produtos")" podemos definir o nome da nossa
 * tabela 
 */
@Entity
@Table(name = "produtos")
public class A11_Produto {

    @Id
    // Com a anotação "@GeneratedValue", configuramos a geração automática de Ids,
    // com a estrategia do tipo "indentidade" cade produto terá seu proprio "ID" e
    // esse valo dos ids não sera compartilhado entre as tabelas.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /*
     * Usuando a notação "@Collum" podemos definir atributos da coluna sendo eles
     * o nome , o tamanho e se a coluna aceita nullo ou não.
     */
    @Column(name = "prod_nome", length = 200, nullable = false)
    private String nome;

    /*
     * Utilizando o atributo "precision", definimos o número total de dígitos que
     * o valor poderá ter, Já o atributo "scale" define quantos desses dígitos
     * estarão após a vírgula.
     */
    @Column(name = "prod_preco", nullable = false, precision = 11, scale = 2)
    private Double preco;

    // A adição do construtor é obrigatoria
    public A11_Produto() {

    }

    // construtor para criar um novo produto
    public A11_Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}
