package com.jhonnatha.sgc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonnatha.sgc.domain.Documentos;
import com.jhonnatha.sgc.dto.DocumentosDTO;
import com.jhonnatha.sgc.repository.DocumentosRepository;
import com.jhonnatha.sgc.services.exception.ObjectNotFoundException;

@Service
public class DocumentosService {

	@Autowired
	private DocumentosRepository repo;

	public List<Documentos> findAll() {
		return repo.findAll();
	}

	public Documentos findById(String id) {
		Optional<Documentos> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Documentos insert(Documentos obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		repo.deleteById(id);
	}

	public Documentos update(Documentos obj) {
		Documentos newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Documentos newObj, Documentos obj) {
		newObj.setNome(obj.getNome());
		newObj.setTipo(obj.getTipo());
		newObj.setData(obj.getData());

	}

	public Documentos fromDTO(DocumentosDTO objDto) {
		return new Documentos(objDto.getId(), objDto.getNome(), objDto.getTipo(), objDto.getData());

	}

}
