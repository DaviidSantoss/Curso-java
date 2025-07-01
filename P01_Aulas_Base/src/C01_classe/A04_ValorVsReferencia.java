package C01_classe;

public class A04_ValorVsReferencia {
    
    public static void main(String[] args) {
        
        double a = 2;
        double b = a; // atribuição por valor

        a++;
        b--;
        System.out.println(a+" "+b);

        A03_Data d1 = new A03_Data(1,6,2022);

		/*
		 * Atribuição por referência pois estamos trabalhando com um objeto.
		 */
		A03_Data d2 = d1;
       d1.dia = 2;
       d2.mes = 9;
       

       System.out.println(d2);
       System.out.println(d1);
    }
}
