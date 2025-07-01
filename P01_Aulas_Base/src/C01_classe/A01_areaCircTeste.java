package C01_classe;

public class A01_areaCircTeste {
    public static void main(String[] args) {
        
		/* instânciamos a classe "A00_areaCirc" passando 5 como parâmetro */
        A00_areaCirc c1 = new A00_areaCirc(5);

		/*
		 * Chamamos a função "areaDoCirculo" após ter passado o parâmetro 5 como sendo o
		 * raio.
		 */
        System.out.println(c1.areaDoCirculo());
    }
}
