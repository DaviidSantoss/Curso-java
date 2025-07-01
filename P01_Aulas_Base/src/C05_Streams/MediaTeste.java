package C05_Streams;

public class MediaTeste {
    
    public static void main(String[] args) {
        
        Media m1 = new Media();
        m1.add(8.5);
        m1.add(6.5);
        Media m2 = new Media();
        m2.add(10);
        m2.add(7.2);

        System.out.println(m1.getValor());
        System.out.println(m2.getValor());

       
        System.out.println( Media.combinar(m1, m2).getValor());
    }
}
