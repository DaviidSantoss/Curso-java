package C09_jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class A02_FabricaConexao {

    // MÉTODO PARA ESTABELECER UMA CONEXAO
    public static Connection getConexao() {

        try {
            Properties prop = getProperties();
            final String url = prop.getProperty("banco.url");
            final String usuario = prop.getProperty("banco.usuario");
            final String senha = prop.getProperty("banco.senha");

            /*
             * Como o método "DriverManager.getConnection" gera uma exceção chegada
             * precisamos trata-lo,a forma como tratamos foi que se caso a conexão
             * não der certo ou seja caso aconteça uma "SQLException e"
             * sera lançado uma exceção do tipo "RuntimeException(e)"
             */
            return DriverManager.getConnection(url, usuario, senha);

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     * Criamos um método chamado "getProperties" do tipo "Properties", que seria
     * tipoum bloco de notas, em seguida instânciamos um novo "Properties" com o
     * nome de prop", logo após isso criamos um "String" onde ficaria armazenado o
     * caminho desse bloco de notas, em seguida instanciamos o método "prop.load"
     * esse método carrega dados de configuração a partir de um arquivo, o comando
     * "FabricaConexao.class" refere-se a classe "FabricaConexao", já o código
     * "getResourceAsStream(caminho)" localiza o arquivo que espeficicamos e o abre
     * como um fluxo de dados, e por final retornamos o nosso "prop".
     */
    private static Properties getProperties() throws IOException {
        Properties prop = new Properties();
        String caminho = "/conexao.properties";
        prop.load(A02_FabricaConexao.class.getResourceAsStream(caminho));
        return prop;

    }
}
