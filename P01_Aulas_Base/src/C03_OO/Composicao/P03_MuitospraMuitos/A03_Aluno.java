package C03_OO.Composicao.P03_MuitospraMuitos;

import java.util.ArrayList;

public class A03_Aluno {
    
    String nome;
    //Um aluno pode fazer varios cursos
    ArrayList <A03_Curso> cursos = new ArrayList<>();

    //metodo par adicionar "curso"
    void addCurso(A03_Curso curso){ 
        //adicionamos "curso" a lista de cursos
        this.cursos.add(curso);
        //adicionamos a classe "Aluno" a lista "alunos"
        curso.alunos.add(this);
    }

    A03_Aluno(String nome){
        this.nome = nome;
    }
}
