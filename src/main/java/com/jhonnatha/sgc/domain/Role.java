package com.jhonnatha.sgc.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.jhonnatha.sgc.domain.enums.Perfil;

@Document
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String nomeRole;

	public Role() {
	}

	public Role(String nomeRole) {
		super();
		this.nomeRole = nomeRole;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getnomeRole() {
		return nomeRole;
	}

	public void setnomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}
	
	

}
