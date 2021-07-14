package ifpe.edu.controller;

import ifpe.edu.controller.dto.AlunoDTO;
import ifpe.edu.model.Aluno;
import ifpe.edu.services.AlunosService;
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

    private final AlunosService service;


    @PostMapping("/")
    public String addAluno(@Valid AlunoDTO dto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/telaAluno";
        }
        service.salvarAluno(dto);
        return "redirect:/telaAluno";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Aluno aluno = service.buscarAluno(id);
        model.addAttribute("aluno", aluno);
        return "redirect:/telaAluno";
    }


    @PutMapping("/update/{id}")
    public String updateAluno(@PathVariable("id") Integer id, @Valid AlunoDTO dto,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            dto.setAlunoId(id);
            return "update-user";
        }

        service.salvarAluno(dto);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteAluno(@PathVariable("id") Integer id, Model model) {
        Aluno aluno = service.buscarAluno(id);
        if(aluno == null){
            throw  new IllegalArgumentException("Invalid aluno Id:" + id);
        }
        service.deleteAluno(id);
        return "redirect:/telaAluno";
    }



}
