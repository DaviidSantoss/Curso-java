package F01_Teste.basico;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import F02_Modelo.basico.A03_Usuario;

public class A06_ObterUsuarios {

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        // criamos a conexão
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");

        // encapsulamos a conexão
        EntityManager em = emf.createEntityManager();

        /*
         * JPQL = Java Persistence Query language, esse select ira nos trazer todos
         * os dados do nosso banco de dados "Usuario" por isso é necessário limitar
         * a quantidade de resultados que será exibido.
         */
        String jpql = "select u from A03_Usuario u ";

        /*
         * Criamos uma "TypedQuery" (ou "Consulta com Tipo"), onde o comando
         * "em.createQuery(jpql, Usuario.class)" cria uma consulta em JPQL do
         * tipo "A03_Usuario".
         * 
         * A variável "jpql" contém a instrução da consulta em formato de string,
         * e "Usuario.class" indica que esperamos que o resultado da consulta seja
         * do tipo "Usuario", garantindo segurança de tipo no retorno.
         */

        TypedQuery<A03_Usuario> consulta = em.createQuery(jpql, A03_Usuario.class);

        // aqui setamos o maximo de resultados em 5
        consulta.setMaxResults(6);

        // armazenamos a nossa consulta dentro de uma lista
        List<A03_Usuario> usuarios = consulta.getResultList();

        // utilizamos o foreach para percorrer essa lista para nos exibir os dados
        for (A03_Usuario usuariu : usuarios) {

            System.out.println(usuariu.getEmail());
        }

        em.close();
        emf.close();
    }
}
