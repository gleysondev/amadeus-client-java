package amadeus.java.client.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import amadeus.java.client.amadeus.Credencial;

@Configuration
public class Config {
	class MyInterceptor implements ClientHttpRequestInterceptor {
	    @Override
	    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
	       // request.getHeaders().set(HttpHeaders.AUTHORIZATION, "Bearer 6UhF6tO");
	        return execution.execute(request, body);
	    }
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new MyInterceptor());
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
}
