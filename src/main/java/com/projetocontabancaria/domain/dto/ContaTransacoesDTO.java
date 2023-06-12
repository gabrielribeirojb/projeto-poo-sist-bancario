package com.projetocontabancaria.domain.dto;

import java.util.ArrayList;
import java.util.List;

import com.projetocontabancaria.domain.Conta;
import com.projetocontabancaria.domain.Transacao;

public class ContaTransacoesDTO {

	private List<Transacao> transacoes = new ArrayList<>();
	
	public ContaTransacoesDTO(){
		
	}
	
	public ContaTransacoesDTO(Conta conta) {
		this.transacoes = conta.getTransacoes();
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}
}