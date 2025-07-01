package C06_excecao.PersonalizadaB;

public class A04_NumForaIntervaloExcp extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeDoAtributo;

    public A04_NumForaIntervaloExcp(String nomeDoAtributo) {
        this.nomeDoAtributo = nomeDoAtributo;
    }

    @Override
    public String getMessage() {
        return String.format("O atributo %s  está fora do intervalo", nomeDoAtributo);
    }
}
