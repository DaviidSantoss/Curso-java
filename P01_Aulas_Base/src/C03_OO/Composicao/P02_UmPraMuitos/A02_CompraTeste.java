package C03_OO.Composicao.P02_UmPraMuitos;

public class A02_CompraTeste {

    public static void main(String[] args) {
        
        A02_Compra c1 = new A02_Compra();
        c1.cliente = "Joao";

        c1.addItem("Caju", 2, 4);
        c1.addItem("Pera", 2, 5);
        c1.addItem("Morango", 3, 10);


       System.out.println(c1.ValorCompra());

    }
    
}
