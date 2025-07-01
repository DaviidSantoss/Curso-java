package C09_jdbc.Desafios.Projetim;

public class usuario {

    private String codigo;
    private String email;

    public usuario(String codigo, String email) {
        this.codigo = codigo;
        this.email = email;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.email = nome;
    }

}
