package com.jhonnatha.sgc.domain.enums;

public enum Perfil {

	ROLE_ADMIN("ROLE_ADMIN"), ROLE_USER("ROLE_USER"), ROLE_COLABORADOR("ROLE_COLABORADOR");
	
	private String descricao;
	
	private Perfil(String descricao) {		
		this.descricao = descricao;
	}
	
	public String getDescricao () {
		return descricao;
	}

}
