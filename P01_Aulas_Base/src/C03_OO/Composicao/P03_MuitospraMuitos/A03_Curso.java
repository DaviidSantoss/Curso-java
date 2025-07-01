package C03_OO.Composicao.P03_MuitospraMuitos;

import java.util.ArrayList;

public class A03_Curso {
    
    String nome;
    //Um curso pode ter varios alunos
    ArrayList <A03_Aluno> alunos = new ArrayList<>();

    //meotodo para adicionar alunos
    void addAlunos(A03_Aluno aluno){
        //adicionamos "aluno" a lista de "alunos"
        this.alunos.add(aluno);
        //Adicionamos a classe "Curso" a lista de "cursos"
        aluno.cursos.add(this);
    }

    A03_Curso(String nome){
        this.nome = nome;
    
    }
}
