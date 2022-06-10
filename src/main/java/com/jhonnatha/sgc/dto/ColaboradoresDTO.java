package com.jhonnatha.sgc.dto;

import com.jhonnatha.sgc.domain.Colaboradores;

public class ColaboradoresDTO extends UserDTO {

	private static final long serialVersionUID = 1L;

	private String cnpj;
	private String empresa;

	public ColaboradoresDTO() {
		super();
	}

	public ColaboradoresDTO(Colaboradores colab) {
		super();
		this.cnpj = colab.getCnpj();
		this.empresa = colab.getEmpresa();
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
