package ifpe.edu.controller.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class AlunoDTO {

    private Integer alunoId;

    @NotBlank(message = "Favor preencher o nome do Aluno!")
    private String nome;

    @Size(min = 10, max = 12)
    private String matricula;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;
    private String sexo;

    @Email
    private String email;
    private Integer turmaId;

}
