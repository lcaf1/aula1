package ifpe.edu.entrity;

public class Questao {
    public enum nivel {BAIXO, MEDIO, ALTO}
    private Integer id;
    private Disciplina disciplina;
    private nivel nivel;
    private String descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Questao.nivel getNivel() {
        return nivel;
    }

    public void setNivel(Questao.nivel nivel) {
        this.nivel = nivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
