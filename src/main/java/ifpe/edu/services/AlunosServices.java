package ifpe.edu.services;

import ifpe.edu.entrity.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface AlunosServices extends CrudRepository<Aluno, Integer> {

}
