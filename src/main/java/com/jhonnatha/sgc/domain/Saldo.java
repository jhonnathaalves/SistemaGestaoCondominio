package com.jhonnatha.sgc.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Saldo {
	
	@Id
	private String id;	
	private Double valor;
	private Date data;
	
	
	public Saldo() {
		super();	
	}
	
	public Saldo(String id, Double valor) {
		super();
		
		Date dataAtual = new Date();		
		
		this.id = id;
		this.valor = valor;
		this.data = dataAtual;
	}	
	
	
	public Saldo(String id, Double valor, Date data) {
		super();
		this.id = id;
		this.valor = valor;
		this.data = data;
	}	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Double Creditar(Double valor, Double saldoExistente) {
		Double novoValor = saldoExistente + valor;
		return novoValor;
	}
	
	public Double Debitar(Double valor, Double saldoExistente) {
		Double novoValor = saldoExistente - valor;
		return novoValor;
	}
	
	

}
