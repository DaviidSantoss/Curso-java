package Banco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*Mapeamos a classe "Consulta" para o banco de dados */
@Entity
public class Consulta {

    /* Definimos o Id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String descrição;

    private String horario;

    /*
     * Utilizamos a notação "ManyToOne" muitos pra um, ou seja um paciente pode ter
     * muitas consultas, mas uma consulta pode pertencer a um único paciente.
     */
    @ManyToOne
    @JoinColumn(name = "Id_Paciente", nullable = false)
    private Paciente paciente;

    /* Construtor para um nova consulta DEFINIDA POR UM MÉDICO */
    public Consulta(String descrição, String horario, Paciente paciente) {
        this.descrição = descrição;
        this.horario = horario;
        this.paciente = paciente;

    }

    /* Construtor para uma nova consulta DEFINIDA POR UMA PACIENTE */
    public Consulta(String descrição, String horario) {
        this.descrição = descrição;
        this.horario = horario;

    }

    public Consulta() {
    }

    /* Getters and Setters */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

}
