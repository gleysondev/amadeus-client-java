package amadeus.java.client.amadeus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credencial {
	@JsonProperty("access_token")
	private String token;
	public Credencial() {
		
	}
	public void setToken(String token) {
		this.token = "Bearer " + token;
	}
	public String getToken() {
		return token;
	}
	
}
