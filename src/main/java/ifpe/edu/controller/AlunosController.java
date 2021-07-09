package ifpe.edu.controller;

import ifpe.edu.entrity.Aluno;
import ifpe.edu.services.AlunosDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunosController {

    private final AlunosDAO alunosDAO;


    @GetMapping("/cadastro")
    public String getHomeDefault(){
        Aluno aluno = new Aluno();
        alunosDAO.save(aluno);
        return "alunos/home";
    }
}
