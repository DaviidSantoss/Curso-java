package C07_Generics;

public class A01_CaixaObjeto {

    private Object coisa;

    public void guardar(Object coisa) {
        this.coisa = coisa;
    }

    public Object abrir() {
        return coisa;
    }
}
