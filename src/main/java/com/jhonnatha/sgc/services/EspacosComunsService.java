package com.jhonnatha.sgc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonnatha.sgc.domain.EspacosComuns;
import com.jhonnatha.sgc.dto.EspacosComunsDTO;
import com.jhonnatha.sgc.repository.EspacosComunsRepository;
import com.jhonnatha.sgc.services.exception.ObjectNotFoundException;

@Service
public class EspacosComunsService {

	@Autowired
	private EspacosComunsRepository repo;

	public List<EspacosComuns> findAll() {
		return repo.findAll();
	}

	public EspacosComuns findById(String id) {
		Optional<EspacosComuns> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public EspacosComuns insert(EspacosComuns obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		repo.deleteById(id);
	}

	public EspacosComuns update(EspacosComuns obj) {
		EspacosComuns newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(EspacosComuns newObj, EspacosComuns obj) {
		newObj.setNome(obj.getNome());
		newObj.setCapacidade(obj.getCapacidade());		

	}
	
	public EspacosComuns fromDTO(EspacosComunsDTO objDto) {
		return new EspacosComuns(objDto.getId(), objDto.getNome(),objDto.getCapacidade());

	}

}
