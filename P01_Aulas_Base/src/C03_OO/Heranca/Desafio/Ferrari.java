package C03_OO.Heranca.Desafio;

import C03_OO.Polimorfismo.A02_Esportivo;

public class Ferrari extends Carro implements A02_Esportivo {
    
    public Ferrari( int VELOCIDADE_MAXIMA){
        super(VELOCIDADE_MAXIMA);
    }
    
    @Override
   public void acelerar() {
      velocidaAtual += 15;
    }

   @Override
   public void ligarTurbo() {
       delta = 35;
   }
   
   @Override
   public void desligarTurbo() {
       delta = 15;
   }
}
