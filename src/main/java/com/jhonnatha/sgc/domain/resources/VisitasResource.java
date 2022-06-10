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

import com.jhonnatha.sgc.domain.Visitas;
import com.jhonnatha.sgc.dto.VisitasDTO;
import com.jhonnatha.sgc.services.VisitasService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/visitas")
public class VisitasResource {
	
	@Autowired
	private VisitasService service;	
	
  
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Visitas> findById(@PathVariable String id){
    	Visitas obj = service.findById(id);
    	return ResponseEntity.ok().body(obj);
	}
    
    @RequestMapping(method=RequestMethod.GET)
   	public ResponseEntity<List<Visitas>> findAll(){
   		List<Visitas> list = service.findAll();   		
   		return ResponseEntity.ok().body(list);
   	}
    
    @RequestMapping(method=RequestMethod.POST)
   	public ResponseEntity<Void> insert(@RequestBody Visitas Visitas){
    	Visitas obj = service.insert(Visitas);       	
       	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
       	return ResponseEntity.created(uri).build();
   	}
    
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
  	public ResponseEntity<Void> delete(@PathVariable String id){
      	service.delete(id);
      	return ResponseEntity.noContent().build();
  	}
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody VisitasDTO objDto) {
		Visitas obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();

	}
}
