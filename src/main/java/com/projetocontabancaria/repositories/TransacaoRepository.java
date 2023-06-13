package com.projetocontabancaria.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projetocontabancaria.domain.Transacao;


@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

	@Query("SELECT obj FROM Transacao obj WHERE obj.dataTransacao BETWEEN :dataMin AND :dataMax ORDER BY obj.idTransacao DESC")
	Page<Transacao> findTransacoesPaginado(LocalDate dataMin, LocalDate dataMax, Pageable pageable);
}