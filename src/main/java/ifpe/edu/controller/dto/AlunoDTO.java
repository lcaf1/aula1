package ifpe.edu.controller.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class AlunoDTO {


    private Integer alunoId;
    private String nome;
    private String matricula;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;
    private String sexo;
    private String email;
    private Integer turmaId;

}
