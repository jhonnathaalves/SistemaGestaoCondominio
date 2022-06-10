package com.jhonnatha.sgc.domain.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jhonnatha.sgc.domain.Comunicados;
import com.jhonnatha.sgc.domain.Ocorrencias;
import com.jhonnatha.sgc.domain.Role;
import com.jhonnatha.sgc.domain.User;
import com.jhonnatha.sgc.dto.UserDTO;
import com.jhonnatha.sgc.services.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	
    @RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
    	User obj = service.findById(id);
    	return ResponseEntity.ok().body(new UserDTO(obj));
	}
    
    @RequestMapping(method=RequestMethod.POST)
   	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){
       	User obj = service.fromDTO(objDto);
       	obj = service.insert(obj);
       	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
       	return ResponseEntity.created(uri).build();
   	}
    
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
  	public ResponseEntity<Void> delete(@PathVariable String id){
      	service.delete(id);
      	return ResponseEntity.noContent().build();
  	}
    
    @RequestMapping(value="/{id}",method=RequestMethod.PUT)
   	public ResponseEntity<Void> update(@PathVariable String id,@RequestBody UserDTO objDto){
       	User obj = service.fromDTO(objDto);
       	obj.setId(id);
       	obj = service.update(obj);
       	return ResponseEntity.noContent().build();
       	
   	}
    
    @RequestMapping(value="/{id}/ocorrencias", method=RequestMethod.GET)
	public ResponseEntity<List<Ocorrencias>> findOcorrencias(@PathVariable String id){
    	User obj = service.findById(id);
    	return ResponseEntity.ok().body(obj.getOcorrencias());
	}
    
    //@RequestMapping(value="/{id}/roles", method=RequestMethod.GET)
   	//public ResponseEntity<List<Role>> findRoles(@PathVariable String id){
       	//User obj = service.findById(id);
       	//return ResponseEntity.ok().body(obj.getRoles());
   	//}
    
    @RequestMapping(value="/{id}/comunicados", method=RequestMethod.GET)
	public ResponseEntity<List<Comunicados>> findComunicados(@PathVariable String id){
    	User obj = service.findById(id);
    	return ResponseEntity.ok().body(obj.getComunicados());
	}
}
