package com.jhonnatha.sgc.dto;

import java.io.Serializable;
import java.util.Date;

import com.jhonnatha.sgc.domain.Saldo;

public class SaldoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;	
	private Double valor;	
	private Date data;
	
	public SaldoDTO() {
		super();
	}
	
	public SaldoDTO(Saldo obj) {
		super();
		this.id = obj.getId();		
		this.valor = obj.getValor();		
		this.data = obj.getData();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	

}
