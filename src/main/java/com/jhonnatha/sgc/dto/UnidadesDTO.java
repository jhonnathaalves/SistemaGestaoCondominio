package com.jhonnatha.sgc.dto;

import java.io.Serializable;

import com.jhonnatha.sgc.domain.Unidades;

public class UnidadesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private Integer numero;
	
	private Integer bloco;

	public UnidadesDTO() {
		super();
	}

	public UnidadesDTO(Unidades obj) {
		super();
		this.id = obj.getId();
		this.numero = obj.getNumero();
		this.bloco = obj.getBloco();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getBloco() {
		return bloco;
	}

	public void setBloco(Integer bloco) {
		this.bloco = bloco;
	}	

}
