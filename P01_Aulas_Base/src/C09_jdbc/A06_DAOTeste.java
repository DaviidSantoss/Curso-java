package C09_jdbc;

public class A06_DAOTeste {

    public static void main(String[] args) {

        A06_DAO dao = new A06_DAO();

        String sql = "insert into pessoas (nome) values (?)";

        dao.incluir(sql, "Maria");
        dao.incluir(sql, "bia");
        dao.incluir(sql, "lia");

        dao.close();
    }
}
