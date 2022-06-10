package com.jhonnatha.sgc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.jhonnatha.sgc.dto.AuthorDTO;

@Document
public class Comunicados  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String titulo;
    private String mensagem;
    private AuthorDTO autor;
    private Date data;
    
    
	public Comunicados() {
		super();
	}


	public Comunicados(String id, String titulo, String mensagem, AuthorDTO autor, Date data) {
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
		Comunicados other = (Comunicados) obj;
		return Objects.equals(id, other.id);
	}
	
	
    
    
	
	

}
