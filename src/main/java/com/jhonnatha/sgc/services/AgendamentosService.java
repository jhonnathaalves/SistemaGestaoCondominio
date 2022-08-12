package com.jhonnatha.sgc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonnatha.sgc.domain.Agendamentos;
import com.jhonnatha.sgc.dto.AgendamentosDTO;
import com.jhonnatha.sgc.repository.AgendamentosRepository;
import com.jhonnatha.sgc.services.exception.ObjectNotFoundException;

@Service
public class AgendamentosService {

	@Autowired
	private AgendamentosRepository repo;

	public List<Agendamentos> findAll() {
		return repo.findAllByOrderByIdDesc();
	}

	public Agendamentos findById(String id) {
		Optional<Agendamentos> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Agendamentos insert(Agendamentos obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		repo.deleteById(id);
	}

	public Agendamentos update(Agendamentos obj) {
		Agendamentos newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Agendamentos newObj, Agendamentos obj) {
		newObj.setTitle(obj.getTitle());
		newObj.setAllDay(obj.getAllDay());
		newObj.setStart(obj.getStart());
		newObj.setEnd(obj.getEnd());
		newObj.setColorEvento(obj.getColorEvento());
		newObj.setColor(obj.getColor());
	}

	public Agendamentos fromDTO(AgendamentosDTO objDto) {
		return new Agendamentos(
				objDto.getId(), 
				objDto.getTitle(), 
				objDto.getAllDay(), 
				objDto.getStart(),
				objDto.getEnd(),
				objDto.getColorEvento(),
				objDto.getColor());

	}

}
