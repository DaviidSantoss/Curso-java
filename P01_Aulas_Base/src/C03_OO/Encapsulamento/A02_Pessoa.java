package C03_OO.Encapsulamento;

public class A02_Pessoa {

    String nome;
    int idade;

    


    public A02_Pessoa(String nome, int idade) {
        setNome(nome);
        setIdade(idade);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        if (idade > 0 && idade <= 110) {
          this.idade = idade;
        }else{
            System.out.println("Idade Inválida!");
        }
    }
    
    
    
}
