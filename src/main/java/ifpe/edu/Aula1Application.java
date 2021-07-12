package ifpe.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "ifpe.edu.repository")
public class Aula1Application {

	public static void main(String[] args) {
		SpringApplication.run(Aula1Application.class, args);
	}

}
