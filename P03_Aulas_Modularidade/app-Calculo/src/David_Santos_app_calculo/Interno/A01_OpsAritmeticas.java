package David_Santos_app_calculo.Interno;

import java.util.Arrays;

/*
  * Criamos essa classe na pasta "Interno" para representar
  * quais arquivos serão visiveis e quais não.
  */
public class A01_OpsAritmeticas {

  /*
   * Criamos um método passando como parâmetro um varargs.
   */
  public double soma(double... nums) {

    /*
     * Retornamos uma stream do tipo "nums", onde utilizamos o método
     * reduce que irá começar com o valor inicial igual a "0.0" e pegara
     * o total irá somar com o valor inicial.
     */
    return Arrays.stream(nums).reduce(0.0, (t, a) -> t + a);
  }

}
