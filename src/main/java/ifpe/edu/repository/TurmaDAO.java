package ifpe.edu.repository;

import ifpe.edu.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaDAO  extends JpaRepository<Turma, Integer> {
}
