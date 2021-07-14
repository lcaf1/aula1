package ifpe.edu.controller;

import ifpe.edu.model.Turma;
import ifpe.edu.services.TurmaService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/turmas")
@RequiredArgsConstructor
public class TurmasController {

    private final TurmaService service;

    @PostMapping("/")
    public void addTurma(Turma turma) {
        service.addTurma(turma);
    }

}
