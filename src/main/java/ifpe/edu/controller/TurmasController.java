package ifpe.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/turmas")
public class TurmasController {
    @GetMapping("/cadastro")
    public String getHomeDefault(){return "turmas/home";}
}
