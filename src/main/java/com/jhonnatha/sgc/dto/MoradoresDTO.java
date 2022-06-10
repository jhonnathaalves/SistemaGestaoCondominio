package com.jhonnatha.sgc.dto;

import com.jhonnatha.sgc.domain.Blocos;
import com.jhonnatha.sgc.domain.Moradores;
import com.jhonnatha.sgc.domain.Unidades;

public class MoradoresDTO extends UserDTO {

	private static final long serialVersionUID = 1L;	

	private Unidades unidade;
	private Blocos bloco;

	public MoradoresDTO() {
		super();
	}

	public MoradoresDTO(Moradores colab) {
		super();
		this.nome = colab.getNome();
		this.sobrenome = colab.getNome();
		this.cpf = colab.getCpf();
		this.email = colab.getEmail();
		this.telefone = colab.getTelefone();
		this.bloco = colab.getBloco();
		this.unidade = colab.getUnidade();
		
	}

	public Unidades getUnidades() {
		return unidade;
	}

	public void setUnidades(Unidades unidades) {
		this.unidade = unidades;
	}

	public Unidades getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidades unidade) {
		this.unidade = unidade;
	}

	public Blocos getBloco() {
		return bloco;
	}

	public void setBloco(Blocos bloco) {
		this.bloco = bloco;
	}

}
