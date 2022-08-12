package com.jhonnatha.sgc.domain;

import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Receitas {
	
	@Id
	private String id;
	private String descricao;
	private Double valor;
	private Date data;
	
	public Receitas() {
		super();		
	}

	public Receitas(String id,String descricao, Double valor, Date data) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
	}	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		Receitas other = (Receitas) obj;
		return Objects.equals(id, other.id);
	}
	

}
