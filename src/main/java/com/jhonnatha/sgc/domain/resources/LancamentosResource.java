package com.jhonnatha.sgc.domain.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jhonnatha.sgc.domain.Lancamentos;
import com.jhonnatha.sgc.dto.LancamentosDTO;
import com.jhonnatha.sgc.services.LancamentosService;
import com.jhonnatha.sgc.services.SaldoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/lancamentos")
public class LancamentosResource {
	
	@Autowired
	private LancamentosService service;
	
	@Autowired
	private SaldoService saldoService;
	
  
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Lancamentos> findById(@PathVariable String id){
    	Lancamentos obj = service.findById(id);
    	return ResponseEntity.ok().body(obj);
	}
    
    @RequestMapping(method=RequestMethod.GET)
   	public ResponseEntity<List<Lancamentos>> findAll(){
   		List<Lancamentos> list = service.findAll();   		
   		return ResponseEntity.ok().body(list);
   	}
    
    @RequestMapping(value="/current",method=RequestMethod.GET)
   	public ResponseEntity<List<Lancamentos>> findAllMonthCurrent(){
   		List<Lancamentos> list = service.findByMonthCurrent();   		
   		return ResponseEntity.ok().body(list);
   	}
    
    @RequestMapping(value="/lastmonth",method=RequestMethod.GET)
   	public ResponseEntity<List<Lancamentos>> findAllLastMonth(){
   		List<Lancamentos> list = service.findByLastMonth();   		
   		return ResponseEntity.ok().body(list);
   	}
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.POST)
   	public ResponseEntity<Void> insert(@RequestBody Lancamentos lancamento){
    	String tipoLancamento = lancamento.getTipoLancamento().getDescricao();    	
		if(tipoLancamento == "Despesa") {
			Double atualizarValor = lancamento.getValor() * -1;
			lancamento.setValor(atualizarValor);			
		}
    	Double valorReceita = lancamento.getValor();
    	saldoService.creditarValor(valorReceita);
    	Lancamentos obj = service.insert(lancamento);       	
       	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
       	return ResponseEntity.created(uri).build();
   	}
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
  	public ResponseEntity<Void> delete(@PathVariable String id){
    	Lancamentos objOld = service.findById(id);
		Double valorLancamentoAntigo = objOld.getValor();
		saldoService.debitarValor(valorLancamentoAntigo);	
      	service.delete(id);
      	return ResponseEntity.noContent().build();
  	}
    
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody LancamentosDTO objDto) {
		Lancamentos objOld = service.findById(id);
		Double valorLancamentoAntigo = objOld.getValor();
		saldoService.debitarValor(valorLancamentoAntigo);		
		Lancamentos obj = service.fromDTO(objDto);	
		obj.setId(id);
		String tipoLancamento = obj.getTipoLancamento().getDescricao();    	
		if(tipoLancamento == "Despesa") {
			Double atualizarValor = obj.getValor() * -1;
			obj.setValor(atualizarValor);
			saldoService.creditarValor(atualizarValor);
		} else {					
			saldoService.creditarValor(obj.getValor());
		}
		obj = service.update(obj);
		return ResponseEntity.noContent().build();

	}    
    
}
