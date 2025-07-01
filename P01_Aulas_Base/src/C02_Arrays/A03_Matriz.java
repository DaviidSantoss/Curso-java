package C02_Arrays;

import java.util.Scanner;

public class A03_Matriz {
    
    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);

        //requisição
        System.out.print("Quantos Alunos?");
        int qAlunos = c.nextInt();

        //requisição
        System.out.print("Quantas notas por Aluno?");
        int qNotas = c.nextInt();

        //matrix
        double [] [] notasTurma = new double[qAlunos][qNotas];

        double total = 0;
        //for que irá percorrer o primeiro array "[]"
        for (int a = 0; a < notasTurma.length; a++) {
            //for que irá percorrer o segundo array
            for (int n = 0; n < notasTurma[a].length; n++) {

                System.out.printf("Informe a nota %d do Aluno %d: ",(n+1),(a+1));

                double valorNotas = c.nextDouble();

                total += valorNotas;
            }
        }

        double media = total / (qAlunos *qNotas);
        System.out.println("A média da turma é "+media);

        c.close();
    }
}
