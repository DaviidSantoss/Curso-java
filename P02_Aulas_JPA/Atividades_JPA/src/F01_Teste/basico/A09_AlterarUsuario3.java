package F01_Teste.basico;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import F02_Modelo.basico.A03_Usuario;

public class A09_AlterarUsuario3 {

    public static void main(String[] args) {

        // removendo os logs do codigo
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        // criamos a conexão
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");

        // encapsulamos a conexão
        EntityManager em = emf.createEntityManager();

        // iniciamos uma transação
        em.getTransaction().begin();

        // fizemos uma busca do usuário com o id = 4
        A03_Usuario usuario = em.find(A03_Usuario.class, 4L);

        /*
         * Através do comando "detach", tiramos o objeto "usuario" do modo
         * gerenciado, o que significa que alterações futuras nesse objeto
         * não serão mais automaticamente sincronizadas com o banco de dados.
         */
        em.detach(usuario);

        /*
         * Como usamos o comando "detach" acima, essa mudança de nome do usuário
         * não será realizada, pois tiramos o objeto "usuário" do modo gerenciado,
         * e para que seja feito a mudança devemos deixar o objeto usuário no modo
         * genrenciado através do comando "em.merge(usuario)".
         */
        usuario.setNome("João vasdasdas");

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
