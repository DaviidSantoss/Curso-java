package C03_OO.Composicao.Desafio;

public class Produto {
    Item item;
    double preco;
    String nome;

    Produto(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }
}
