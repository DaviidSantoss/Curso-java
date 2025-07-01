package F03_Infra;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/*Uma classe genéria poderia ser usada com qualquer entidade,
 * ou seja eu posso usa-la com qualquer classe.
 */
public class A12_DAO<E> {

    // abrimos a conexão
    private static EntityManagerFactory emf;
    // encapsulamos a conexão
    private static EntityManager em;

    private Class<E> classe;
    /*
     * O bloco estático é executado uma única vez quando a classe é carregada pela
     * primeira vez.Isso significa que, ao instanciar a classe DAO, a conexão com o
     * banco de dados será criada apenas uma vez. Se ocorrer algum erro durante a
     * criação do EntityManagerFactory, ele será tratado pela exceção
     * RuntimeException, e uma mensagem de erro será exibida.
     */
    static {
        try {
            emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        } catch (RuntimeException e) {
            System.out.println("Deu ruim tá com algum erro ai" + e.getMessage());

        }
    }

    // construtor sem parâmetros.
    public A12_DAO() {
        this(null);
    }

    /*
     * Este construtor aceita um parâmetro que representa a classe da entidade
     * que o DAO irá gerenciar. Isso significa que você pode usar este DAO
     * para diferentes tipos de entidades (como Usuario, Produto, etc.)
     * sem precisar criar um novo DAO para cada tipo.
     * O atributo 'classe' guarda a referência da classe, que pode ser usada
     * mais tarde em métodos para realizar operações no banco de dados.
     */
    public A12_DAO(Class<E> classe) {
        this.classe = classe;
        /*
         * podemos iniciar o entity manager direto no construtor, ou seja
         * sempre que formos instanciar a nossa classe "new DAO()" ele já
         * vem com o EntityManager pronto para uso.
         */

        em = emf.createEntityManager();
    }

    // método para abrir uma transação
    public A12_DAO<E> openT() {
        em.getTransaction().begin();
        return this;
    }

    // método para fechar uma transação
    public A12_DAO<E> closeT() {
        em.getTransaction().commit();
        return this;
    }

    // método para adicionar o comando de uma transação
    public A12_DAO<E> add(E entidade) {
        em.persist(entidade);
        return this;
    }

    // método que adicionar incluir e fecha a transação.
    public A12_DAO<E> addAll(E entidade) {
        return this.openT().add(entidade).closeT();
    }

    public A12_DAO<E> removePorId(Object id) {
        // Verifica se o ID não é nulo
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo");
        }

        /* Buscar entidade por id */
        E entidade = em.find(classe, id);

        // Se a entidade não for encontrada, lança uma exceção
        if (entidade == null) {
            throw new IllegalArgumentException("Entidade com o ID fornecido não encontrada");
        }

        // Inicia uma transação, se necessário
        this.openT();

        // Remove a entidade
        em.remove(entidade);

        // Fecha a transação
        this.closeT();

        return this;
    }

    /*
     * Criamos um método para obter um usuário através do seu id, e esse
     * método funciona da seguinte forma, Devemos inicia-lo passando uma
     * classe como parâmetro dado pela letra "E" exemplo "Cliente cliente"
     * e em seguida devemos chamar esse nosso méotdo em questão "".getforId()""
     * sendo assim a execução desse código ficaria de seguinte forma:
     * "Cliente cliente = dao.getforId("ID do usuário");"
     */
    public E getforId(Object id) {
        return em.find(classe, id);
    }

    /*
     * Criamos um método para buscar usuários apartir do nome, iniciamos criando
     * um comando "JPQL" onde ele irá fazer um select utilizando o nome como
     * parametro, em seguida retornamos uma "createquery(jpql,classe)" passando
     * nome comando "jpql" e nossa "classe" como parâmetros, logo após isso
     * setamos os parâmetros para a busca sendo eles "nome", e por ultimo pegamos
     * um unico resultado por vez através do comando "getSingleResult()"
     * 
     */
    public E getForNome(String nome) {
        String jpql = "SELECT e FROM " + classe.getName() + " e WHERE e.nome = :nome";
        return em.createQuery(jpql, classe)
                .setParameter("nome", nome)
                .getSingleResult();
    }

    /*
     * Criamos uma lista do tipo genérica chamada "consulta", passando como
     * parâmetros uma "String" chamada "nomeConsulta" e outro parâmetro chamado
     * "params" do tipo "Object". Em seguida, criamos uma "TypedQuery", que é uma
     * consulta do tipo genérico, passando como parâmetro o "nomeConsulta" e a
     * "classe".
     * 
     * Logo após isso, criamos um "fori" (for indexado), onde enquanto "i" for menor
     * que o comprimento de "params", será acrescentado +2 ao índice. Isso ocorre
     * porque os parâmetros são passados em pares (nome do parâmetro e valor do
     * parâmetro), garantindo que cada iteração trabalhe com dois elementos de
     * "params".
     * 
     * Dentro do "fori", utilizamos o método "setParameter" para definir os valores
     * dos parâmetros na consulta:
     * - O primeiro elemento do par (params[i]) é convertido em String para
     * representar o nome do parâmetro na consulta (ex.: ":nota").
     * - O segundo elemento do par (params[i + 1]) é o valor associado a esse
     * parâmetro.
     * 
     * Depois de configurar todos os parâmetros, chamamos o método "getResultList()"
     * para executar a consulta e retornar uma lista com os resultados encontrados.
     * 
     * No final, essa lista é retornada para o método que chamou "consultar".
     */

    public List<E> consultar(String nomeConsulta, Object... params) {

        TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);

        for (int i = 0; i < params.length; i += 2) {
            query.setParameter(params[i].toString(), params[i + 1]);

        }

        return query.getResultList();

    }

    /*
     * Criamos um método publico onde passamos como parâmetro uma String chamada
     * "nomeConsulta", e um objeto chamado "params", e dentro desse método criamos
     * uma lista do tipo generica e apartir dessa lista chamamos o método de cima,
     * e por fim retornamos o seguinte resultado, se a lista estiver vazia
     * retornamos nulo, caso contrario retornaremos o idice 0 (o primeiro item da
     * lista).
     * 
     */
    public E consultarUm(String nomeConsulta, Object... params) {

        List<E> lista = consultar(nomeConsulta, params);

        return lista.isEmpty() ? null : lista.get(0);

    }

    /*
     * Criamos um método que tem a função do select, onde passamos a "quant" maxima
     * de resultados que serão exibidos e o "deslocamento" de quanto em quanto serão
     * exibidos.
     * 
     */
    public List<E> getAll(int quant, int deslocamento) {
        // verificamos se á classe é nulla, caso for uma exceção sera lançada
        if (classe == null) {
            throw new UnsupportedOperationException("Classe nula CHEFIA.");
        }

        // comando jpql
        String jpql = "select e from " + classe.getName() + " e";

        // criamos uma consulta do tipo genérico passando o comando de "select",
        // e a classe que será consultada.
        TypedQuery<E> consulta = em.createQuery(jpql, classe);

        // setamos a quantidade maxima de resultados que o usuário irá fornecer.
        consulta.setMaxResults(quant);
        // setamos o deslocamento que o usuário também forneceu.
        consulta.setFirstResult(deslocamento);

        // e por fim retornamos a consultado através do ".getResultList();"
        return consulta.getResultList();
    }

    public void closeall() {
        em.close();
    }

}
