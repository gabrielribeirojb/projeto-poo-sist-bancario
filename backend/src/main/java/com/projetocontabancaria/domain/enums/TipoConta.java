package com.projetocontabancaria.domain.enums;

public enum TipoConta {
	
	CONTA_POUPANCA(0, "Conta poupança"),
	CONTA_SALARIO(1, "Conta salário"),
	CONTA_CORRENTE(2, "Pessoa jurídica");
	
	private Integer codigo;
	private String descricao;
	
	private TipoConta(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoConta valueOf(Integer code) {
		
		if(code == null) {
			return null;
		}
		
		for(TipoConta value: TipoConta.values()) {
			if(value.getCodigo() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Código do TipoConta inválido");
	}
}