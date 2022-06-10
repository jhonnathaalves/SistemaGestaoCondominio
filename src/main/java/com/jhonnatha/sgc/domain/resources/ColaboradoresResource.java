package com.jhonnatha.sgc.domain.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jhonnatha.sgc.domain.Colaboradores;
import com.jhonnatha.sgc.domain.Ocorrencias;
import com.jhonnatha.sgc.dto.ColaboradoresDTO;
import com.jhonnatha.sgc.services.ColaboradoresServices;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/colaboradores")
public class ColaboradoresResource {

	@Autowired
	private ColaboradoresServices service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Colaboradores> findById(@PathVariable String id) {
		Colaboradores obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Colaboradores>> findAll() {
		List<Colaboradores> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ColaboradoresDTO objDto) {
		Colaboradores obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody ColaboradoresDTO objDto) {
		Colaboradores obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();

	}

	@RequestMapping(value = "/{id}/ocorrencias", method = RequestMethod.GET)
	public ResponseEntity<List<Ocorrencias>> findOcorrencias(@PathVariable String id) {
		Colaboradores obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getOcorrencias());
	}

}
