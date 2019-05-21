package com.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.entidade.Cidade;
import com.desafio.repositorio.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	public void addCidade(String nome, String pais) {

		Cidade cidade = cidadeRepository.findByNomeCidadeAndPais(nome, pais);
		if(cidade == null) {
			Cidade newCidade = new Cidade();
			newCidade.setNomeCidade(nome);
			newCidade.setPais(pais);
			save(newCidade);
		}		
	}

	public void save(Cidade cidade) {
		cidadeRepository.save(cidade);
	}

	public List<Cidade> getTodasCidades() {
		return cidadeRepository.findAll();
	}
}
