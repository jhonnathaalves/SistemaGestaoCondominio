package com.jhonnatha.sgc.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.jhonnatha.sgc.domain.Blocos;
import com.jhonnatha.sgc.domain.Unidades;

public class BlocosDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private Integer numero;
	private List<Unidades> unidades = new ArrayList<>();

	public BlocosDTO() {
	}

	public BlocosDTO(Blocos obj) {
		super();
		this.id = obj.getId();
		this.numero = obj.getNumero();		
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

	public List<Unidades> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<Unidades> unidades) {
		this.unidades = unidades;
	}

}
