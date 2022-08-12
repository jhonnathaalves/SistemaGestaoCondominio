package com.jhonnatha.sgc.domain.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jhonnatha.sgc.domain.Saldo;
import com.jhonnatha.sgc.services.SaldoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/saldos")
public class SaldosResource {
	
	@Autowired
	private SaldoService service;
	
  
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Saldo> findById(@PathVariable String id){
    	Saldo obj = service.findById(id);
    	return ResponseEntity.ok().body(obj);
	}
    
    @RequestMapping(method=RequestMethod.GET)
   	public ResponseEntity<List<Saldo>> findAll(){
   		List<Saldo> list = service.findAll();   		
   		return ResponseEntity.ok().body(list);
   	}
    
    @RequestMapping(value="/atual", method=RequestMethod.GET)
	public ResponseEntity<Saldo> findLastSaldo(){
    	Saldo obj = service.SaldoAtual();
    	return ResponseEntity.ok().body(obj);
	}
   
    
}
