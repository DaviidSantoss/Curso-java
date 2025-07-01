package C03_OO.Composicao.Desafio;

import java.util.ArrayList;

public class Compra {
    
    Cliente cliente;

    /*No construtor da classe compra passamos
     * "Cliente" como parâmetro ou seja para se
     * instânciar a classe compra deve-se passar
     * um cliente como parâmetro.
     */
    Compra(Cliente cliente){
        this.cliente = cliente;
    }
    
    //lista de itens da compra 
    ArrayList<Item> itens = new ArrayList<>();

    //método para adicionar itens a compra
    void AddCompra(String nome, int quantidade, double preco){
        itens.add(new Item(quantidade, nome, preco));
    }

    //metodo para obter o valor total
    double getValorTotal(){
        double total = 0;
        for (Item item : itens) {
            total += item.quantidade * item.produto.preco;
        }
        return total;
    }
   
}
