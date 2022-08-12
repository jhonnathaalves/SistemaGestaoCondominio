package com.jhonnatha.sgc.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.jhonnatha.sgc.domain.Unidades;
import com.jhonnatha.sgc.domain.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	protected String nome;
	protected String sobrenome;
	protected String cpf;
	protected String email;
	protected String telefone;

	protected String senha;	
	private Set<String> perfis = new HashSet<>();
	private Unidades unidade;

	public UserDTO() {
		super();
	}

	public UserDTO(User obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.sobrenome = obj.getSobrenome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.telefone = obj.getTelefone();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis();
		this.unidade = obj.getUnidade();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<String> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<String> perfis) {
		this.perfis = perfis;
	}

	public Unidades getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidades unidade) {
		this.unidade = unidade;
	}
	
	

}
