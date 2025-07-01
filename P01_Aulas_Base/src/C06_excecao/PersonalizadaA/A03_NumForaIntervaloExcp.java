package C06_excecao.PersonalizadaA;

public class A03_NumForaIntervaloExcp extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeDoAtributo;

    public A03_NumForaIntervaloExcp(String nomeDoAtributo) {
        this.nomeDoAtributo = nomeDoAtributo;
    }

    @Override
    public String getMessage() {
        return String.format("O atributo %s  está fora do intervalo", nomeDoAtributo);
    }
}
