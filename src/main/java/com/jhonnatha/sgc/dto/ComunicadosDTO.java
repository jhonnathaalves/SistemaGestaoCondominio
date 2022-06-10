package com.jhonnatha.sgc.dto;

import java.io.Serializable;
import java.util.Date;

import com.jhonnatha.sgc.domain.Comunicados;

public class ComunicadosDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String titulo;
	private String mensagem;
	private AuthorDTO autor;
	private Date data;

	public ComunicadosDTO() {
	}

	public ComunicadosDTO(Comunicados obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.mensagem = obj.getMensagem();
		this.autor = obj.getAutor();
		this.data = obj.getData();
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

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
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

}
