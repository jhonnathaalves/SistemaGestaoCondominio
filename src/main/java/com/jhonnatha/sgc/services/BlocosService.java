package com.jhonnatha.sgc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonnatha.sgc.domain.Blocos;
import com.jhonnatha.sgc.dto.BlocosDTO;
import com.jhonnatha.sgc.repository.BlocosRepository;
import com.jhonnatha.sgc.services.exception.ObjectNotFoundException;

@Service
public class BlocosService {
	
	@Autowired
	private BlocosRepository repo;
	
	public List<Blocos> findAll(){		
		return repo.findAll();		
	}
	
	public Blocos findById(String id) {
		Optional<Blocos> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));		
	}
	
	public Blocos insert(Blocos obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}
	
	public Blocos update(Blocos obj) {
		Blocos newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Blocos newObj, Blocos obj) {
		newObj.setNumero(obj.getNumero());
		newObj.setUnidades(obj.getUnidades());

	}

	public Blocos fromDTO(BlocosDTO objDto) {
		return new Blocos (
				objDto.getId(),
				objDto.getNumero());

	}

}
