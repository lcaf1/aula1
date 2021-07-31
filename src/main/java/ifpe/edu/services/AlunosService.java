package ifpe.edu.services;

import ifpe.edu.controller.dto.AlunoDTO;
import ifpe.edu.controller.dto.BuscarAlunoDTO;
import ifpe.edu.model.Aluno;
import ifpe.edu.model.Turma;
import ifpe.edu.repository.AlunosDAO;
import ifpe.edu.repository.TurmaDAO;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AlunosService {

    @Autowired
    private AlunosDAO alunoRepository;

    @Autowired
    private TurmaDAO tRepository;
    @Autowired
    private TurmaService turmaService;

    @SneakyThrows
    public void salvarAluno(AlunoDTO alunoDto){
        if(turmaService.quantidadeAlunos(alunoDto.getTurmaId())){
            throw new Exception("Limiti de alunos atingido!");
        }
        Aluno aluno = new Aluno();
        aluno.setAlunoId(alunoDto.getAlunoId());
        aluno.setDataNascimento(alunoDto.getDataNascimento());
        aluno.setEmail(alunoDto.getEmail());
        aluno.setMatricula(alunoDto.getMatricula());
        aluno.setNome(alunoDto.getNome());
        aluno.setSexo(alunoDto.getSexo());
        Optional p = tRepository.findById(alunoDto.getTurmaId());
        if (!p.isPresent()) {
            throw new EntityNotFoundException();
        }
        Turma t = (Turma) p.get();
        aluno.setTurma(t);
        alunoRepository.save(aluno);
    }

    public Aluno buscarAluno(Integer id) {
        Optional<Aluno> optional = alunoRepository.findById(id);
        Aluno aluno = (Aluno) optional.get();
        return aluno;
    }

    public List<Aluno> buscarTodos() {
        return (List<Aluno>) alunoRepository.findAll();
    }

    public void deleteAluno(Integer id) {
        alunoRepository.deleteById(id);
    }

    public Integer countByTurmaId(Turma turma) {
        return alunoRepository.countByTurma(turma);
    }

    public String getString(BuscarAlunoDTO dto, Model model, Aluno aluno) {
        if (dto.getEmail() != null || dto.getNome() != null || dto.getMatricula() != null) {
            try {
                model.addAttribute("aluno", aluno);
                model.addAttribute("alunos", findAlunoByFilter(dto));
                return "alunos/buscaAlunos";
            } catch (Exception e) {
                model.addAttribute("errorData", e.getMessage());
            }
            return "error/view";
        }
        return null;
    }

    public List<Aluno> findAlunoByFilter(BuscarAlunoDTO dto) throws Exception {
        final List<Aluno> aluno = alunoRepository.findByMatriculaOrEmailOrNomeLike(dto.getMatricula(), dto.getEmail(), dto.getNome());
        if (aluno.isEmpty())
            throw new Exception("Aluno não encontrado!");
        return aluno;
    }


}
