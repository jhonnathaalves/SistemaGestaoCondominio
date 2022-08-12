package com.jhonnatha.sgc.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Unidades implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Integer numero;	
	private Integer bloco;

	public Unidades() {
		super();
	}

	public Unidades(String id, Integer numero, Integer bloco) {
		super();
		this.id = id;
		this.numero = numero;
		this.bloco = bloco;
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
		Unidades other = (Unidades) obj;
		return Objects.equals(id, other.id);
	}

}
