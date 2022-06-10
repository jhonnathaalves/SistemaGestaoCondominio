package com.jhonnatha.sgc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonnatha.sgc.domain.Ocorrencias;
import com.jhonnatha.sgc.dto.OcorrenciasDTO;
import com.jhonnatha.sgc.repository.OcorrenciasRepository;
import com.jhonnatha.sgc.services.exception.ObjectNotFoundException;

@Service
public class OcorrenciasService {
	
	@Autowired
	private OcorrenciasRepository repo;
	
	public List<Ocorrencias> findAll(){		
		return repo.findAll();		
	}
	
	public Ocorrencias findById(String id) {
		Optional<Ocorrencias> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));		
	}
	
	public Ocorrencias insert(Ocorrencias obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}
	
	public Ocorrencias update(Ocorrencias obj) {
		Ocorrencias newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Ocorrencias newObj, Ocorrencias obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setMensagem(obj.getMensagem());
		newObj.setAutor(obj.getAutor());
		newObj.setData(obj.getData());		
	}
	

	public Ocorrencias fromDTO(OcorrenciasDTO objDto) {
		return new Ocorrencias(
				objDto.getId(),
				objDto.getTitulo(),
				objDto.getMensagem(),
				objDto.getAutor(),
				objDto.getData());
		  
	}

}
