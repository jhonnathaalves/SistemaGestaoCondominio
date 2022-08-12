package com.jhonnatha.sgc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.jhonnatha.sgc.domain.enums.TipoVisita;

@Document
public class Visitas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String nome;
	private Date horaEntrada;
	private TipoVisita tipoVisita;
	private Integer unidade;	
	private Integer bloco;
	
	public Visitas() {
		super();
	}
		

	public Visitas(String id, String nome, Date horaEntrada, TipoVisita tipoVisita, Integer unidade, Integer bloco) {
		super();
		this.id = id;
		this.nome = nome;
		this.horaEntrada = horaEntrada;
		this.tipoVisita = tipoVisita;
		this.unidade = unidade;
		this.bloco = bloco;
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

	public Date getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}		

	public Integer getUnidade() {
		return unidade;
	}


	public void setUnidade(Integer unidade) {
		this.unidade = unidade;
	}
	

	public TipoVisita getTipoVisita() {
		return tipoVisita;
	}


	public void setTipoVisita(TipoVisita tipoVisita) {
		this.tipoVisita = tipoVisita;
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
		Visitas other = (Visitas) obj;
		return Objects.equals(id, other.id);
	}

}
