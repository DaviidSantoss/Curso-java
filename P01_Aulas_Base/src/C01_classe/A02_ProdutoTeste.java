package C01_classe;

public class A02_ProdutoTeste {
        public static void main(String[] args) {
            
			/* Instânciamos a classe produto e passamos uma String em seu parâmetro. */
           A02_Produto p1 = new A02_Produto("Note");

			/* Definimos o atributo preço. */
           p1.preço = 1250.80;

           //Exibimos os atribuitos adicionados
           System.out.println(p1.nome + " " + "Preço:"+ " " + p1.preço);
            
           System.out.println("O produto note possuiu " + p1.Teladesconto()+"%" + " De desconto e seu valor final é " + p1.desconto());


        }
}
