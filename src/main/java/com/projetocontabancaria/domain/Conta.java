package com.projetocontabancaria.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.projetocontabancaria.domain.enums.TipoConta;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "contas")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConta;
	
	@OneToOne
	@JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
	private Pessoa pessoa;
	
	@OneToMany(mappedBy = "conta")
	private List<Transacao> transacoes = new ArrayList<>();
	
	private Double saldo;
	private Double limiteSaqueDiario;
	private Boolean flagAtivo;
	private LocalDate dataCriacao;
	private Integer tipoConta;
	
	public Conta() {
		
	}
	
	public Conta(Long idConta, Double saldo, Double limiteSaqueDiario, Boolean flagAtivo, LocalDate dataCriacao, Pessoa pessoa, TipoConta tipoConta) {
		super();
		this.idConta = idConta;
		this.saldo = saldo;
		this.limiteSaqueDiario = limiteSaqueDiario;
		this.flagAtivo = flagAtivo;
		this.dataCriacao = dataCriacao;
		this.pessoa = pessoa;
		setTipoConta(tipoConta);
	}

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getLimiteSaqueDiario() {
		return limiteSaqueDiario;
	}

	public void setLimiteSaqueDiario(Double limiteSaqueDiario) {
		this.limiteSaqueDiario = limiteSaqueDiario;
	}

	public Boolean getFlagAtivo() {
		return flagAtivo;
	}

	public void setFlagAtivo(Boolean flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<Transacao> getTransacoes() {
		return transacoes;
	}
	
	public TipoConta getTipoConta() {
		return TipoConta.valueOf(tipoConta);
	}
	
	public void setTipoConta(TipoConta tipoConta) {
		if(tipoConta != null) {
			this.tipoConta = tipoConta.getCodigo();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(idConta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(idConta, other.idConta);
	}
	
	
}
