package com.desafio.service;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ForecastService{
	
	RestTemplate restTemplate = new RestTemplate();	
	String urlApi = "https://api.openweathermap.org/data/2.5/forecast";
	String key = "&appid=eb8b1a9405e659b2ffc78f0a520b1a46";
	
	public HttpEntity<String> buscaPrevisao(String nomeCidade, String pais){
		
		String cidade = nomeCidade+","+pais;
		
		UriComponentsBuilder builder = UriComponentsBuilder
				.fromHttpUrl(urlApi)
				.queryParam("q",cidade)
				.queryParam("mode","json")
				.queryParam("appid", key);
				
		HttpEntity<String> response = restTemplate.getForEntity(builder.toString(), String.class);
		
		return response;
	}	
	
}
