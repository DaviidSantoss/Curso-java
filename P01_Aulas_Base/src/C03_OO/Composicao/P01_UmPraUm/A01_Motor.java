package C03_OO.Composicao.P01_UmPraUm;

public class A01_Motor {
    
    //instânciamos carro
    A01_Carro carro;

    //passamos carro como parâmetro para
    //construir a classe Motor.
    // E ESSA É UMA RELAÇÃO BIDIRECIONAL.
    A01_Motor(A01_Carro carro){
        this.carro = carro;
    }
    boolean ligado = false;
    double fatorInJecao = 1;
    
    int giros(){
        //si ligado for false retorne 0
        if(!ligado){
            return 0;
        }else{ 
            return (int) Math.round((fatorInJecao * 3000));
        }
    }
    
    String velocidade(){
        double vel = giros() * (2 * 3.14) *   0.3 * 0.0036;
        return "Sua velocidade atual é %dKm/h"+vel;
    }
}
