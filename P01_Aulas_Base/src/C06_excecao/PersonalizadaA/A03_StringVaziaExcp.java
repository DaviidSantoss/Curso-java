package C06_excecao.PersonalizadaA;

public class A03_StringVaziaExcp extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeDoAtributo;

    /*
     * Definimos que o contrutor dessa classe recebe uma string como parâmetro
     * para ser criada.
     */
    public A03_StringVaziaExcp(String nomeDoAtributo) {
        this.nomeDoAtributo = nomeDoAtributo;
    }

    /* Esse metodo é utilizado para "pergarmos" a mensagem da excecao. */
    public String getMessage() {
        return String.format("O atributo %s  está vazio", nomeDoAtributo);
    }
}
