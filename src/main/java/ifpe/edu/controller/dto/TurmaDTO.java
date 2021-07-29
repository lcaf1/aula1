package ifpe.edu.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TurmaDTO {
    private Integer turmaId;
    @NotBlank(message = "Favor preencher o nome da Turma!")
    private String nome;
}
