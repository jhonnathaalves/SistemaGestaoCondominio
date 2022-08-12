package com.jhonnatha.sgc.domain.enums;

public enum TipoVisita {
	
	VISITANTE("VISITANTE"), PRESTADOR_SERVICO("PRESTADOR_SERVICO");
	
	private String descricao;
	
	private TipoVisita(String descricao) {		
		this.descricao = descricao;
	}
	
	public String getDescricao () {
		return descricao;
	}

}
