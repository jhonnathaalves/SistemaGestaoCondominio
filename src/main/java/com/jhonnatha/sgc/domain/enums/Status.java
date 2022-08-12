package com.jhonnatha.sgc.domain.enums;

public enum Status {


	ABERTO("ABERTO"), FECHADO("FECHADO");
	
	private String descricao;
	
	private Status(String descricao) {		
		this.descricao = descricao;
	}
	
	public String getDescricao () {
		return descricao;
	}
}
