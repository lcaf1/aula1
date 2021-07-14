package ifpe.edu.repository;

import ifpe.edu.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunosDAO extends JpaRepository<Aluno, Integer> {

}