package com.desafio.rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.entidade.Cidade;
import com.desafio.service.CidadeService;

@RestController
@RequestMapping("/cidade")
public class CidadeRest {

	@Autowired
	private CidadeService cidadeService;

	@PersistenceContext
	public EntityManager em;

	@GetMapping("/list")
	public List<Cidade> getAll() {
		return cidadeService.getTodasCidades();
	}

	@PostMapping(value = "/{cidade}/{pais}")
	public void save(@PathVariable("cidade") String nomeCidade, @PathVariable("pais") String pais) {
		cidadeService.addCidade(nomeCidade, pais);
	}
}
