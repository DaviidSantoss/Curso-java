package F02_Modelo.Herenca;

import F03_Infra.A12_DAO;

public class HerancaTeste {

    public static void main(String[] args) {

        A12_DAO<A25_Cliente> daoCliente = new A12_DAO<>(A25_Cliente.class);

        A12_DAO<A25_Funcionario> daoFuncionario = new A12_DAO<>(A25_Funcionario.class);

        System.out.println("Nome Cliente: " + daoCliente.getforId(1L).getNome() + " : Limite Credito: "
                + daoCliente.getforId(1L).getLimiteCredito());

        System.out.println("Nome Funcionário: " + daoFuncionario.getforId(2L).getNome() + " : Salario: "
                + daoFuncionario.getforId(2L).getSalario());

    }

}
