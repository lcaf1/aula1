package ifpe.edu.controller;

import ifpe.edu.controller.dto.AlunoDTO;
import ifpe.edu.model.Aluno;
import ifpe.edu.services.AlunosService;
import ifpe.edu.services.TurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunosController {

    private final AlunosService Aservice;
    private final TurmaService Tservice;

//    @GetMapping("/")
//    public String getAlunosDefault(Model model) {
//        model.addAttribute("alunos", Aservice.buscarTodos());
//        model.addAttribute("turmas", Tservice.buscarTodos());
//        Aluno aluno = new Aluno();
//        model.addAttribute("aluno",aluno);
//        return "alunos/home";}

    @PostMapping("/add")
    public String addAluno(@Valid AlunoDTO dto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "redirect:/telaAluno";
        }
        Aservice.salvarAluno(dto);
        return "redirect:/telaAluno";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Aluno aluno = Aservice.buscarAluno(id);
        model.addAttribute("aluno", aluno);
        model.addAttribute("turmas", Tservice.buscarTodos());
        return "alunos/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteAluno(@PathVariable("id") Integer id, Model model) {
        Aluno aluno = Aservice.buscarAluno(id);
        if(aluno == null){
            throw  new IllegalArgumentException("Invalid aluno Id:" + id);
        }
        Aservice.deleteAluno(id);
        return "redirect:/telaAluno";
    }

}
