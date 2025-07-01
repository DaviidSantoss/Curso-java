package C07_Generics;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/*O valor da chave ira herdar de "Number" ou seja seu valor
 * só podera ser númerico
 */
public class A06_Pares<C extends Number, V> {

    /*
     * Criamos um conjunto (Set) chamado "itens" que armazenará objetos do tipo
     * "Par<C, V>".A utilização de "HashSet<>()" significa que estamos utilizando
     * uma implementação de Set que não permite elementos duplicados.
     * Isso também significa que a ordem dos elementos não será garantida, ou seja,
     * eles podem ser armazenados em qualquer ordem.A palavra "final" indica que
     * a referência ao "Set" não pode ser alterada depois de inicializada, mas os
     * elementos dentro do conjunto podem mudar.
     */
    private final Set<A06_Par<C, V>> itens = new HashSet<>();

    /*
     * Esse método "add" recebe "chave" do tipo "C" e "valor" do tipo "V", i si
     * chave for igual a "nulo" então usamos o "return" para encerrar o méotodo,
     * logo após isso criamos um "novoPar" de chave e valor, i si nossa coleção
     * "Set" já tiver "novoPar" contendo as mesma caracteristicas então remova esse
     * "novoPar".
     */
    public void add(C chave, V valor) {
        if (chave == null)
            return;

        A06_Par<C, V> novoPar = new A06_Par<C, V>(chave, valor);
        if (itens.contains(novoPar)) {
            itens.remove(novoPar);
        }
        itens.add(novoPar);
    }

    /*
     * Criamos esse Metodo para pegarmos o valor, si chave for igual a "nulo" então
     * usamos o "return" para sair do método em seguida criamos um fluxo (stream)
     * dos elementos em "itens" e usamos "filter" para encontrar um par onde a chave
     * seja igual à chave fornecida. Em seguida, usamos "findFirst" para retornar o
     * primeiro par que corresponde a essa condição. O resultado é um Optional, que
     * pode conter o par encontrado ou estar vazio, caso nenhum par atenda à
     * condição, no final se a variável "parOpicional" estiver presente pegaremos
     * o valor, caso contrario sera retornado "nulo".
     */
    public V getvalor(C chave) {

        if (chave == null)
            return null;

        Optional<A06_Par<C, V>> parOpocional = itens.stream().filter(par -> chave.equals(par.getChave())).findFirst();

        return parOpocional.isPresent() ? parOpocional.get().getValor() : null;

    }
}
