package C05_Streams.Desafios;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;


public class LavaRapido {
    
    public static void main(String[] args) {
        
        Lavagens l1 = new Lavagens("Lavagem Simples", 60, 30);
        Lavagens l2 = new Lavagens("Lavagem Detalhada", 120, 50);
        Lavagens l3 = new Lavagens("Lavagem Simples + Polimento", 100, 70);
        Lavagens l4 = new Lavagens("Lavagem Detalhada + Polimento", 150, 90);

        List<Lavagens> LavaRapido = Arrays.asList(l1,l2,l3,l4);

        /* Inicializamos 'max' com o menor valor possível para um inteiro em Java,
         * Isso garante que qualquer número na lista será maior que esse valor inicial,
         * permitindo que o algoritmo encontre corretamente o maior número na lista.
         */
        int MaiorNum = Integer.MIN_VALUE;

        /*Esse foreach ira percorrer a lista "LavaRapido" e ira comparar o preço dessa lista
         * com a variável "MaiorNum", assim que o maior preço for encontrado ele sera atribuido
         * a variável "MaiorNum"
         */
        for (Lavagens limpos : LavaRapido) {
            if (limpos.preço > MaiorNum) {
                MaiorNum = limpos.preço;
            }
        }


        Predicate<Lavagens> mediaLavagem = a -> a.tempo <=  60;
        Predicate<Lavagens> mediaPreco = a -> a.preço <= 60;
        Function<Lavagens, String> printi = a -> "As lavagens mais rapidas são: " + a.nome + "\nas lavagens mais baratas são:"+ a.nome;

        /*O filter funciona como um "if" ele filtra as opções de um dado elemento com base nos parâmtros que passamos
         * para ele, um exemplo disso é o "predicate" "mediaLavagem"
        */
        LavaRapido.stream().filter(mediaLavagem).filter(mediaPreco).map(printi).forEach(System.out::println);

        

        


    }
}
