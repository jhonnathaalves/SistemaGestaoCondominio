package com.jhonnatha.sgc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonnatha.sgc.domain.Despesas;
import com.jhonnatha.sgc.dto.DespesasDTO;
import com.jhonnatha.sgc.repository.DespesasRepository;
import com.jhonnatha.sgc.services.exception.ObjectNotFoundException;

@Service
public class DespesasService {

	@Autowired
	private DespesasRepository repo;

	public List<Despesas> findAll() {
		return repo.findAll();
	}

	public Despesas findById(String id) {
		Optional<Despesas> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Despesas insert(Despesas obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		repo.deleteById(id);
	}

	public Despesas update(Despesas obj) {
		Despesas newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Despesas newObj, Despesas obj) {
		newObj.setFornecedor(obj.getFornecedor());
		newObj.setValor(obj.getValor());
		newObj.setTipo(obj.getTipo());
		newObj.setData(obj.getData());

	}
	
	public Despesas fromDTO(DespesasDTO objDto) {
		return new Despesas(objDto.getId(), objDto.getFornecedor(),objDto.getValor(),objDto.getTipo(),objDto.getData());

	}

}
