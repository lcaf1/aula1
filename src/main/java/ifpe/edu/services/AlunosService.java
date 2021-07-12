package ifpe.edu.services;

import ifpe.edu.model.Aluno;
import ifpe.edu.repository.AlunosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AlunosService {

    @Autowired
    private AlunosDAO repository;

    public void salvarAluno(Aluno aluno){
      repository.save(aluno);
    }

    public Aluno buscarAluno(Integer id) {
        Optional<Aluno> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new EntityNotFoundException();
        }
        Aluno aluno = (Aluno) optional.get();
        return aluno;
    }

    public List<Aluno> buscarTodos(){
        return (List<Aluno>) repository.findAll();
    }

    public void deleteAluno(Integer id){
        repository.deleteById(id);
    }
}
