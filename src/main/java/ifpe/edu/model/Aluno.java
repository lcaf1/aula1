package ifpe.edu.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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

    @JoinColumn(name = "turmaId")
    @ManyToOne(targetEntity = Turma.class)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Turma turma;

}
