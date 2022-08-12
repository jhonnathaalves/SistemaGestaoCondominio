package com.jhonnatha.sgc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.jhonnatha.sgc.domain.enums.TipoLancamento;

@Document
public class Lancamentos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private TipoLancamento tipoLancamento;
	private String descricao;
	private Double valor;
	private Date data;
	
	public Lancamentos() {
		super();	
	}

	public Lancamentos(String id, TipoLancamento tipoLancamento, String descricao, Double valor, Date data) {
		super();
		this.id = id;
		this.tipoLancamento = tipoLancamento;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		Lancamentos other = (Lancamentos) obj;
		return Objects.equals(id, other.id);
	}
	
}
