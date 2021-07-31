package ifpe.edu.controller;

import ifpe.edu.controller.dto.BuscarAlunoDTO;
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

    private final AlunosService alunosService;
    private final TurmaService turmaService;

    @PostMapping("/add")
    public String addAluno(@Valid AlunoDTO dto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "redirect:/telaAluno";
        }
        alunosService.salvarAluno(dto);
        return "redirect:/telaAluno";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Aluno aluno = alunosService.buscarAluno(id);
        model.addAttribute("aluno", aluno);
        model.addAttribute("turmas", turmaService.buscarTodos());
        return "alunos/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteAluno(@PathVariable("id") Integer id, Model model) throws Exception {
        Aluno aluno = alunosService.buscarAluno(id);
        if (aluno == null) {
            throw new Exception("Invalid aluno Id:" + id);
        }
        alunosService.deleteAluno(id);
        return "redirect:/telaAluno";
    }

    @GetMapping("/buscarAluno")
    public String buscarAlunoByFilter(@Valid BuscarAlunoDTO dto, BindingResult result, Model model) {
        Aluno aluno = new Aluno();
        String alunoView = alunosService.getString(dto, model, aluno);
        if (alunoView != null)
            return alunoView;
        model.addAttribute("alunos", alunosService.buscarTodos());
        model.addAttribute("aluno", aluno);
        return "alunos/buscaAlunos";
    }

}
