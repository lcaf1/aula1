package ifpe.edu.controller;

import ifpe.edu.model.Aluno;
import ifpe.edu.services.AlunosService;
import ifpe.edu.services.TurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

//    private final AlunosService Aservice;
//    private final TurmaService  Tservice;

    @GetMapping("/home")
    public String getHome(){return "home";}

    @GetMapping("/")
    public String getHomeDefault(){return "home";}

//    @GetMapping("/telaAluno")
//    public String getAlunosDefault(Model model) {
//        model.addAttribute("alunos", Aservice.buscarTodos());
//        model.addAttribute("turmas", Tservice.buscarTodos());
//        Aluno aluno = new Aluno();
//        model.addAttribute("aluno",aluno);
//        return "alunos/home";}

    @GetMapping("/telaDisciplinas")
    public String getDisciplinasDefault(){return "disciplinas/home";}


    @GetMapping("/telaProfessor")
    public String getProfessorDefault(){return "professor/home";}

    @GetMapping("/telaQuestoes")
    public String getQuestoesDefault(){return "questoes/home";}

    @GetMapping("/telaTurma")
    public String getTurmasDefault(){return "turmas/home";}

}
