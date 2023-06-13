package com.projetocontabancaria.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetocontabancaria.domain.Conta;
import com.projetocontabancaria.domain.dto.ContaSaldoDTO;
import com.projetocontabancaria.domain.enums.TipoConta;
import com.projetocontabancaria.repositories.ContaRepository;
import com.projetocontabancaria.repositories.TransacaoRepository;
import com.projetocontabancaria.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	public Conta criarConta(Conta obj) {
		obj.setIdConta(null);
		LocalDate hoje = LocalDate.now();
		obj.setDataCriacao(hoje);
		obj.setSaldo(0.0);
		obj.setFlagAtivo(true);
		
		obj = contaRepository.save(obj);
		return obj;
	}
	
	public Conta retornaContaPorId(Long idConta) {
		Optional<Conta> obj = contaRepository.findById(idConta);
		return obj.orElseThrow(() -> new ResourceNotFoundException(idConta));
	}
	
	public Conta retornaConta(Long idConta){
		return contaRepository.getReferenceById(idConta);
	}
	
	public Conta depositaNaConta(Long idConta, Conta novoValor) {
		
		try {
			Conta entidade = retornaConta(idConta);
			updateDeposito(entidade, novoValor);
			
			return contaRepository.save(entidade);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(idConta);
		}
		
	}
	
	public ContaSaldoDTO retornaSaldo(Long idConta) {
		Conta conta = retornaContaPorId(idConta);
		ContaSaldoDTO contaSaldoDTO = new ContaSaldoDTO(conta);
		return contaSaldoDTO;
	}
	
	public Conta saqueNaConta(Long idConta, Conta novoValor) {
		try {
			Conta entidade = retornaConta(idConta);

			updateSaque(entidade, novoValor);
			return contaRepository.save(entidade);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(idConta);
		}
		
	}
	
	public Conta bloqueiaConta(Long idConta) {
		Conta entidade = retornaContaPorId(idConta);
		
		updateFlagAtivo(entidade);
		return contaRepository.save(entidade);
	}

	private void updateDeposito(Conta entidade, Conta novoValor) {
		Double saldoAtual = entidade.getSaldo();
		entidade.setSaldo(saldoAtual += novoValor.getSaldo());
	}
	
	private void updateSaque(Conta entidade, Conta novoValor) {
		Double saldoAtual = entidade.getSaldo();
		TipoConta tipoConta = entidade.getTipoConta();
		if(entidade.getSaldo() + novoValor.getSaldo() < 0.0 && (tipoConta == TipoConta.CONTA_SALARIO || tipoConta == TipoConta.CONTA_POUPANCA)) {
			throw new IllegalArgumentException("Não se pode sacar mais do que o saldo atual para esse tipo de conta");
		} else {
			entidade.setSaldo(saldoAtual -= novoValor.getSaldo());
		}
	}
	
	private void updateFlagAtivo(Conta entidade) {
		entidade.setFlagAtivo(false);
	}
}