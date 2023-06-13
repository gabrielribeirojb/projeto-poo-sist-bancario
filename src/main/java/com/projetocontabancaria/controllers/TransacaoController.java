package com.projetocontabancaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetocontabancaria.domain.Transacao;
import com.projetocontabancaria.services.TransacaoService;

@RestController
@RequestMapping(value = "/extratos")
public class TransacaoController {
	
	@Autowired
	private TransacaoService transacaoService;
	
	@GetMapping
	public Page<Transacao> pesquisaTransacoesPorData(
			@RequestParam (value="dataMin", defaultValue = "") String dataMin,
			@RequestParam (value="dataMax", defaultValue = "") String dataMax,
			Pageable pageable){
			return transacaoService.findTransacoes(dataMin, dataMax, pageable);
	} 
}