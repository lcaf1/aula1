package ifpe.edu;

import ifpe.edu.controller.dto.TurmaDTO;
import ifpe.edu.model.Turma;
import ifpe.edu.repository.TurmaDAO;
import ifpe.edu.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "ifpe.edu.repository")
public class Aula1Application implements CommandLineRunner {

	@Autowired
	TurmaDAO turmaDAO;

	public static void main(String[] args) {
		SpringApplication.run(Aula1Application.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
		Turma turma = new Turma();
		turma.setNome("Turma Manhã");
		turma.setQuantidadeAlunos(2);
		turmaDAO.save(turma);
		Turma turma2 = new Turma();
		turma2.setNome("Turma Tarde");
		turma2.setQuantidadeAlunos(2);
		turmaDAO.save(turma2);
		Turma turma3 = new Turma();
		turma3.setNome("Turma Noite");
		turma3.setQuantidadeAlunos(2);
		turmaDAO.save(turma3);
	}
}

