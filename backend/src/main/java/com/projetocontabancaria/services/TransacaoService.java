package com.projetocontabancaria.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projetocontabancaria.domain.Transacao;
import com.projetocontabancaria.repositories.TransacaoRepository;

@Service
public class TransacaoService {
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	public Page<Transacao> findTransacoes(String dataMin, String dataMax, Pageable pageable) {
		LocalDate hoje = LocalDate.now();
		
		LocalDate min = dataMin.equalsIgnoreCase("") ? hoje.minusDays(30): LocalDate.parse(dataMin);
		LocalDate max = dataMin.equalsIgnoreCase("") ? hoje: LocalDate.parse(dataMax);
		
		return transacaoRepository.findTransacoesPaginado(min, max, pageable);

	}
}
