package C03_OO.Encapsulamento;

public class A02_PessoaTeste {

    public static void main(String[] args) {
        
        A02_Pessoa p1 = new A02_Pessoa("João", 19);

        p1.setIdade(450);

        System.out.println(p1.getIdade());
    }
    
}
