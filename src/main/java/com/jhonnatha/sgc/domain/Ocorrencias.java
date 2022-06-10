package com.jhonnatha.sgc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.jhonnatha.sgc.dto.AuthorDTO;
import com.jhonnatha.sgc.dto.ResponseDTO;

@Document
public class Ocorrencias implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String titulo;
    private String mensagem;
    private AuthorDTO autor;
    private Date data;
    
    private List<ResponseDTO> resposta = new ArrayList<>();
    
	public Ocorrencias() {
		super();
    }

	public Ocorrencias(String id, String titulo, String mensagem, AuthorDTO autor, Date data) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.autor = autor;
		this.data = data;		
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
