package C03_OO.Composicao.P02_UmPraMuitos;

import java.util.ArrayList;

public class A02_Compra {
    
    String cliente;
    ArrayList<A02_Itens> itens = new ArrayList<>();

    //Criei um método para adicionar itens
   void addItem(A02_Itens item){
    //adicionei "item" a lista de itens
    itens.add(item);
    //adicionei a classe "compra" a "item"
    item.compra = this;
   }
        //passamos o contrutor da classe "Item" para a classe "Compra"
        //para que não houvesse a necessidade de instânciar "item" ao
        //adionar novos itens
        void addItem(String nome, int quantidade, double preco){
        addItem( new A02_Itens(nome, quantidade, preco));
   }


   //método para calcular o valor total da compra
    double ValorCompra (){
        double total = 0;
        for (A02_Itens mercadorias : itens) {
           total += mercadorias.preco * mercadorias.quantidade;
        }
        return total;
    }

}
