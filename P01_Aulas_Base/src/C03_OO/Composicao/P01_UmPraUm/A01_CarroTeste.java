package C03_OO.Composicao.P01_UmPraUm;

public class A01_CarroTeste {
    
public static void main(String[] args) {
    
    A01_Carro bmw = new A01_Carro();
    bmw.ligar();

    bmw.acelerar();
    

    System.out.println(bmw.motor.giros());
    
    bmw.frear();
    System.out.println(bmw.motor.giros());

}
}
