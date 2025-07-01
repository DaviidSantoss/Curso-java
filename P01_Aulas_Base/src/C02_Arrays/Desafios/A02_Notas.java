package C02_Arrays.Desafios;

import java.util.Scanner;

public class A02_Notas {
    
    public static void main(String[] args) {
        //Escaner
        Scanner c = new Scanner(System.in);

        //Requisição
        System.out.print("Quantas notas você deseja Informar ? ");
        int Qnota = c.nextInt();

        //Array
        double [] notas = new double[Qnota];

        //ForI que faz a apresentação da quantidade de notas
        //a serem apresentadas.
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Digite a nota " + (i + 1)+": ");
            notas[i] = c.nextDouble(); //ASSIM QUE SE ADICIONA VALORES DENTRO DE UM ARRAY
            
        }

        //Foreach que faz a média das notas
        double media = 0;
        for (double d : notas) {
            double totalN = 0;
            totalN += d;
            media += totalN / Qnota;
           
        }

        System.out.println("Sua média é: "+media);



        c.close();
    }
}
