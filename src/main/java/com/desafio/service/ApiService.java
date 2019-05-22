/*package com.desafio.service;

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService implements RestTemplateCustomizer{
	
	private final RestTemplate restTemplate;
	
	String urlApi = "https://api.openweathermap.org/data/2.5/forecast?q=London,us&mode=xml";
	String key = "&appid=eb8b1a9405e659b2ffc78f0a520b1a46";
	
	
	public void customize(RestTemplate restTemplate) {
		HttpHost proxy = new HttpHost(urlApi+key);
		
	}

	
	
}
*/