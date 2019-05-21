package com.desafio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.entidade.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
	
	public Cidade findByNomeCidadeAndPais(String nome, String pais);
}
