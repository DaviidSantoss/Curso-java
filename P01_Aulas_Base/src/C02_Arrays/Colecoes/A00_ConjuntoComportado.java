package C02_Arrays.Colecoes;

import java.util.HashSet;
import java.util.Set;

public class A00_ConjuntoComportado {

    public static void main(String[] args) {
        
        //Definimos o Tipo "String" para esse set,
        //O set normal é um tipo de lista "NÃO ordenado"
        //mas caso queira que seja ordenado basta uilizar
        //o comando "TreeSet"
        Set<String> lista = new HashSet<String>(); 

        lista.add("Foda");
        lista.add("Ueeee");
        lista.add("iiii");

        System.out.println(lista);
    }
    
}
