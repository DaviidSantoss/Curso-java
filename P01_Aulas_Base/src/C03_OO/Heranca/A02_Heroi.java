package C03_OO.Heranca;

public class A02_Heroi extends A01_Jogador {

        

        public A02_Heroi(int x,int y){
            super(x,y);
        }

       public boolean atacar(A01_Jogador oponente){
        //delta que calcula a distância
        int deltaX = Math.abs(x - oponente.x);
        int deltaY = Math.abs(y - oponente.y);


        //logica do ataque
        if (deltaX == 0 && deltaY == 1) {
            oponente.vida -= 2;
            return true;
        }else if (deltaX == 1 && deltaY == 0) {
            oponente.vida -=2;
            return true;
        }else{
            return false;
        }
    }
}
