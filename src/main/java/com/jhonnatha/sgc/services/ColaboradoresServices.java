package com.jhonnatha.sgc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonnatha.sgc.domain.Colaboradores;
import com.jhonnatha.sgc.dto.ColaboradoresDTO;
import com.jhonnatha.sgc.repository.ColaboradoresRepository;
import com.jhonnatha.sgc.services.exception.ObjectNotFoundException;

@Service
public class ColaboradoresServices {
	
	@Autowired
	private ColaboradoresRepository repo;
	
	public List<Colaboradores> findAll(){		
		return repo.findAll();		
	}
	
	public Colaboradores findById(String id) {
		Optional<Colaboradores> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));		
	}
	
	public Colaboradores insert(Colaboradores obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}
	
	public Colaboradores update(Colaboradores obj) {
		Colaboradores newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Colaboradores newObj, Colaboradores obj) {
		newObj.setNome(obj.getNome());
		newObj.setSobrenome(obj.getSobrenome());
		newObj.setCpf(obj.getCpf());
		newObj.setEmail(obj.getEmail());
		newObj.setTelefone(obj.getTelefone());
		
	}

	public Colaboradores fromDTO(ColaboradoresDTO objDto) {
		return new Colaboradores(
				objDto.getCnpj(),
				objDto.getEmpresa());
		  
	}


}
