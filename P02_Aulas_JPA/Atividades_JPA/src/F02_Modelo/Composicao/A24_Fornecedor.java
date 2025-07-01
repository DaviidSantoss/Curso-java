package F02_Modelo.Composicao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fornecedores")
public class A24_Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    /*
     * Instânciando a classe A24_Endereco para podermos
     * ter implementar os seus atributos dentro da nossa
     * classe A24_Endereco.
     */
    private A24_Endereco endereco;

    /* Construtor Padrão */
    public A24_Fornecedor() {
    }

    /* Getters and Setters */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public A24_Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(A24_Endereco endereco) {
        this.endereco = endereco;
    }

}
