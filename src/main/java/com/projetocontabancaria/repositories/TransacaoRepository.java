package com.projetocontabancaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetocontabancaria.domain.Transacao;


@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
		
}