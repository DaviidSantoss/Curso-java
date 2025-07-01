package C03_OO.Polimorfismo;

public class A01_Comida {
    

    private double peso;

    public A01_Comida(double peso){
        setPeso(peso);
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if(peso >= 0 ){
            this.peso = peso;
        }
       
    }
    
}
