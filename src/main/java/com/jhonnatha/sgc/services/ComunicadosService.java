package com.jhonnatha.sgc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonnatha.sgc.domain.Comunicados;
import com.jhonnatha.sgc.dto.ComunicadosDTO;
import com.jhonnatha.sgc.repository.ComunicadosRepository;
import com.jhonnatha.sgc.services.exception.ObjectNotFoundException;

@Service
public class ComunicadosService {

	@Autowired
	private ComunicadosRepository repo;

	public List<Comunicados> findAll() {
		return repo.findAllByOrderByIdDesc();
	}

	public Comunicados findById(String id) {
		Optional<Comunicados> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Comunicados insert(Comunicados obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		repo.deleteById(id);
	}

	public Comunicados update(Comunicados obj) {
		Comunicados newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Comunicados newObj, Comunicados obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setMensagem(obj.getMensagem());
		newObj.setAutor(obj.getAutor());
		newObj.setData(obj.getData());

	}

	public Comunicados fromDTO(ComunicadosDTO objDto) {
		return new Comunicados(objDto.getId(), objDto.getTitulo(), objDto.getMensagem(), objDto.getAutor(),
				objDto.getData());

	}

}
