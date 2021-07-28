package ifpe.edu.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Questao implements Serializable {

    public enum nivel {BAIXO, MEDIO, ALTO}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Disciplina disciplina;

    private nivel nivel;
    private String descricao;

}
