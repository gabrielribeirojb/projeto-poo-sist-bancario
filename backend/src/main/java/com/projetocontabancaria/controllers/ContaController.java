package com.projetocontabancaria.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetocontabancaria.domain.Conta;
import com.projetocontabancaria.domain.Transacao;
import com.projetocontabancaria.domain.dto.ContaSaldoDTO;
import com.projetocontabancaria.services.ContaService;

@RestController
@RequestMapping(value = "/contas")
public class ContaController {
	
	@Autowired
	private ContaService contaService;
	
	@PostMapping(value = "/criar")
	public ResponseEntity<Void> inserir(@RequestBody Conta obj){
		obj = contaService.criarConta(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idConta}").buildAndExpand(obj.getIdConta()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{idConta}/depositar")
	public ResponseEntity<Conta> deposito(@PathVariable Long idConta, @RequestBody Conta novoValor){
		novoValor = contaService.depositaNaConta(idConta, novoValor);
		return ResponseEntity.ok().body(novoValor);
	}
	
	@GetMapping(value = "/{idConta}/saldo")
	public ResponseEntity<ContaSaldoDTO> consultaSaldo(@PathVariable Long idConta){
		ContaSaldoDTO contaSaldoDTO = contaService.retornaSaldo(idConta);
		return ResponseEntity.ok().body(contaSaldoDTO);
	}
	
	@PutMapping(value = "/{idConta}/sacar")
	public ResponseEntity<Conta> sacar(@PathVariable Long idConta, @RequestBody Conta novoValor){
		novoValor = contaService.saqueNaConta(idConta, novoValor);
		return ResponseEntity.ok().body(novoValor);
	}
	
	@GetMapping(value = "/{idConta}/transacoes")
	public ResponseEntity<List<Transacao>> retornaTransacoes(@PathVariable Long idConta){
		Conta conta = contaService.retornaContaPorId(idConta);
		List<Transacao> transacoes = conta.getTransacoes();
		return ResponseEntity.ok().body(transacoes);
	}
	
	@PutMapping(value = "/{idConta}/bloquear")
	public ResponseEntity<Conta> bloquear(@PathVariable Long idConta){
		Conta novoValor = contaService.bloqueiaConta(idConta);
		return ResponseEntity.ok().body(novoValor);
	}
}
