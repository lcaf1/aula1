package ifpe.edu.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer alunoId;
    private String nome;
    private String matricula;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;
    private String sexo;
    private String email;

    @JoinColumn(name ="turmaId")
    @ManyToOne(targetEntity = Turma.class)
    private Turma turma;

}
