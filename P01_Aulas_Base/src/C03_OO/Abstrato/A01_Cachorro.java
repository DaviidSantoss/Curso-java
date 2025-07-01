package C03_OO.Abstrato;

/**
 * Cachorro
 */
public class A01_Cachorro extends A01_Mamifero {

    @Override
    public String mover() {
        return "Andou!";
    }

    @Override
    public String mamar() {
        return "Bebe Leite!";
    }
    


}