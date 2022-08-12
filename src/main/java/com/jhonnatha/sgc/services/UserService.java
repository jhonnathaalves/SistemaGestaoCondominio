package com.jhonnatha.sgc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jhonnatha.sgc.domain.User;
import com.jhonnatha.sgc.domain.enums.Perfil;
import com.jhonnatha.sgc.dto.UserDTO;
import com.jhonnatha.sgc.repository.UserRepository;
import com.jhonnatha.sgc.security.UserSS;
import com.jhonnatha.sgc.services.exception.AuthorizationException;
import com.jhonnatha.sgc.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}
	
	public List<User> findAllbyPerfil(String perfil) {		
		if (perfil.equalsIgnoreCase("ROLE_COLABORADOR")) {			
			return repo.findAllByPerfisOrderByNomeAsc(perfil);
		} else {			
			return repo.findAllByPerfisNotLikeOrderByNomeAsc("ROLE_COLABORADOR");
		}
		
	}

	public User findById(String id) {

		UserSS user = UserAutenticationService.authenticated();
		if (user == null || !user.hasRole(Perfil.ROLE_ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		Optional<User> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User findByEmail(String email) {
		UserSS user = UserAutenticationService.authenticated();
		if (user == null || !user.hasRole(Perfil.ROLE_ADMIN) && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso negado");
		}

		User obj = repo.findByEmail(email);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + User.class.getName());
		}
		return obj;
	}

	public User insert(User obj) {		
		return repo.insert(obj);
	}	

	public void delete(String id) {
		repo.deleteById(id);
	}

	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(User newObj, User obj) {
		newObj.setNome(obj.getNome());
		newObj.setSobrenome(obj.getSobrenome());
		newObj.setCpf(obj.getCpf());
		newObj.setEmail(obj.getEmail());
		newObj.setTelefone(obj.getTelefone());
		newObj.setSenha(obj.getSenha());

	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getNome(), objDto.getSobrenome(), objDto.getCpf(), objDto.getEmail(),
				objDto.getTelefone(), pe.encode(objDto.getSenha()));

	}

}
