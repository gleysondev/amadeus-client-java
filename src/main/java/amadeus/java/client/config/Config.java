package amadeus.java.client.config;

import java.io.File;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import amadeus.java.client.amadeus.Credencial;

@Configuration
public class Config {
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}
	
	@Bean
	public ObjectMapper mapper() {
		ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		return mapper;
	}
	
	@Bean
	public Credencial credencial() {
		return new Credencial();
	}
	
	@Bean
	public File storage() {
		File diretorio =new File("/temp/storage");
		if(!diretorio.exists())
			diretorio.mkdirs();
		return diretorio;
	}
}
