package C03_OO.Composicao.Desafio;

public class ClienteTeste {
    
    public static void main(String[] args) {
        
        Cliente c1 = new Cliente();
        c1.nome = "Joao";

        Compra compra1 = new Compra(c1);
        compra1.AddCompra("Caju", 2, 5.5);
        compra1.AddCompra("Morango", 3, 10);
        compra1.AddCompra("Lazanha", 1, 20);
        compra1.AddCompra("Pizza", 1, 45);
        compra1.AddCompra("Arroz", 1, 35);

        Compra compra2 = new Compra(c1);
        compra2.AddCompra("JhonTex", 1, 15);

        c1.adicionarCompra(compra2);
        c1.adicionarCompra(compra1);

        System.out.println(c1.ValorTotal());

    }
}
