package F01_Teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import F02_Modelo.basico.A03_Usuario;

public class A10_RemoverUsuario {

    public static void main(String[] args) {

        // criamos a conexão.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");

        // encapsulamos a conexão.
        EntityManager em = emf.createEntityManager();

        // Primeiro buscamos o usuário que desejamos excluir.
        A03_Usuario usuario = em.find(A03_Usuario.class, 1L);

        if (usuario != null) {
            // iniciamos a transação
            em.getTransaction().begin();
            // removemos o usuário
            em.remove(usuario);
            // comitamos a transação para que ela seja efetuada
            em.getTransaction().commit();
        }

        emf.close();
        em.close();
    }
}
