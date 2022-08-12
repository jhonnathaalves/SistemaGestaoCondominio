package com.jhonnatha.sgc.dto;

import java.io.Serializable;
import java.util.Date;

import com.jhonnatha.sgc.domain.enums.TipoVisita;

public class VisitasDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String nome;
	private Date horaEntrada;
	private TipoVisita tipoVisita;
	private Integer unidade;	
	private Integer bloco;

	public VisitasDTO() {
		super();
	}

	public VisitasDTO(String id, String nome, Date horaEntrada, TipoVisita tipoVisita, Integer unidade, Integer bloco) {
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

	public TipoVisita getTipoVisita() {
		return tipoVisita;
	}

	public void setTipoVisita(TipoVisita tipoVisita) {
		this.tipoVisita = tipoVisita;
	}

	public Integer getUnidade() {
		return unidade;
	}

	public void setUnidade(Integer unidade) {
		this.unidade = unidade;
	}

	public Integer getBloco() {
		return bloco;
	}

	public void setBloco(Integer bloco) {
		this.bloco = bloco;
	}	

}
