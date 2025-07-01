package C02_Arrays;

import java.util.Arrays;

public class A00_Exercicio {
    
    public static void main(String[] args) {
        
		/* Criamos um array do tipo double e definimos seu tamanho como 3. */
        double [] nota = new double[3];

        nota [0] = 9;
        nota [1] = 7.5;
        nota [2] = 8.3;

        //Transformamos os valores do Array em string
        //para que pudesse ser imprimido
		System.out.println("Array Padrão " + Arrays.toString(nota));

		/* quebra de linha */
        System.out.println();

        //Percorrendo o Array com "foreach"
        for (double d : nota) {
            System.out.println("Com o foreach "+d);
        }

		/* quebra de linha */
        System.out.println();
        
        int total = 0;
        for (int i = 0; i < nota.length; i++) {
            total += nota[i];
        }
        System.out.println("A Média do Aluno é: "+total / 3);
    }
}
