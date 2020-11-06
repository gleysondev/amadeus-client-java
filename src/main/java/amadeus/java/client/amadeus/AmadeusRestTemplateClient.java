package amadeus.java.client.amadeus;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import amadeus.java.client.JsonUtil;

@Service
public class AmadeusRestTemplateClient {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private JsonUtil jsonUtil;
	
	@Autowired
	private Credencial credencial;
	
	@Autowired
	private MyKey key;
	
	final String ROOT_URI = "https://test.api.amadeus.com/";
	
	public void login() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("grant_type", "client_credentials");
		map.add("client_id", key.getId());
		map.add("client_secret", key.getSecret());
		

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<Credencial> response = restTemplate.postForEntity( ROOT_URI + "/v1/security/oauth2/token", request , Credencial.class );
		credencial = response.getBody();
		
	}
	
	public void ofertasObject() {
		
		String url = ROOT_URI + "/v2/shopping/flight-offers?originLocationCode=SYD&destinationLocationCode=BKK&departureDate=2020-12-01&returnDate=2020-12-05&adults=1&max=2";
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.AUTHORIZATION, credencial.getToken());
		
		System.out.println(credencial.getToken());

		HttpEntity entity = new HttpEntity(headers);
		try {
		
			ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
		
			//convertendo em String a resposta
			String reposta = jsonUtil.toString(response.getBody());
		
			//salvando em disco o json
			jsonUtil.toFile(response.getBody(),new File("c:\\dev\\lista-ofertas.json"));
			
			System.out.println("FIM");
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
