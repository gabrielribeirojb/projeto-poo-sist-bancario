package com.projetocontabancaria.domain;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transacoes")
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTransacao;
	private Double valor;
	private LocalDate dataTransacao;
	
	@ManyToOne
	@JoinColumn(name = "idConta")
	private Conta conta;
	
	public Transacao() {
		
	}
	
	
	public Transacao(Long idTransacao, Double valor, LocalDate dataTransacao) {
		this.idTransacao = idTransacao;
		this.valor = valor;
		this.dataTransacao = dataTransacao;
	}

	public Long getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(Long idTransacao) {
		this.idTransacao = idTransacao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDate getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(LocalDate dataTransacao) {
		this.dataTransacao = dataTransacao;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idTransacao);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transacao other = (Transacao) obj;
		return Objects.equals(idTransacao, other.idTransacao);
	}
	
	
}
