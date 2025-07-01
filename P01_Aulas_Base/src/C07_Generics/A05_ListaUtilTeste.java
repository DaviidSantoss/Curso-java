package C07_Generics;

import java.util.Arrays;
import java.util.List;

public class A05_ListaUtilTeste {

    public static void main(String[] args) {

        List<String> langs = Arrays.asList("java", "php", "kotlin");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        /*
         * Como aqui não usamos generics e definimos o tipo como "Obeject" tivemos
         * que fazer o casting.
         */
        String ultimaLang = (String) A05_ListaUtil.getUltimo1(langs);
        System.out.println(ultimaLang);

        Integer ultimoNum = (Integer) A05_ListaUtil.getUltimo1(nums);
        System.out.println(ultimoNum);

        /*
         * Já aqui utilizamos o generics, assim que o tipo de entrada
         * foi definido o de saida também foi definido, ou seja como
         * passamos uma lista de String o java já inferiu que a saida
         * também seria uma String.
         */
        String ultimaLanguagem = A05_ListaUtil.getUltimo2(langs);
        System.out.println(ultimaLanguagem);

        Integer ultimoNumero = A05_ListaUtil.getUltimo2(nums);
        System.out.println(ultimoNumero);
    }
}
