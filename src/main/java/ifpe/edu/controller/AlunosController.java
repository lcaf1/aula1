package ifpe.edu.controller;

import ifpe.edu.entrity.Aluno;
import ifpe.edu.services.AlunosServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunosController {

    private final AlunosServices alunosServices;


    @GetMapping("/cadastro")
    public String getHomeDefault(){
        Aluno aluno = new Aluno();
        alunosServices.save(aluno);
        return "alunos/home";
    }
}
