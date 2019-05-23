package com.desafio.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.service.ForecastService;

@RestController
@RequestMapping("/forecast")
public class ForecastRest {
	
	@Autowired
	private ForecastService forecastService;

	@PostMapping(value = "/{cidade}/{pais}")
	public void save(@PathVariable("cidade") String nomeCidade, @PathVariable("pais") String pais) {
		forecastService.buscaPrevisao(nomeCidade, pais);
	}
}
