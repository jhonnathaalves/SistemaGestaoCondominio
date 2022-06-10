package com.jhonnatha.sgc.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jhonnatha.sgc.domain.Ocorrencias;

public class OcorrenciasDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String titulo;
	private String mensagem;
	private AuthorDTO autor;
	private Date data;

	private List<ResponseDTO> resposta = new ArrayList<>();

	public OcorrenciasDTO() {
		super();
	}

	public OcorrenciasDTO(Ocorrencias obj) {
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

	public List<ResponseDTO> getResposta() {
		return resposta;
	}

	public void setResposta(List<ResponseDTO> resposta) {
		this.resposta = resposta;
	}

}
