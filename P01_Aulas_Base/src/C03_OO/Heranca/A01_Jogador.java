package C03_OO.Heranca;

public class A01_Jogador {
    
    public int vida = 10;
    public int x;
    public int y;


    public A01_Jogador(int x, int y){
        this.x = x;
        this.y = y;
    }

        public boolean atacar(A01_Jogador oponente){
        //delta que calcula a distância
        int deltaX = Math.abs(x - oponente.x);
        int deltaY = Math.abs(y - oponente.y);


        //logica do ataque
        if (deltaX == 0 && deltaY == 1) {
            oponente.vida -= 1;
            return true;
        }else if (deltaX == 1 && deltaY == 0) {
            oponente.vida -=1;
            return true;
        }else{
            return false;
        }
    }

    //escolha da direção
    boolean andar(A01_Direcao direcao){
       switch (direcao) {
        case NORTE:
            y--;
            break;
        case LESTE:
            x++;
            break;
        case SUL:
            y++;
            break;
        case OESTE:
            x--;
            break;
       
        default:
            break;
       } 
    return true;
    }
}
