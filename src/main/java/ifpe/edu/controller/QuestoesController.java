package ifpe.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questoes")
public class QuestoesController {
    @GetMapping("/cadastro")
    public String getHomeDefault(){return "questoes/home";}
}
