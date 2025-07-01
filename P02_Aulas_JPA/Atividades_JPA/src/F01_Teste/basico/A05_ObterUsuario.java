package F01_Teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import F02_Modelo.basico.A03_Usuario;

import java.util.logging.Level;
import java.util.logging.Logger;

public class A05_ObterUsuario {

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        // PARA SE OBTER ALGUM USUÁRIO NÃO É NECESSÁRIO INICIAR UMA TRANSAÇÃO.

        // criamos a conexão
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");

        // encapsulamos a conexão
        EntityManager em = emf.createEntityManager();

        /*
         * Criamos uma usuário, e em seguida utilizamos o metódo "em.find" onde passamos
         * como parâmetro a classe "Usuario.class" e o indetificador do usuário (id) que
         * desejamos encontrar, assim procurando no banco de dados o usuario de id = 3.
         */
        A03_Usuario usuario = em.find(A03_Usuario.class, 4L);

        /*
         * Conseguimos utilizar o comando "usuario.getNome()"" pois dentro da
         * classe "A03_Usuario" criamos os metodos get and setters, permitindo assim que
         * peguemos os nomes da classe usuario que está mapeado dentro do banco de dados
         */
        System.out.println(usuario.getNome());

        // Fechamos a conexão
        em.close();
        emf.close();
    }
}
