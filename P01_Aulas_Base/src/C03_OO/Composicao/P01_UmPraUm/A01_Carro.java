package C03_OO.Composicao.P01_UmPraUm;

public class A01_Carro {
    
    //Quando o motor é criado desta maneira ele
    //é um atributo de instância
    A01_Motor motor;

    /*No construtor da classe "motor" passamos um carro como parâmetro,
     * ou seja para instânciar a classe "motor" na nossa classe atual "Carro"
     * precisamos passar como parâmetro um carro ou seja a nossa classe atual,
     * sendo assim utilizamos o "this" ou em português "essa" como parâmetro.
     * E ESSA É UMA RELAÇÃO BIDIRECIONAL.
     */
    A01_Carro (){
        this.motor = new A01_Motor(this);
        
    }


    void acelerar(){
        if(motor.ligado == true){
        motor.fatorInJecao += 0.4;
        }
    }

    void frear(){
        if(motor.ligado == true && motor.giros() > 3000){
        motor.fatorInJecao -= 0.4;
        }
    }

    void ligar(){
        motor.ligado = true;
    }
    
    void desligar(){
        motor.ligado = false;
    }

    String estaligado(){
        if(motor.ligado == false){
            return  "O carro está desligado!";
        }
       return "O carro está ligado! Acelere!";
    }

    
}
