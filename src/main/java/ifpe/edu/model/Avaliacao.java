package ifpe.edu.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Avaliacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer avaliacaoId;

    @ManyToOne
    private Aluno aluno;
    private Integer nota;

    @ManyToOne
    private Prova prova;

}
