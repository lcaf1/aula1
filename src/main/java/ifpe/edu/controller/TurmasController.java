package ifpe.edu.controller;

import ifpe.edu.controller.dto.TurmaDTO;
import ifpe.edu.model.Aluno;
import ifpe.edu.model.Turma;
import ifpe.edu.services.TurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/turmas")
@RequiredArgsConstructor
public class TurmasController {

    private final TurmaService service;

    @PostMapping("/add")
    public String addTurma(@Valid TurmaDTO dto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "redirect:/telaTurma";
        }
        service.addTurma(dto);
        return "redirect:/telaTurma";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Turma turma = service.buscarTurma(id);
        model.addAttribute("turma", turma);
        return "turmas/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteTurma(@PathVariable("id") Integer id, Model model){
        service.deleteTurma(id);
        return "redirect:/telaTurma";
    }
}
