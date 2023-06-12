package com.projetocontabancaria.domain.dto;

import com.projetocontabancaria.domain.Conta;

public class ContaSaldoDTO {
	
	private Double saldo;
	
	public ContaSaldoDTO() {
		
	}
	
	public ContaSaldoDTO(Conta conta) {
		this.saldo = conta.getSaldo();
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
}