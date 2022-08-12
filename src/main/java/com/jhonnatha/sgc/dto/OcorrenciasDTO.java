package com.jhonnatha.sgc.dto;

import java.io.Serializable;
import java.util.Date;

import com.jhonnatha.sgc.domain.Ocorrencias;
import com.jhonnatha.sgc.domain.enums.Status;

public class OcorrenciasDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String titulo;
	private Status status;
	private String descricao;
	private AuthorDTO autor;
	private Date data;
	private String resposta;
    private Date dataResposta;
    private AuthorDTO autorResposta;

	public OcorrenciasDTO() {
		super();
	}

	public OcorrenciasDTO(Ocorrencias obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();		
		this.descricao = obj.getDescricao();
		this.status = obj.getStatus();
		this.autor = obj.getAutor();
		this.data = obj.getData();
		this.resposta = obj.getResposta();
		this.dataResposta = obj.getDataResposta();
		this.autorResposta = obj.getAutorResposta();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}	

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public AuthorDTO getAutor() {
		return autor;
	}

	public void setAutor(AuthorDTO autor) {
		this.autor = autor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public Date getDataResposta() {
		return dataResposta;
	}

	public void setDataResposta(Date dataResposta) {
		this.dataResposta = dataResposta;
	}

	public AuthorDTO getAutorResposta() {
		return autorResposta;
	}

	public void setAutorResposta(AuthorDTO autorResposta) {
		this.autorResposta = autorResposta;
	}
	
	

}
