package C05_Streams;

public class A04_Aluno {

    final String nome;
    final double nota;

    public A04_Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public double getNota() {
        return nota;
    }

    public String toString() {
        return nome + " Tem nota " + nota;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        long temp;
        temp = Double.doubleToLongBits(nota);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        A04_Aluno other = (A04_Aluno) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (Double.doubleToLongBits(nota) != Double.doubleToLongBits(other.nota))
            return false;
        return true;
    }

}
