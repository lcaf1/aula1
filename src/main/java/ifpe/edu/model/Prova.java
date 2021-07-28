package ifpe.edu.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
public class Prova implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer provaId;

    @OneToMany
    private List<Questao> listaQuestoes;

    @ManyToOne
    private Disciplina disciplina;

}
