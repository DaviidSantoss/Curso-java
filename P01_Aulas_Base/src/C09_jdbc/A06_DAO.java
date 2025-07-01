package C09_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class A06_DAO {

    // criamos uma conexão
    private Connection conexao;

    public int incluir(String sql, Object... atributos) {
        try {
            /*
             * Criamos um "PrepareStatemnt" e passamos a "String" contendo o comando
             * sql que iremos receber do usuário e por fim o código irá retornar as chave
             * geradas pelo código.
             */
            PreparedStatement stmt = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            adicionarAtributos(stmt, atributos);

            /*
             * O executeUpdate retorna a quantidade de linhas que foram afetadas no banco de
             * dados.Se o resultado for maior que zero, as chaves geradas (como as de
             * colunas AUTO_INCREMENT) serão armazenadas no "ResultSet". Se houver uma chave
             * gerada,retornaremos esse valor.
             */
            if (stmt.executeUpdate() > 0) {
                ResultSet resultado = stmt.getGeneratedKeys();
                if (resultado.next()) {
                    return resultado.getInt(1);
                }
            }
            return -1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            getConnection().close();
        } catch (Exception e) {

        } finally {
            conexao = null;
        }

    }

    /*
     * Esse método recebe um PreparedStatement (stmt) e um array de atributos
     * (atributos).Ele também lança uma exceção do tipo SQLException caso algum erro
     * ocorra ao adicionar os atributos.
     */
    private void adicionarAtributos(PreparedStatement stmt, Object[] atributos) throws SQLException {

        int indice = 1;
        /*
         * Aqui estamos usando um for-each para percorrer todos os elementos do array
         * "atributos".Cada elemento da lista será armazenado na variável "atributo"
         * durante a iteração.
         */
        for (Object atributo : atributos) {
            // Se o atributo atual for uma String, entramos nesse bloco.
            if (atributo instanceof String) {
                /*
                 * Usamos o método setString para definir o valor no PreparedStatement na
                 * posição "indice".O valor que será definido é o atributo convertido para
                 * String.
                 */
                stmt.setString(indice, (String) atributo);
                // Se o atributo atual for um Integer, entramos nesse bloco.
            } else if (atributo instanceof Integer) {
                /*
                 * Usamos o método setInt para definir o valor no PreparedStatement na posição
                 * "indice".O valor que será definido é o atributo convertido para Integer.
                 */
                stmt.setInt(indice, (Integer) atributo);
            }
            indice++;
        }
    }

    /*
     * Método para retornar a conexão caso ela não esteja
     * fechada.
     */
    private Connection getConnection() {

        try {
            if (conexao != null && !conexao.isClosed()) {
                return conexao;
            }
        } catch (SQLException e) {

        }

        /*
         * Caso a conexão esteja fechada ou não exista criamos uma
         * nova conexão e a retornamos.
         */
        conexao = A02_FabricaConexao.getConexao();
        return conexao;

    }
}
