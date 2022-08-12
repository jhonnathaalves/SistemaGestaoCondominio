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

import com.jhonnatha.sgc.domain.Despesas;
import com.jhonnatha.sgc.dto.DespesasDTO;
import com.jhonnatha.sgc.services.DespesasService;
import com.jhonnatha.sgc.services.SaldoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/despesas")
public class DespesasResource {
	
	@Autowired
	private DespesasService service;
	
	@Autowired
	private SaldoService saldoService;
	
  
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Despesas> findById(@PathVariable String id){
    	Despesas obj = service.findById(id);
    	return ResponseEntity.ok().body(obj);
	}
    
    @RequestMapping(method=RequestMethod.GET)
   	public ResponseEntity<List<Despesas>> findAll(){
   		List<Despesas> list = service.findAll();   		
   		return ResponseEntity.ok().body(list);
   	}
    
    @RequestMapping(method=RequestMethod.POST)
   	public ResponseEntity<Void> insert(@RequestBody Despesas despesas){
    	Double valorDespesa = despesas.getValor();
    	saldoService.debitarValor(valorDespesa);
    	Despesas obj = service.insert(despesas);       	
       	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
       	return ResponseEntity.created(uri).build();
   	}
    
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
  	public ResponseEntity<Void> delete(@PathVariable String id){
    	Despesas objOld = service.findById(id);
		Double valorDespesaAntigo = objOld.getValor();
		saldoService.creditarValor(valorDespesaAntigo);	
      	service.delete(id);
      	return ResponseEntity.noContent().build();
  	}
    
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody DespesasDTO objDto) {
		Despesas objOld = service.findById(id);
		Double valorDespesaAntigo = objOld.getValor();
		saldoService.creditarValor(valorDespesaAntigo);		
		Despesas obj = service.fromDTO(objDto);
		Double valorDespesaNovo = obj.getValor();
    	saldoService.debitarValor(valorDespesaNovo);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();

	}    
    
}
