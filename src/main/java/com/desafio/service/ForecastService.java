package com.desafio.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ForecastService{
	
	RestTemplate restTemplate = new RestTemplate();	
	String urlApi = "https://api.openweathermap.org";
	String key = "eb8b1a9405e659b2ffc78f0a520b1a46";
	String cidade;
	
	public HttpEntity<String> buscaPrevisao(String nomeCidade, String pais) {
		
		cidade = nomeCidade+","+pais;
		
		UriComponentsBuilder builder = UriComponentsBuilder
				.fromHttpUrl(urlApi)
				.path("/data/2.5/forecast")
				.queryParam("q",cidade)
				.queryParam("mode","json")
				.queryParam("appid", key);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers); 		
		
		HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
		
		return response;
	}	
	
}
