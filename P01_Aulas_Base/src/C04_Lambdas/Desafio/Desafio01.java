package C04_Lambdas.Desafio;

import java.util.function.Function;

import C04_Lambdas.A04_Produto;

public class Desafio01 {
    
    public static void main(String[] args) {
        
        A04_Produto p = new A04_Produto("Caju", 3235.89, 0.13);
        
        //preco com desconto
        Function<A04_Produto,Double> precoReal = m -> m.preco - (m.preco * m.desconto);
       
        //imposto
        Function<Double,Double> impostoMunicipal = im -> im >= 2500 ? (im + (im * 0.085)) : im;

        //frete
        Function<Double,Double> frete = fre -> fre >= 3000 ? fre + 100 : fre + 50;

        //arredonda
        Function<Double, Double> arredondar = arre -> Math.ceil(arre);

        /*Fizemos uma função onde ela recever um double e retorna uma string formatada. */
        Function<Double, String> formatar = formt -> String.format("%.2f", formt);


        String result = precoReal.andThen(impostoMunicipal).andThen(frete).andThen(arredondar).andThen(formatar).apply(p);
       
        System.out.println(result);
    }
}
