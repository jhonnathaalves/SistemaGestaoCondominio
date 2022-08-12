package com.jhonnatha.sgc.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonnatha.sgc.domain.Lancamentos;
import com.jhonnatha.sgc.dto.LancamentosDTO;
import com.jhonnatha.sgc.repository.LancamentosRepository;
import com.jhonnatha.sgc.services.exception.ObjectNotFoundException;

@Service
public class LancamentosService {

	@Autowired
	private LancamentosRepository repo;
	
	public List<Lancamentos> findAll() {
		return repo.findAllByOrderByIdDesc();
	}
	
	public List<Lancamentos> findByMonthCurrent(){		
		Calendar c = Calendar.getInstance();
		Instant dataInicial;
		Instant dataFinal;
		c.set(Calendar.HOUR_OF_DAY, 0);
	    c.set(Calendar.MINUTE, 0);
	    c.set(Calendar.SECOND, 0);
	    c.set(Calendar.MILLISECOND, 0);
		//seta primeiro dia do mês
	    c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));	    
		dataInicial = c.getTime().toInstant().truncatedTo( ChronoUnit.DAYS );
		System.out.println("Data do primeiro dia: " + dataInicial);
		//seta ultimo dia do mês
		c.set(Calendar.HOUR_OF_DAY, 23);
	    c.set(Calendar.MINUTE, 59);
	    c.set(Calendar.SECOND, 59);
	    c.set(Calendar.MILLISECOND, 0);
	    c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		dataFinal = c.getTime().toInstant().truncatedTo( ChronoUnit.DAYS );
		System.out.println("Data do utlimo dia: " + dataFinal);
		return repo.findAllByDataBetween(dataInicial, dataFinal);		
	}
	
	public List<Lancamentos> findByLastMonth(){		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
	    c.set(Calendar.MINUTE, 0);
	    c.set(Calendar.SECOND, 0);
	    c.set(Calendar.MILLISECOND, 0);
	    Instant dataInicial;
		Instant dataFinal;		
		//subtrai 1 do mês atual para pegar o anterior
	    c.add(Calendar.MONTH, -1);
		//seta primeiro dia do mês
	    c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));	  
	    dataInicial = c.getTime().toInstant().truncatedTo( ChronoUnit.DAYS );
	    System.out.println("Data do primeiro dia: " + dataInicial);
		//seta ultimo dia do mês
	    c.set(Calendar.HOUR_OF_DAY, 23);
	    c.set(Calendar.MINUTE, 59);
	    c.set(Calendar.SECOND, 59);
	    c.set(Calendar.MILLISECOND, 0);
	    c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
	    dataFinal = c.getTime().toInstant().truncatedTo( ChronoUnit.DAYS );
	    System.out.println("Data do utlimo dia: " + dataFinal);
		return repo.findAllByDataBetween(dataInicial, dataFinal);		
	}

	public Lancamentos findById(String id) {
		Optional<Lancamentos> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Lancamentos insert(Lancamentos obj) {		
		return repo.insert(obj);
	}

	public void delete(String id) {
		repo.deleteById(id);
	}

	public Lancamentos update(Lancamentos obj) {
		Lancamentos newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Lancamentos newObj, Lancamentos obj) {
		newObj.setDescricao(obj.getDescricao());
		newObj.setTipoLancamento(obj.getTipoLancamento());
		newObj.setValor(obj.getValor());		
		newObj.setData(obj.getData());

	}
	
	public Lancamentos fromDTO(LancamentosDTO objDto) {
		return new Lancamentos(objDto.getId(), objDto.getTipoLancamento(), objDto.getDescricao(), objDto.getValor(),objDto.getData());

	}

}
