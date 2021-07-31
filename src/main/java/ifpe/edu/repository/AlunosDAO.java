package ifpe.edu.repository;

import ifpe.edu.model.Aluno;
import ifpe.edu.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunosDAO extends JpaRepository<Aluno, Integer> {

    List<Aluno> findByTurma(Integer turmaId);
    Integer countByTurma(Turma turma);
    List<Aluno> findByMatriculaOrEmailOrNomeLike(String matricula, String email , String nome);
}
