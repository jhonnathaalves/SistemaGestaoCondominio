package com.jhonnatha.sgc.dto;

import java.io.Serializable;
import java.util.Date;

import com.jhonnatha.sgc.domain.Despesas;

public class DespesasDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String fornecedor;
	private Double valor;
	private String tipo;
	private Date data;

	public DespesasDTO() {
	}

	public DespesasDTO(Despesas obj) {
		super();
		this.id = obj.getId();
		this.fornecedor = obj.getFornecedor();
		this.valor = obj.getValor();
		this.tipo = obj.getTipo();
		this.data = obj.getData();
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

}
