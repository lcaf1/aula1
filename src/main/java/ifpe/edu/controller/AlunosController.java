package ifpe.edu.controller;

import ifpe.edu.model.Aluno;
import ifpe.edu.services.AlunosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunosController {

    private final AlunosService service;


    @GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Aluno> getAlunoById( @PathVariable Integer id) {
        Aluno aluno = service.buscarAluno(id);
        return ResponseEntity.ok(aluno);
    }


    @GetMapping(value = "/todos", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Aluno> getAll() {

        return new ResponseEntity(service.buscarTodos(), HttpStatus.OK);
    }


    @PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity addAluno(@RequestBody Aluno aluno) {

        service.salvarAluno(aluno);
        return new ResponseEntity(aluno,HttpStatus.CREATED);

    }


    @DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Void> deleteAluno (@PathVariable Integer id) {

        Aluno aluno = new Aluno();
        aluno = service.buscarAluno(id);
        service.deleteAluno(id);
        return ResponseEntity.noContent().build();

    }


    @PutMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Aluno> putSaveBaixa(@RequestBody Aluno aluno) {

        service.salvarAluno(aluno);
        return new ResponseEntity(aluno,HttpStatus.CREATED);

    }
}
