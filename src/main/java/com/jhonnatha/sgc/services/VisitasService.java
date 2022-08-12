package com.jhonnatha.sgc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonnatha.sgc.domain.Visitas;
import com.jhonnatha.sgc.dto.VisitasDTO;
import com.jhonnatha.sgc.repository.VisitasRepository;
import com.jhonnatha.sgc.services.exception.ObjectNotFoundException;

@Service
public class VisitasService {

	@Autowired
	private VisitasRepository repo;

	public List<Visitas> findAll() {
		return repo.findByOrderByIdDesc();
	}

	public Visitas findById(String id) {
		Optional<Visitas> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Visitas insert(Visitas obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		repo.deleteById(id);
	}

	public Visitas update(Visitas obj) {
		Visitas newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Visitas newObj, Visitas obj) {
		newObj.setNome(obj.getNome());
		newObj.setHoraEntrada(obj.getHoraEntrada());
		newObj.setUnidade(obj.getUnidade());
		newObj.setBloco(obj.getBloco());
	}

	public Visitas fromDTO(VisitasDTO objDto) {
		return new Visitas(objDto.getId(), objDto.getNome(), objDto.getHoraEntrada(), objDto.getTipoVisita(), objDto.getUnidade(),objDto.getBloco());

	}

}
