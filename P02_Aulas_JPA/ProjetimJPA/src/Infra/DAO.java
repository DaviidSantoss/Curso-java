package Infra;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {

    private static EntityManagerFactory emf;

    private static EntityManager em;

    // Criamos a classe;
    private Class<E> classe;

    /* Um bloco estático é carregado apenas uma vez quando a classe é chamada. */
    static {

        /* Serve para desativar os logs do JPA */
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        /*
         * Com essa try catch dizemos a seguinte coisa:
         * Tente criar essa conexão caso ocorra algum erro exiba essa mensagem
         */
        try {
            emf = Persistence.createEntityManagerFactory("projetim-jpa");
        } catch (Exception e) {
            System.out.println("Verifica o arquivo  PERSISTENCE.XML meu");

        }

    }

    /* Construto padrão que retorna uma classe nula */
    public DAO() {
        this(null);
    }

    /*
     * Contrutor para criar um novo DAO passando uma classe qualquer como parâmetro
     */
    public DAO(Class<E> classe) {
        this.classe = classe;

        em = emf.createEntityManager();
    }

    /* Metodo que faz a adição direta */
    public DAO<E> addAtomic(E entidade) {

        em.getTransaction().begin();

        em.merge(entidade);

        em.getTransaction().commit();

        return this;
    }

    /* Metodo para remover por ID */
    public DAO<E> removeForId(Object id) {

        /* verificando se o id não é nulo */
        if (id == null) {
            throw new IllegalArgumentException("Id não existe!");
        }

        /* Procura(select) pela entidade através do id e classe fornecidos */
        E entidade = em.find(classe, id);

        if (entidade == null) {
            throw new IllegalArgumentException("Entidade com ID: " + id + " Nao encontrada");
        }

        em.getTransaction().begin();

        em.remove(entidade);

        em.getTransaction().commit();

        return this;
    }

    public E BuscasUsuario(Class<E> classe, Object id) {

        return em.find(classe, id);

    }

    public String PegarNome(String ObjetoDigitado1, String ObjetoDigitado2, String FatorLogin1, String FatorLogin2,
            String Banco) {

        try {

            /* Verifica se as credencias estão devidamente inseridas */
            if (ObjetoDigitado1.trim().isEmpty() || ObjetoDigitado2.trim().isEmpty()) {

                System.out.println();
                System.out.println("Usuário: Not Found");

            }

            String jpqlNome = "SELECT m.nome FROM " + Banco + " m WHERE m." + FatorLogin1 + " = :" + FatorLogin1
                    + " AND m." + FatorLogin2 + " = :" + FatorLogin2;

            TypedQuery<String> consultaNome = em.createQuery(jpqlNome, String.class);

            /* Parametros de consulta para verificar o NOME do usuário */
            consultaNome.setParameter(FatorLogin1, ObjetoDigitado1);
            consultaNome.setParameter(FatorLogin2, ObjetoDigitado2);

            consultaNome.getSingleResult();

            String nome = consultaNome.getSingleResult();

            return nome;

        } catch (Exception e) {
            return "";
        }

    }

    public List<E> buscarObjetos(String Banco) {

        String jpql = "SELECT m FROM " + Banco + " m";

        return em.createQuery(jpql, classe).getResultList();

    }

    @SuppressWarnings("hiding")
    public <E> List<E> buscarObjetosEspecificos(String Banco, String FatorLogin1, String FatorLogin2,
            String ObjetoDigitado1, String ObjetoDigitado2, Class<E> entityClass) {

        // Construindo a consulta JPQL dinamicamente
        String jpql = "SELECT m FROM " + Banco + " m WHERE m." + FatorLogin1 + " = :" + FatorLogin1 + " AND m."
                + FatorLogin2 + " = :" + FatorLogin2;

        // Criando o TypedQuery com o tipo dinâmico passado como parâmetro
        TypedQuery<E> consulta = em.createQuery(jpql, entityClass);

        // Definindo os parâmetros da consulta
        consulta.setParameter(FatorLogin1, ObjetoDigitado1);
        consulta.setParameter(FatorLogin2, ObjetoDigitado2);

        // Retornando a lista de resultados
        return consulta.getResultList();
    }

    /*
     * O objeto digitado serve para pegar a senha/email/cpf/crm digitados pelo
     * usuário e o fator de login será utilizado como uma bulsola para indicar oq
     * verificar na hora da busca, e o "banco" serve para indicar em qual banco de
     * dados a busca deve ser feita.
     */
    public boolean VerificarLogin(String ObjetoDigitado1, String ObjetoDigitado2,
            String FatorLogin1, String FatorLogin2, String Banco) {

        try {

            if (ObjetoDigitado1.trim().isEmpty() || ObjetoDigitado2.trim().isEmpty()) {
                System.out.println("Erro: Dados de Login inválidos! ");
                return false;
            }

            /* Consulta JPQL para verificar Logins */
            String jpql = "SELECT m FROM " + Banco + " m WHERE m." + FatorLogin1 + " = :" + FatorLogin1 +
                    " AND m." + FatorLogin2 + " = :" + FatorLogin2;

            TypedQuery<E> consulta = em.createQuery(jpql, classe);

            consulta.setParameter(FatorLogin1, ObjetoDigitado1);
            consulta.setParameter(FatorLogin2, ObjetoDigitado2);

            consulta.getSingleResult();

            return true;

        } catch (NoResultException e) {
            return false;
        }
    }
}
