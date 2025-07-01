package C07_Generics;

import java.util.List;

public class A05_ListaUtil {

    /*
     * Como definimos o tipo dessa lista como sendo um "Object" tivemos
     * que fazer o "casting"
     */
    public static Object getUltimo1(List<?> lista) {
        return lista.get(lista.size() - 1);
    }

    public static <T> T getUltimo2(List<T> lista) {
        return lista.get(lista.size() - 1);
    }
}
