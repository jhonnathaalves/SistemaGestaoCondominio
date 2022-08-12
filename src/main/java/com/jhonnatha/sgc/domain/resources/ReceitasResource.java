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

import com.jhonnatha.sgc.domain.Receitas;
import com.jhonnatha.sgc.dto.ReceitasDTO;
import com.jhonnatha.sgc.services.ReceitasService;
import com.jhonnatha.sgc.services.SaldoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/receitas")
public class ReceitasResource {
	
	@Autowired
	private ReceitasService service;
	
	@Autowired
	private SaldoService saldoService;
	
  
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Receitas> findById(@PathVariable String id){
    	Receitas obj = service.findById(id);
    	return ResponseEntity.ok().body(obj);
	}
    
    @RequestMapping(method=RequestMethod.GET)
   	public ResponseEntity<List<Receitas>> findAll(){
   		List<Receitas> list = service.findAll();   		
   		return ResponseEntity.ok().body(list);
   	}
    
    @RequestMapping(value="/current",method=RequestMethod.GET)
   	public ResponseEntity<List<Receitas>> findAllMonthCurrent(){
   		List<Receitas> list = service.findByMonthCurrent();   		
   		return ResponseEntity.ok().body(list);
   	}
    
    @RequestMapping(value="/lastmonth",method=RequestMethod.GET)
   	public ResponseEntity<List<Receitas>> findAllLastMonth(){
   		List<Receitas> list = service.findByLastMonth();   		
   		return ResponseEntity.ok().body(list);
   	}
    
    @RequestMapping(method=RequestMethod.POST)
   	public ResponseEntity<Void> insert(@RequestBody Receitas receitas){
    	Double valorReceita = receitas.getValor();
    	saldoService.creditarValor(valorReceita);
    	Receitas obj = service.insert(receitas);       	
       	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
       	return ResponseEntity.created(uri).build();
   	}
    
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
  	public ResponseEntity<Void> delete(@PathVariable String id){
    	Receitas objOld = service.findById(id);
		Double valorReceitaAntigo = objOld.getValor();
		saldoService.debitarValor(valorReceitaAntigo);	
      	service.delete(id);
      	return ResponseEntity.noContent().build();
  	}
    
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody ReceitasDTO objDto) {
		Receitas objOld = service.findById(id);
		Double valorReceitaAntigo = objOld.getValor();
		saldoService.debitarValor(valorReceitaAntigo);		
		Receitas obj = service.fromDTO(objDto);
		Double valorReceitaNovo = obj.getValor();
    	saldoService.creditarValor(valorReceitaNovo);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();

	}    
    
}
