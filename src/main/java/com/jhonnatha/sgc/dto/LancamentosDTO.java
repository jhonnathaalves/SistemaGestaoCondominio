package com.jhonnatha.sgc.dto;

import java.io.Serializable;
import java.util.Date;

import com.jhonnatha.sgc.domain.Lancamentos;
import com.jhonnatha.sgc.domain.enums.TipoLancamento;

public class LancamentosDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private TipoLancamento tipoLancamento;
	private String descricao;
	private Double valor;
	private Date data;
	
	public LancamentosDTO() {
		super();
	}
	
	public LancamentosDTO(Lancamentos obj) {
		super();
		this.id = obj.getId();
		this.tipoLancamento = obj.getTipoLancamento();
		this.descricao = obj.getDescricao();
		this.valor = obj.getValor();		
		this.data = obj.getData();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}	

}
