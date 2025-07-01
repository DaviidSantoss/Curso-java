package C03_OO.Abstrato;

/*Uma classe  abstrarta não pode ser instânciada,
 * ela é como se fosse uma classe "não terminada."
 */
public abstract class A01_Animal {
    
    public String respirar(){
        return "CO2";
    }

    public abstract String mover ();
}
