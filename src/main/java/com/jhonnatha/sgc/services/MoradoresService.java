package com.jhonnatha.sgc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonnatha.sgc.domain.Moradores;
import com.jhonnatha.sgc.dto.MoradoresDTO;
import com.jhonnatha.sgc.repository.MoradoresRepository;
import com.jhonnatha.sgc.services.exception.ObjectNotFoundException;

@Service
public class MoradoresService {

	@Autowired
	private MoradoresRepository repo;

	public List<Moradores> findAll() {
		return repo.findAll();
	}

	public Moradores findById(String id) {
		Optional<Moradores> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Moradores insert(Moradores obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		repo.deleteById(id);
	}

	public Moradores update(Moradores obj) {
		Moradores newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Moradores newObj, Moradores obj) {
		newObj.setUnidade(obj.getUnidade());
		newObj.setBloco(obj.getBloco());

	}
	
	public Moradores fromDTO(MoradoresDTO objDto) {
		return new Moradores(
				objDto.getUnidade(),
				objDto.getBloco());
		  
	}

}
