package C01_classe;

public class A06_ValorNulo {

    @SuppressWarnings("null")
    public static void main(String[] args) {
        
        String a = " ";
        //Podemos concatenar pois é uma string com um espaço
        //vazio, não uma string com o valor nulo
        System.out.println(a.concat("!!!!"));

        //Com o valor "null" nos dizemos que a variável não foi
        //inicializada, ou seja não podemos concatenar nada à
        //uma variável nula.
        String b = null;
        System.out.println(b.concat("asdsad"));
    }
    
}
