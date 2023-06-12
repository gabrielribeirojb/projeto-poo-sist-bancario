package com.projetocontabancaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetocontabancaria.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
} 