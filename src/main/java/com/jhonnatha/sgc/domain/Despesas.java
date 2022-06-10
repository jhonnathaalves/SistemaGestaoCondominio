package com.jhonnatha.sgc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Despesas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String fornecedor;
	private Double valor;
	private String tipo;
	private Date data;
	
	
	public Despesas() {
		super();
	}


	public Despesas(String id, String fornecedor, Double valor, String tipo, Date data) {
		super();
		this.id = id;
		this.fornecedor = fornecedor;
		this.valor = valor;
		this.tipo = tipo;
		this.data = data;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFornecedor() {
		return fornecedor;
	}


	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Despesas other = (Despesas) obj;
		return Objects.equals(id, other.id);
	}	
}
