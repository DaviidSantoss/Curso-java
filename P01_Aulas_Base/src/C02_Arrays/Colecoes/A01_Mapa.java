package C02_Arrays.Colecoes;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class A01_Mapa {

    public static void main(String[] args) {
        
        Map<Integer,String> usuarios = new HashMap<>();

        // o comando de adicionar no map é ".put"
        usuarios.put(1, "Kleber");
        usuarios.put(2, "robson");
        usuarios.put(3, "zé");
        usuarios.put(4, "cigarrete");

        /*Esse "for" ira percorrer o "map" completo tanto a chave quanto o valor,
         * no inicio do "for" passamos "Entry" seguido do tipo da chave e do valor
         */
        for(Entry<Integer,String> registo : usuarios.entrySet()){
            System.out.print(registo.getKey()+" ===> ");
            System.out.println(registo.getValue());
        }



    }
    
}
