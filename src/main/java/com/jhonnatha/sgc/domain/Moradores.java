package com.jhonnatha.sgc.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Moradores extends User {

	private static final long serialVersionUID = 1L;

	private Unidades unidade;
	private Blocos bloco;
	

	public Moradores() {
		super();
	}

	public Moradores(Unidades unidade, Blocos bloco) {
		super();
		this.unidade = unidade;
		this.bloco = bloco;
	}

	public Unidades getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidades unidade) {
		this.unidade = unidade;
	}

	public Blocos getBloco() {
		return bloco;
	}

	public void setBloco(Blocos bloco) {
		this.bloco = bloco;
	}

}
