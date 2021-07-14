package ifpe.edu.services;

import ifpe.edu.controller.dto.AlunoDTO;
import ifpe.edu.model.Aluno;
import ifpe.edu.model.Turma;
import ifpe.edu.repository.AlunosDAO;
import ifpe.edu.repository.TurmaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AlunosService {

    @Autowired
    private AlunosDAO aRepository;

    @Autowired
    private TurmaDAO  tRepository;

    public void salvarAluno(AlunoDTO alunoDto){
      Aluno aluno = new Aluno();
      aluno.setDataNascimento(alunoDto.getDataNascimento());
      aluno.setEmail(alunoDto.getEmail());
      aluno.setMatricula(alunoDto.getMatricula());
      aluno.setNome(alunoDto.getNome());
      aluno.setSexo(alunoDto.getSexo());
      Optional p = tRepository.findById(alunoDto.getTurmaId());
      if(!p.isPresent()){
          throw new EntityNotFoundException();
      }
      Turma t = (Turma) p.get();
      aluno.setTurma(t);
        aRepository.save(aluno);
    }

    public Aluno buscarAluno(Integer id) {
        Optional<Aluno> optional = aRepository.findById(id);
        Aluno aluno = (Aluno) optional.get();
        return aluno;
    }

    public List<Aluno> buscarTodos(){
        return (List<Aluno>) aRepository.findAll();
    }

    public void deleteAluno(Integer id){
        aRepository.deleteById(id);
    }
}
