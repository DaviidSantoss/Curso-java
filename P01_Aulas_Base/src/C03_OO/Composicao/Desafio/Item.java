package C03_OO.Composicao.Desafio;

public class Item {
    
    Compra compra;
    Produto produto;

    int quantidade;

    Item(int quantidade, String nome, double preco){
        this.quantidade = quantidade;
        //criamos um novo produto passando "nome e preço"
       this.produto = new Produto(nome, preco);
    }
}
