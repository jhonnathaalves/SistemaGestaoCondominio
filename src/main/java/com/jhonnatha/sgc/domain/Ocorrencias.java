package com.jhonnatha.sgc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.jhonnatha.sgc.domain.enums.Status;
import com.jhonnatha.sgc.dto.AuthorDTO;

@Document
public class Ocorrencias implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String titulo;	
    private String descricao;
    private Status status;
    private AuthorDTO autor;
    private Date data;
    private String resposta;
    private Date dataResposta;
    private AuthorDTO autorResposta;
    
	public Ocorrencias() {
		super();
    }	

	public Ocorrencias(String id, String titulo, String descricao, Status status, AuthorDTO autor, Date data,
			String resposta, Date dataResposta, AuthorDTO autorResposta) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.status = status;
		this.autor = autor;
		this.data = data;
		this.resposta = resposta;
		this.dataResposta = dataResposta;
		this.autorResposta = autorResposta;
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


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
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
		Ocorrencias other = (Ocorrencias) obj;
		return Objects.equals(id, other.id);
	}
    
    
}
