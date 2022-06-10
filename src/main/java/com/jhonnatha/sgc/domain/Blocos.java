package com.jhonnatha.sgc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Blocos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Integer numero;

	@DBRef(lazy = true)
	private List<Unidades> unidades = new ArrayList<>();

	public Blocos() {
		super();
	}

	public Blocos(String id, Integer numero) {
		super();
		this.id = id;
		this.numero = numero;		
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
		Blocos other = (Blocos) obj;
		return Objects.equals(id, other.id);
	}

}
