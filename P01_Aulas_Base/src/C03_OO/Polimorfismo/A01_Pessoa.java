package C03_OO.Polimorfismo;

public class A01_Pessoa {
    
    private double peso;

    public A01_Pessoa(double peso){
        setPeso(peso);
    }

    public void comer(A01_Comida comida){
        this.peso += comida.getPeso();
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
