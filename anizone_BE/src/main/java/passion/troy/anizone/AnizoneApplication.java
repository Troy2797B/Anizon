package passion.troy.anizone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "passion.troy.anizone")
public class AnizoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnizoneApplication.class, args);
	}
}
