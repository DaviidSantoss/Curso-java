package C03_OO.Composicao.P02_UmPraMuitos;

public class A02_Itens {
    
    String nome;
    int quantidade;
    double preco;
    A02_Compra compra;

    A02_Itens(String nome, int quantidade, double preco){
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }
}
