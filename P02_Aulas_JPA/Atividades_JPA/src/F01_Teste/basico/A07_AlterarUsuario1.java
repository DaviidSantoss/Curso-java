package F01_Teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import F02_Modelo.basico.A03_Usuario;

public class A07_AlterarUsuario1 {

    public static void main(String[] args) {

        // criamos a conexão
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");

        // encapsulamos a conexão
        EntityManager em = emf.createEntityManager();

        // iniciamos uma transação para podermos efetivar o comando
        em.getTransaction().begin();

        // Criamos um novo usuário e fizemos uma "busca" do usuário que desejamos
        // alterar.
        A03_Usuario usuario = em.find(A03_Usuario.class, 4L);

        /*
         * setamos o novo nome e email, isso foi possivel pois criamos a classe
         * "A03_Usuario" onde criamos os geters and setters podendo assim pegar
         * e setar o nome.
         */
        usuario.setNome("Jaum");
        usuario.setEmail("João@gmail.com");

        /*
         * O código "em.merge" é responsável por pegar um usuário
         * do banco de dados e fazer a alteração.
         */
        em.merge(usuario);

        // comitamos a transação acima para que ela seja realizada.
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
