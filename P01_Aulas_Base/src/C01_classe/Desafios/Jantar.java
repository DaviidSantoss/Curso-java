package C01_classe.Desafios;

public class Jantar {
    
    public static void main(String[] args) {
        Comida c1 = new Comida("Batata Frita", 0.3);
        Comida c2 = new Comida("Arros", 0.2);
        Comida c3 = new Comida("Feijão", 0.2);
        Comida c4 = new Comida("Bife", 0.3);

        Pessoa  p1 = new Pessoa("David", 60);

        System.out.println(p1.nome+" Seu Peso atual é: "+p1.peso);

        //Instânciamos o método comer
        p1.Comer(c1);
        p1.Comer(c2);
        p1.Comer(c3);
        p1.Comer(c4);
        
        System.out.println(p1.nome+" Seu Peso pós Jantar é: "+p1.peso);
    }
}
