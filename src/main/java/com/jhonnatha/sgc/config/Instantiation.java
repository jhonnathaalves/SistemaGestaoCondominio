package com.jhonnatha.sgc.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jhonnatha.sgc.domain.Blocos;
import com.jhonnatha.sgc.domain.Comunicados;
import com.jhonnatha.sgc.domain.Ocorrencias;
import com.jhonnatha.sgc.domain.Unidades;
import com.jhonnatha.sgc.domain.User;
import com.jhonnatha.sgc.domain.enums.Perfil;
import com.jhonnatha.sgc.dto.AuthorDTO;
import com.jhonnatha.sgc.dto.ResponseDTO;
import com.jhonnatha.sgc.repository.BlocosRepository;
import com.jhonnatha.sgc.repository.ComunicadosRepository;
import com.jhonnatha.sgc.repository.OcorrenciasRepository;
import com.jhonnatha.sgc.repository.UnidadesRepository;
import com.jhonnatha.sgc.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OcorrenciasRepository ocorrenciasRepository;
	
	@Autowired
	private ComunicadosRepository comunicadosRepository;
	
	@Autowired
	private UnidadesRepository unidadeRepository;
	
	@Autowired
	private BlocosRepository blocoRepository;
	

	@Override
	public void run(String... args) throws Exception {		
		
		userRepository.deleteAll();
		ocorrenciasRepository.deleteAll();
		comunicadosRepository.deleteAll();
		unidadeRepository.deleteAll();
		blocoRepository.deleteAll();	

		User maria = new User(null,"Maria","do Bairro","145.359.360-80","mariadobairro@gmail.com","(31) 99865-8336",pe.encode("maria123"));
		User dayana = new User(null,"Dayana","Mota Laporte","663.629.116-87","dayanalaporte@gmail.com","(32) 99501-4863",pe.encode("dayana123"));
		User denise = new User(null,"Denise","Oliveira Nespoli","141.162.586-28","denisenespoli@gmail.com","(35) 99609-6777",pe.encode("denise123"));
		User rebeca = new User(null,"Rebeca","Gouveia Quintela","282.644.196-58","rebecaquintela@gmail.com","(38) 99644-8187",pe.encode("rebeca123"));
		User nelma = new User(null,"Nelma","Vabo Coutinho","162.134.136-42","nelmacoutinho@gmail.com","(37) 99628-8336",pe.encode("nelma123"));
		User cristiano = new User(null,"Cristiano","Germano Carmanin","662.685.356-26","cristianocarmanin@gmail.com","(32) 99865-0747",pe.encode("cristiano123"));
		
		
		cristiano.addPerfil(Perfil.ROLE_ADMIN);
		dayana.addPerfil(Perfil.ROLE_USER);		
		denise.addPerfil(Perfil.ROLE_USER);
		rebeca.addPerfil(Perfil.ROLE_USER);
		nelma.addPerfil(Perfil.ROLE_USER);
		maria.addPerfil(Perfil.ROLE_COLABORADOR);

		
		userRepository.saveAll(Arrays.asList(maria,dayana,denise,rebeca,nelma,cristiano));
		
		Date dataAtual = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = sdf.format(dataAtual);
		
		
		Ocorrencias oc1 = new Ocorrencias(
				null,
				"Vazamento de Gás",
				"Prezados, eu percebi um forte cheiro de gás próximo ao Bloco 02",
				new AuthorDTO(cristiano),
				sdf.parse(dataFormatada));
		
		Ocorrencias oc2 = new Ocorrencias(
				null,
				"Portão Aberto",
				"Prezados, hoje o portão ficou aberto durante a noite!",
				new AuthorDTO(dayana),
				sdf.parse(dataFormatada));
		
		ResponseDTO rp1 = new ResponseDTO("Motor do portão estava com defeito, mas o mesmo já foi consertado",sdf.parse("31/05/2022"),new AuthorDTO(cristiano));
		oc2.getResposta().addAll(Arrays.asList(rp1));
		
		ocorrenciasRepository.saveAll(Arrays.asList(oc1,oc2));
		
		cristiano.getOcorrencias().addAll(Arrays.asList(oc1));
		dayana.getOcorrencias().addAll(Arrays.asList(oc2));
		
		Comunicados com1 = new Comunicados(null,"Convocação de Assembleia", "Prezados moradores, convocamos a todos para a realização de uma Assembleia para discutir sobre a reforma do muro",new AuthorDTO(cristiano), sdf.parse("05/05/2022"));
		Comunicados com2 = new Comunicados(null, "Manutenção Bloco 03", "Prezados moradores do bloco 03, vamos precisar realizar manutenção na rede de gás dos apartamentos 101,201,301 e 401", new AuthorDTO(cristiano), sdf.parse("10/05/2022"));
		Comunicados com3 = new Comunicados(null,"Manutenção Portaria", "Prezados moradores, iremos realizar uma manutenção no motor do portão da portaria. Grato pela compreensão",new AuthorDTO(cristiano), sdf.parse("15/05/2022"));
		
		comunicadosRepository.saveAll(Arrays.asList(com1,com2,com3));		
		cristiano.getComunicados().addAll(Arrays.asList(com1,com2,com3));
		
		userRepository.saveAll(Arrays.asList(cristiano,dayana));
		
		Blocos bloco1 = new Blocos(null, 1);
		Blocos bloco2 = new Blocos(null, 2);
		
		blocoRepository.saveAll(Arrays.asList(bloco1,bloco2));
		
		Unidades uni1101 = new Unidades(null, 101);	
		Unidades uni1102 = new Unidades(null, 102);
		Unidades uni1103 = new Unidades(null, 103);
		Unidades uni1104 = new Unidades(null, 104);
		Unidades uni1201 = new Unidades(null, 201);
		Unidades uni1202 = new Unidades(null, 202);
		Unidades uni1203 = new Unidades(null, 203);
		Unidades uni1204 = new Unidades(null, 204);
		Unidades uni1301 = new Unidades(null, 301);
		Unidades uni1302 = new Unidades(null, 302);
		Unidades uni1303 = new Unidades(null, 303);
		Unidades uni1304 = new Unidades(null, 304);
		Unidades uni1401 = new Unidades(null, 401);
		Unidades uni1402 = new Unidades(null, 402);
		Unidades uni1403 = new Unidades(null, 403);
		Unidades uni1404 = new Unidades(null, 404);
		
		unidadeRepository.saveAll(Arrays.asList(uni1101,uni1102,uni1103,uni1104,uni1201,uni1202,uni1203,uni1204,
				uni1301,uni1302,uni1303,uni1304,uni1401,uni1402,uni1403,uni1404));
		
		bloco1.getUnidades().addAll(Arrays.asList(uni1101,uni1102,uni1103,uni1104,uni1201,uni1202,uni1203,uni1204,
				uni1301,uni1302,uni1303,uni1304,uni1401,uni1402,uni1403,uni1404));
		
		
		
		Unidades uni2101 = new Unidades(null, 101);
		Unidades uni2102 = new Unidades(null, 102);
		Unidades uni2103 = new Unidades(null, 103);
		Unidades uni2104 = new Unidades(null, 104);
		Unidades uni2201 = new Unidades(null, 201);
		Unidades uni2202 = new Unidades(null, 202);
		Unidades uni2203 = new Unidades(null, 203);
		Unidades uni2204 = new Unidades(null, 204);
		Unidades uni2301 = new Unidades(null, 301);
		Unidades uni2302 = new Unidades(null, 302);
		Unidades uni2303 = new Unidades(null, 303);
		Unidades uni2304 = new Unidades(null, 304);
		Unidades uni2401 = new Unidades(null, 401);
		Unidades uni2402 = new Unidades(null, 402);
		Unidades uni2403 = new Unidades(null, 403);
		Unidades uni2404 = new Unidades(null, 404);
		
		unidadeRepository.saveAll(Arrays.asList(uni2101,uni2102,uni2103,uni2104,uni2201,uni2202,uni2203,uni2204,
				uni2301,uni2302,uni2303,uni2304,uni2401,uni2402,uni2403,uni2404));
		
		bloco2.getUnidades().addAll(Arrays.asList(uni2101,uni2102,uni2103,uni2104,uni2201,uni2202,uni2203,uni2204,
				uni2301,uni2302,uni2303,uni2304,uni2401,uni2402,uni2403,uni2404));
		
		blocoRepository.saveAll(Arrays.asList(bloco1,bloco2));
		
	}

}
