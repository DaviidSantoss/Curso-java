package F01_Teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import F02_Modelo.basico.A03_Usuario;

public class A04_NovoUsuario {

	public static void main(String[] args) {

		/*
		 * O "EntityManagerFactory" é responsável por criar e gerenciar uma "fábrica de
		 * conexões" com o banco de dados.Ele fornece instâncias de "EntityManager" que
		 * são usadas para realizar operações no banco de dados.Ao criar a
		 * "EntityManagerFactory", passamos o nome da unidade de persistência
		 * ("exercicios-jpa") configurada no arquivo persistence.xml, que contém todas
		 * as informações necessárias para a conexão com o banco de dados.
		 */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");

		/*
		 * Nos encapsulamos dentro do "entityManager" a nossa conexão, e sera através
		 * dele que faremos todos os comandos para o banco de dados.
		 */
		EntityManager em = emf.createEntityManager();

		/* Criamos um novo usuário */
		A03_Usuario novoUsuario = new A03_Usuario("b", "b@gmail.com");

		/*
		 * Nosso código "persist" só irá funcionar se estiver em um contexto de
		 * "transação" e por isso iniciamos uma nova transação através do comando
		 * "em.getTransaction().begin();".
		 */
		em.getTransaction().begin();

		/*
		 * Sera através do "persist" que faremos a adição desse "novousuario" no
		 * banco de dados.
		 */
		em.persist(novoUsuario);

		/*
		 * E através do comando "em.getTransaction().commit();" que nossa
		 * "transação será efetivada"
		 */
		em.getTransaction().commit();

		em.close();
		emf.close();
	}

}
