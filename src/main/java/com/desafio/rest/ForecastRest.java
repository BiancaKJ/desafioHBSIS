package com.desafio.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.service.ForecastService;

@RestController
@RequestMapping("/forecast")
public class ForecastRest {
	
	@Autowired
	private ForecastService forecastService;

	@GetMapping(value = "/{cidade}/{pais}")
	public HttpEntity<String> buscaPrevisao(@PathVariable("cidade") String nomeCidade, @PathVariable("pais") String pais) {
		return forecastService.buscaPrevisao(nomeCidade, pais);
	}
	
	@GetMapping(value = "/previsoes")
	public HttpEntity<String> buscaPrevisoes() {
		return forecastService.getPrevisoes();
	}
}
