package com.jhonnatha.sgc.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Colaboradores extends User {

	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	private String empresa;
	
	
	public Colaboradores() {
		super();
	}


	public Colaboradores(String cnpj, String empresa) {
		super();
		this.cnpj = cnpj;
		this.empresa = empresa;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}	

}
