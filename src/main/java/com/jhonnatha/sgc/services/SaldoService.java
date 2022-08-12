package com.jhonnatha.sgc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonnatha.sgc.domain.Saldo;
import com.jhonnatha.sgc.repository.SaldoRepository;
import com.jhonnatha.sgc.services.exception.ObjectNotFoundException;
import com.jhonnatha.sgc.services.exception.OperationException;

@Service
public class SaldoService {
	
	@Autowired
	private SaldoRepository repoSal;
	
	public void creditarValor(Double valor)  {
		if ( valor == 0) {
			throw new OperationException("O valor não pode ser nulo!!");			
		}		
		
		Saldo saldoAtual = repoSal.findFirstByOrderByIdDesc();
		Double valorAtual = saldoAtual.getValor();
		Double valorAtualizado = valor + valorAtual;
		Saldo novoSaldo = new Saldo(null,valorAtualizado);
		repoSal.save(novoSaldo);
		
	}	
	
	public void debitarValor(Double valor)  {
		if ( valor == 0) {
			throw new OperationException("O valor não pode ser nulo ou negativo!!");			
		}
		
		Saldo saldoAtual = repoSal.findFirstByOrderByIdDesc();
		Double valorAtual = saldoAtual.getValor();
		Double valorAtualizado = valorAtual - valor;
		Saldo novoSaldo = new Saldo(null,valorAtualizado);
		repoSal.save(novoSaldo);
		
	}

	public List<Saldo> findAll() {
		return repoSal.findAll();
	}

	public Saldo findById(String id) {
		Optional<Saldo> obj = repoSal.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Saldo SaldoAtual() {
		return repoSal.findFirstByOrderByIdDesc();
	}


}
