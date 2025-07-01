package C07_Generics;

public class A02_Caixa<TIPO> {

    /*
     * Definimos um tipo genérico, ou seja, o tipo
     * que o usuário escolher será o tipo "predominante".
     */
    private TIPO coisa;

    public void guardar(TIPO coisa) {
        this.coisa = coisa;
    }

    public TIPO abrir() {
        return coisa;
    }
}
