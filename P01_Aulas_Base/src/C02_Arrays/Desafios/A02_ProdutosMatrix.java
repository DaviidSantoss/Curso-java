package C02_Arrays.Desafios;


import java.util.Scanner;

public class A02_ProdutosMatrix {
    public static void main(String[] args) {
        
        Scanner c = new Scanner(System.in);

        //requisição
        System.out.print("Quantos Produtos Deseja Cadastrar ? ");
        int Qprodutos = c.nextInt();

        //requisição
        System.out.print("Quantos Preços diferentes esses produtos possuiu? ");
        int QPreço = c.nextInt();

        double [] [] PrecoFornecedores = new double[Qprodutos][QPreço];

        double total = 0;
        for (int pro = 0; pro < PrecoFornecedores.length; pro++) {
            for (int pre = 0; pre < PrecoFornecedores[pro].length; pre++) {
                System.out.printf("Digite o valor do produto %d e o seu preço %d ",(pro+1),(pre+1));
                double valorProdutos = c.nextDouble();

                total += valorProdutos;
            }
        }

            double mediaGeral = total / (Qprodutos * QPreço);

            System.out.println("A média geral dos preços é "+mediaGeral);



        c.close();
    }
    
}
