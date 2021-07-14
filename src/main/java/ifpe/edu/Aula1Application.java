package ifpe.edu;

import ifpe.edu.model.Turma;
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
	TurmaService service;

	public static void main(String[] args) {
		SpringApplication.run(Aula1Application.class, args);

	}


	@Override
	public void run(String... args) throws Exception {


		Turma turma = new Turma();
		turma.setNome("Turma Manhã");
		service.addTurma(turma);
		Turma turma2 = new Turma();
		turma2.setNome("Turma Tarde");
		service.addTurma(turma2);
		Turma turma3 = new Turma();
		turma3.setNome("Turma Noite");
		service.addTurma(turma3);
	}
}

