package C03_OO.Heranca.Teste;

import C03_OO.Heranca.Desafio.Civic;
import C03_OO.Heranca.Desafio.Ferrari;

public class PistaTeste {
    
    public static void main(String[] args) {
        
        Civic c1 = new Civic();
        Ferrari f1 = new Ferrari(400);

        c1.acelerar();
        c1.acelerar();
        c1.acelerar();
        f1.acelerar();
        f1.acelerar();
        f1.acelerar();

        System.out.println("Velocidade atual do civic é ->> "+c1.velocidaAtual);
        System.out.println("Velocidade atual da Ferrari é ->> "+f1.velocidaAtual);

        f1.ligarTurbo();
        f1.acelerar();
        f1.acelerar();


        System.out.println("Velocidade atual da ferrari é ->> "+ f1.velocidaAtual);


        
    }
}
