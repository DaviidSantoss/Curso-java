package F02_Modelo.Composicao;

import javax.persistence.Embeddable;

/* 
 * Através da anotação "@Embeddable", essa classe será incorporada dentro das 
 * tabelas das entidades que a utilizarem, em vez de gerar uma tabela própria no banco. 
 * No caso, ela será usada dentro de "A24_Fornecedor" e "A24_Funcionario", 
 * adicionando seus atributos às tabelas dessas entidades, PORÉM NO BANCO DE DADOS
 * NÃO SERÁ CRIADO UMA TABELA CHAMADO "A24_Endereco",SOMENTE AS CLASSES COM NOTAÇÃO
 * "@Entity" SERÃO MAPEADAS PARA O BANCO DE DADOS.
 */
@Embeddable
public class A24_Endereco {

    private String logradouro;

    private String complemento;

    /* Getters and Setters */

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

}
