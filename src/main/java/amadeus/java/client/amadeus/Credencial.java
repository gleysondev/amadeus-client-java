package amadeus.java.client.amadeus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credencial {
	@JsonProperty("access_token")
	private String token;
	
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Credencial() {
		
	}
	public void setToken(String token) {
		this.token = "Bearer " + token;
	}
	public String getToken() {
		return token;
	}
	
}
