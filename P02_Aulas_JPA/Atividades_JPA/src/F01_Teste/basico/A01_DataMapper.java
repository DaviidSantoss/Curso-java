package F01_Teste.basico;

import javax.persistence.EntityManager;

import F02_Modelo.basico.A03_Usuario;

@SuppressWarnings("all")
public class A01_DataMapper {
    /*
     * O padrão Data Mapper é usado para separar a lógica do código que manipula
     * objetos que interage diretamente com o banco de dados. Ele faz a "ponte"
     * entre a aplicação e o banco, permitindo que você trabalhe com objetos
     * em sua aplicação sem precisar se preocupar com os detalhes de como eles
     * são armazenados ou recuperados do banco.
     */

    /*
     * Resumo do Data Mapper em uma frase:
     * O Data Mapper faz a "tradução" entre objetos da aplicação e dados do banco,
     * deixando sua aplicação mais organizada e separando responsabilidades.
     */

    /*
     * Com ele você faz isso:
     * 
     * Você pode transformar um objeto da aplicação (ex: Usuario) em dados que serão
     * salvos no banco.
     */

    /*
     * Com o Data Mapper:
     * Você cria uma classe responsável por fazer essa conversão, separando essa
     * lógica em um só lugar.
     */

    public class UsuarioMapper {
        private EntityManager em;

        // novo usuário foi criado
        public UsuarioMapper(EntityManager em) {
            this.em = em;
        }

        // método salvar foi criado
        public void salvar(A03_Usuario usuario) {
            em.persist(usuario);
        }

        // método de buscar usuário por id foi criado
        public A03_Usuario buscarPorId(Long id) {
            return em.find(A03_Usuario.class, id);
        }
    }

    /* Agora, na sua aplicação, você só precisa chamar o UsuarioMapper: */

    // UsuarioMapper mapper = new UsuarioMapper(em);

    // mapper.salvar(new Usuario("João","joao@email.com"));

}
