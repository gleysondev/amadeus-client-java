package amadeus.java.client.amadeus;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mykey")
public class MyKey {
	private String id;
	private String secret;
	
	public String getId() {
		return id;
	}
	public String getSecret() {
		return secret;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
}
