package com.jhonnatha.sgc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonnatha.sgc.domain.Unidades;
import com.jhonnatha.sgc.dto.UnidadesDTO;
import com.jhonnatha.sgc.repository.UnidadesRepository;
import com.jhonnatha.sgc.services.exception.ObjectNotFoundException;

@Service
public class UnidadesService {

	@Autowired
	private UnidadesRepository repo;

	public List<Unidades> findAll() {
		return repo.findAll();
	}

	public Unidades findById(String id) {
		Optional<Unidades> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Unidades insert(Unidades obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		repo.deleteById(id);
	}

	public Unidades update(Unidades obj) {
		Unidades newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Unidades newObj, Unidades obj) {
		newObj.setNumero(obj.getNumero());		
	}

	public Unidades fromDTO(UnidadesDTO objDto) {
		return new Unidades(objDto.getId(), objDto.getNumero(), objDto.getBloco());

	}

}
