package com.jhonnatha.sgc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jhonnatha.sgc.config.TipoPerfilConverter;
import com.jhonnatha.sgc.domain.enums.Perfil;


@Document
public class User implements Serializable {	

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String nome;
	private String sobrenome;
	
	@Indexed(unique=true)
	private String cpf;
	@Indexed(unique=true)
	
	private String email;
	private String telefone;
	
	private String senha;
	
	@DBRef(lazy=true)
	private List<Ocorrencias> ocorrencias = new ArrayList<>();
	
	//@DBRef(lazy=true)
	//@Indexed(unique=true)
	private Set<String> perfis = new HashSet<>();	
	
	@DBRef(lazy=true)
	private List<Comunicados> comunicados = new ArrayList<>();
	
	
	public User() {
		super();		
	}
	
	public User(String id, String nome, String sobrenome, String cpf, String email, String telefone, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}


	public User (User user) {
		super();
		this.id = user.getId();
		this.nome = user.getNome();
		this.sobrenome = user.getSobrenome();
		this.cpf = user.getCpf();
		this.email = user.getEmail();
		this.telefone = user.getTelefone();
		this.senha = user.getSenha();
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

	public List<Ocorrencias> getOcorrencias() {
		return ocorrencias;
	}


	public void setOcorrencias(List<Ocorrencias> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}	
	
	//public Set<Perfil> getPerfis() {
		//return perfis.stream().map(x).collect(Collectors.toSet());
	//}
	
	public Set<String> getPerfis() {		
		return perfis;
	}

	public void addPerfil(Perfil perfil) {
		TipoPerfilConverter converter = new TipoPerfilConverter();
		perfis.add(converter.convertToEnumString(perfil));
	}

	public List<Comunicados> getComunicados() {
		return comunicados;
	}

	public void setComunicados(List<Comunicados> comunicados) {
		this.comunicados = comunicados;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
