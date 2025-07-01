package C03_OO.Heranca.Desafio;

public class Carro {
    
    final int VELOCIDADE_MAXIMA;
    public int velocidaAtual = 0;
    int delta = 5;

    Carro(int velocidademaxima){
        VELOCIDADE_MAXIMA = velocidademaxima;
    }

    public void acelerar(){
        if (velocidaAtual + delta > VELOCIDADE_MAXIMA) {
            velocidaAtual = VELOCIDADE_MAXIMA;
        }else{
            velocidaAtual += delta;
        }

    }

    public void freiar(){
        if (velocidaAtual > 0 ) {
            velocidaAtual -= delta;
        }
    }

}
