package ifpe.edu.services;

import ifpe.edu.model.Aluno;
import ifpe.edu.model.Turma;
import ifpe.edu.repository.TurmaDAO;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaDAO repository;

    public void addTurma(Turma t){
        repository.save(t);
    }


    public List<Turma> buscarTodos(){
        return (List<Turma>) repository.findAll();
    }

}
