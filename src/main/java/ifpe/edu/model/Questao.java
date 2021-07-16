package ifpe.edu.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
public class Questao implements Serializable {

    public enum nivel {BAIXO, MEDIO, ALTO}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Disciplina disciplina;
    private nivel nivel;
    private String descricao;

}
