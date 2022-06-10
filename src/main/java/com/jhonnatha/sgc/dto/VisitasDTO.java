package com.jhonnatha.sgc.dto;

import java.io.Serializable;
import java.util.Date;

import com.jhonnatha.sgc.domain.Unidades;

public class VisitasDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String nome;
	private Date data;
	private Unidades unidade;

	public VisitasDTO() {
		super();
	}

	public VisitasDTO(String id, String nome, Date data, Unidades unidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.data = data;
		this.unidade = unidade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Unidades getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidades unidade) {
		this.unidade = unidade;
	}

}
