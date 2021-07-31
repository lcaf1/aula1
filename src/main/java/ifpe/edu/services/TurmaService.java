package ifpe.edu.services;

import ifpe.edu.controller.dto.TurmaDTO;
import ifpe.edu.model.Turma;
import ifpe.edu.repository.TurmaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    private TurmaDAO repository;
    @Autowired
    private AlunosService alunosService;

    public void addTurma(@Valid TurmaDTO dto) {
        Turma turma = new Turma();
        turma.setTurmaId(dto.getTurmaId());
        turma.setNome(dto.getNome());
        repository.save(turma);
    }

    public List<Turma> buscarTodos() {
        return (List<Turma>) repository.findAll();
    }

    public Turma buscarTurma(Integer id) {
        Optional<Turma> optional = repository.findById(id);
        Turma turma = (Turma) optional.get();
        return turma;
    }

    public void deleteTurma(Integer id) {
        final Optional<Turma> turma = getTurma(id);
        if (turma.isPresent()) {
            repository.deleteById(id);
        }
    }

    public Boolean quantidadeAlunos(Integer id) {
        final Optional<Turma> turma = getTurma(id);
        Boolean flag = false;
        if (turma.isPresent()) {
            final Integer countAlunos = alunosService.countByTurmaId(turma.get());
            final Integer quantidadeAlunos = turma.get().getQuantidadeAlunos();
            if (countAlunos < quantidadeAlunos) {
                flag = false;
            } else {
                flag = true;
            }
        }
        return flag;
    }

    public Optional<Turma> getTurma(Integer id) {
        return repository.findById(id);
    }

}
