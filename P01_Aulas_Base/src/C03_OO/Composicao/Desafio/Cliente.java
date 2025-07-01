package C03_OO.Composicao.Desafio;


import java.util.ArrayList;

public class Cliente {
    Item item;
    //Nome do cliente
    String nome;
    
    Compra compra;
    /*Para instânciar a classe compra devemos passar
     * um a classe "Cliente" como parâmetro, ou seja
     * nossa propria classe  atual("this")
     */
    Cliente(){
        this.compra =  new Compra(this);
    }

    //adicionamos uma compra a lista de compras
    void adicionarCompra(Compra compra) {
        compras.add(compra);
    }

    ArrayList<Compra> compras = new ArrayList<>();

    //Método que retorna o valor total das compras
    double ValorTotal(){
        
        double total = 0;
        for (Compra compra : compras) {
            total += compra.getValorTotal();
        }
        return total;
    }
 
}
