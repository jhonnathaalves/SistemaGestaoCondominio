package com.jhonnatha.sgc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

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
	
	@DBRef(lazy = true)
	private Unidades unidade;
	
	@DBRef(lazy=true)
	private List<Ocorrencias> ocorrencias = new ArrayList<>();
	
	//@DBRef(lazy=true)
	//@Indexed(unique=true)
	private Set<String> perfis = new HashSet<>();	
	
	@DBRef(lazy=true)
	private List<Comunicados> comunicados = new ArrayList<>();
	
	//@DBRef(lazy=true)
	//private Unidades unidade;
	
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

	public User(String id, String nome, String sobrenome, String cpf, String email, String telefone, String senha,
			Set<String> perfis) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.perfis = perfis;
	}
	
	public User(String id, String nome, String sobrenome, String cpf, String email, String telefone, String senha,
			 Unidades unidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;		
		this.unidade = unidade;}
	
	

	public User(String id, String nome, String sobrenome, String cpf, String email, String telefone, String senha,
			Unidades unidade, Set<String> perfis) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.unidade = unidade;
		this.perfis = perfis;
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
		this.perfis = user.getPerfis();
		this.unidade = user.getUnidade();
		
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
	
	
	public Unidades getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidades unidade) {
		this.unidade = unidade;
	}

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
	//public Unidades getUnidade() {
		//return unidade;
	//}

	//public void setUnidade(Unidades unidade) {
		//this.unidade = unidade;
	//}


	public void setPerfis(Set<String> perfis) {
		this.perfis = perfis;
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
