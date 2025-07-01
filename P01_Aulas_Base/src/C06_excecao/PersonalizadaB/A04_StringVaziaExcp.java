package C06_excecao.PersonalizadaB;

public class A04_StringVaziaExcp extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeDoAtributo;

    /*
     * Definimos que o contrutor dessa classe recebe uma string como parâmetro
     * para ser criada.
     */
    public A04_StringVaziaExcp(String nomeDoAtributo) {
        this.nomeDoAtributo = nomeDoAtributo;
    }

    /* Esse metodo é utilizado para "pergarmos" a mensagem da excecao. */
    public String getMessage() {
        return String.format("O atributo %s  está vazio", nomeDoAtributo);
    }
}
