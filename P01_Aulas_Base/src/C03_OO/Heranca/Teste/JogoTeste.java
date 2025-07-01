package C03_OO.Heranca.Teste;

import C03_OO.Heranca.A02_Heroi;
import C03_OO.Heranca.A01_Jogador;

public class JogoTeste {
    
    public static void main(String[] args) {
        
        A01_Jogador Heroi = new A02_Heroi(10,10);
        A01_Jogador Monstro = new A01_Jogador(10,11);

        Heroi.x = 10;
        Heroi.y = 10;


        System.out.println(Heroi.vida);
        System.out.println(Monstro.vida);

        Heroi.atacar(Monstro);

        System.out.println();
        System.out.println(Heroi.vida);
        System.out.println(Monstro.vida);


    }
}
