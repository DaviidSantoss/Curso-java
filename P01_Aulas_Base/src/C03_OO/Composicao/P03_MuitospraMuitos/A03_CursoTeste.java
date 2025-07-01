package C03_OO.Composicao.P03_MuitospraMuitos;

public class A03_CursoTeste {
    
    public static void main(String[] args) {
        
        A03_Aluno a1 = new A03_Aluno("João");
        A03_Aluno a2 = new A03_Aluno("Pedro");
        A03_Aluno a3 = new A03_Aluno("Lucas");
        A03_Aluno a4 = new A03_Aluno("Carlos");

        A03_Curso c1 = new A03_Curso("Java");
        A03_Curso c2 = new A03_Curso("Python");
        A03_Curso c3 = new A03_Curso("C++");
        A03_Curso c4 = new A03_Curso("C#");

        c1.addAlunos(a1);
        c1.addAlunos(a2);

        c2.addAlunos(a3);
        c2.addAlunos(a4);
    
        a4.addCurso(c4);
        a1.addCurso(c3);

        for (A03_Aluno aluno : c2.alunos) {
            System.out.println(aluno.nome);
            
        }
    }
}
