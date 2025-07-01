package C03_OO.Polimorfismo;

public class A01_Jantar {
    
    public static void main(String[] args) {
        
         A01_Pessoa p1 = new A01_Pessoa(59.0);

         A01_Arroz ingr1 = new A01_Arroz(0.25);
         A01_Feijao ingr2 = new A01_Feijao(0.25);
         A01_Sorvete ingr3 = new A01_Sorvete(0.5);

         p1.comer(ingr1);
         p1.comer(ingr2);
         p1.comer(ingr3);

         System.out.println(p1.getPeso());
    }
}
