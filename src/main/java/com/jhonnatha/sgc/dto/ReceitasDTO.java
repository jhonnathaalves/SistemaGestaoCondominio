package com.jhonnatha.sgc.dto;

import java.io.Serializable;
import java.util.Date;

import com.jhonnatha.sgc.domain.Receitas;

public class ReceitasDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String descricao;
	private Double valor;	
	private Date data;
	
	public ReceitasDTO() {
		super();
	}
	
	public ReceitasDTO(Receitas obj) {
		super();
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	

}
