package F01_Teste.basico;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import F02_Modelo.basico.A03_Usuario;

public class A08_AlterarUsuario2 {

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        // Criamos a conexão
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");

        // Encapsulamos a conexão
        EntityManager em = emf.createEntityManager();

        A03_Usuario usuario = em.find(A03_Usuario.class, 4L);

        if (usuario != null) {

            // abrimos uma transação
            em.getTransaction().begin();
            /*
             * Não utilizamos o comando "em.merge" pq quando realizamos uma consulta
             * em um contexto de transação ("em.getTransaction().begin();") qualquer
             * mudança que fizermos em um contexto de transação sera sincronizado com o
             * banco de dados.
             */
            usuario.setNome("Joãozim");
            usuario.setEmail("joãozim@gmail.com");

            // em.merge(usuario);

            em.getTransaction().commit();
            System.out.println();
            System.out.println("Usuário Alterado com Sucesso! ");
        }
        em.close();
        emf.close();
    }
}
