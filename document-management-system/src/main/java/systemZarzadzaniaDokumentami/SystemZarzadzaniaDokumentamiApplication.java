package systemZarzadzaniaDokumentami;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Adnotacja służy do włączenia automatycznej konfiguracji Spring Boot, skanowania packages oraz zdefiniowania dodatkowej konfiguracji
@SpringBootApplication
public class SystemZarzadzaniaDokumentamiApplication {

	public static void main(String[] args) {
		
		// Ładuje aplikacje - uruchamia Spring framework
		SpringApplication.run(SystemZarzadzaniaDokumentamiApplication.class, args);
	}
}