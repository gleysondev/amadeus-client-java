package amadeus.java.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import amadeus.java.client.amadeus.AmadeusRestTemplateClient;

@SpringBootApplication
public class AmadeusClientJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmadeusClientJavaApplication.class, args);
	}
	@Bean
    public CommandLineRunner run( AmadeusRestTemplateClient c) {
        return args -> {
        	c.login();
        	c.ofertasObject();
        };
    }

}
