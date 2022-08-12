package com.jhonnatha.sgc.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jhonnatha.sgc.domain.Agendamentos;
import com.jhonnatha.sgc.domain.Blocos;
import com.jhonnatha.sgc.domain.Comunicados;
import com.jhonnatha.sgc.domain.Lancamentos;
import com.jhonnatha.sgc.domain.Ocorrencias;
import com.jhonnatha.sgc.domain.Saldo;
import com.jhonnatha.sgc.domain.Unidades;
import com.jhonnatha.sgc.domain.User;
import com.jhonnatha.sgc.domain.Visitas;
import com.jhonnatha.sgc.domain.enums.Perfil;
import com.jhonnatha.sgc.domain.enums.Status;
import com.jhonnatha.sgc.domain.enums.TipoLancamento;
import com.jhonnatha.sgc.domain.enums.TipoVisita;
import com.jhonnatha.sgc.dto.AuthorDTO;
import com.jhonnatha.sgc.repository.AgendamentosRepository;
import com.jhonnatha.sgc.repository.BlocosRepository;
import com.jhonnatha.sgc.repository.ComunicadosRepository;
import com.jhonnatha.sgc.repository.DespesasRepository;
import com.jhonnatha.sgc.repository.LancamentosRepository;
import com.jhonnatha.sgc.repository.OcorrenciasRepository;
import com.jhonnatha.sgc.repository.ReceitasRepository;
import com.jhonnatha.sgc.repository.SaldoRepository;
import com.jhonnatha.sgc.repository.UnidadesRepository;
import com.jhonnatha.sgc.repository.UserRepository;
import com.jhonnatha.sgc.repository.VisitasRepository;

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
	
	@Autowired
	private SaldoRepository saldoRepository;
	
	@Autowired
	private DespesasRepository despesaRepository;
	
	
	@Autowired
	private ReceitasRepository receitasRepository;
	
	@Autowired
	private LancamentosRepository lancamentosRepository;
	
	@Autowired
	private AgendamentosRepository agendamentoRepository;
	
	@Autowired
	private VisitasRepository visitasRepository;
	

	@Override
	public void run(String... args) throws Exception {		
		
		userRepository.deleteAll();
		ocorrenciasRepository.deleteAll();
		comunicadosRepository.deleteAll();
		unidadeRepository.deleteAll();
		blocoRepository.deleteAll();
		saldoRepository.deleteAll();
		despesaRepository.deleteAll();
		receitasRepository.deleteAll();
		lancamentosRepository.deleteAll();
		agendamentoRepository.deleteAll();
		visitasRepository.deleteAll();
		
		Blocos bloco1 = new Blocos(null, 1);
		Blocos bloco2 = new Blocos(null, 2);
		
		blocoRepository.saveAll(Arrays.asList(bloco1,bloco2));
		
		Unidades uni1101 = new Unidades(null, 101,1);	
		Unidades uni1102 = new Unidades(null, 102,1);
		Unidades uni1103 = new Unidades(null, 103,1);
		Unidades uni1104 = new Unidades(null, 104,1);
		Unidades uni1201 = new Unidades(null, 201,1);
		Unidades uni1202 = new Unidades(null, 202,1);
		Unidades uni1203 = new Unidades(null, 203,1);
		Unidades uni1204 = new Unidades(null, 204,1);
		Unidades uni1301 = new Unidades(null, 301,1);
		Unidades uni1302 = new Unidades(null, 302,1);
		Unidades uni1303 = new Unidades(null, 303,1);
		Unidades uni1304 = new Unidades(null, 304,1);
		Unidades uni1401 = new Unidades(null, 401,1);
		Unidades uni1402 = new Unidades(null, 402,1);
		Unidades uni1403 = new Unidades(null, 403,1);
		Unidades uni1404 = new Unidades(null, 404,1);		
		
		
		unidadeRepository.saveAll(Arrays.asList(uni1101,uni1102,uni1103,uni1104,uni1201,uni1202,uni1203,uni1204,
				uni1301,uni1302,uni1303,uni1304,uni1401,uni1402,uni1403,uni1404));
		
		bloco1.getUnidades().addAll(Arrays.asList(uni1101,uni1102,uni1103,uni1104,uni1201,uni1202,uni1203,uni1204,
				uni1301,uni1302,uni1303,uni1304,uni1401,uni1402,uni1403,uni1404));
		
		
		
		Unidades uni2101 = new Unidades(null, 101,2);
		Unidades uni2102 = new Unidades(null, 102,2);
		Unidades uni2103 = new Unidades(null, 103,2);
		Unidades uni2104 = new Unidades(null, 104,2);
		Unidades uni2201 = new Unidades(null, 201,2);
		Unidades uni2202 = new Unidades(null, 202,2);
		Unidades uni2203 = new Unidades(null, 203,2);
		Unidades uni2204 = new Unidades(null, 204,2);
		Unidades uni2301 = new Unidades(null, 301,2);
		Unidades uni2302 = new Unidades(null, 302,2);
		Unidades uni2303 = new Unidades(null, 303,2);
		Unidades uni2304 = new Unidades(null, 304,2);
		Unidades uni2401 = new Unidades(null, 401,2);
		Unidades uni2402 = new Unidades(null, 402,2);
		Unidades uni2403 = new Unidades(null, 403,2);
		Unidades uni2404 = new Unidades(null, 404,2);		
		
		unidadeRepository.saveAll(Arrays.asList(uni2101,uni2102,uni2103,uni2104,uni2201,uni2202,uni2203,uni2204,
				uni2301,uni2302,uni2303,uni2304,uni2401,uni2402,uni2403,uni2404));
		
		bloco2.getUnidades().addAll(Arrays.asList(uni2101,uni2102,uni2103,uni2104,uni2201,uni2202,uni2203,uni2204,
				uni2301,uni2302,uni2303,uni2304,uni2401,uni2402,uni2403,uni2404));
		
		blocoRepository.saveAll(Arrays.asList(bloco1,bloco2));		
		
		
		User maria = new User(null,"Maria","do Bairro","145.359.360-80","maria@gmail.com","(31) 99865-8336",pe.encode("maria123"));
		User dayana = new User(null,"Dayana","Mota Laporte","663.629.116-87","dayana@gmail.com","(32) 99501-4863",pe.encode("dayana123"),uni2202);
		User denise = new User(null,"Denise","Oliveira Nespoli","141.162.586-28","denise@gmail.com","(35) 99609-6777",pe.encode("denise123"),uni1203);
		User rebeca = new User(null,"Rebeca","Gouveia Quintela","282.644.196-58","rebeca@gmail.com","(38) 99644-8187",pe.encode("rebeca123"),uni1101);
		User nelma = new User(null,"Nelma","Vabo Coutinho","162.134.136-42","nelma@gmail.com","(37) 99628-8336",pe.encode("nelma123"),uni1404);
		User cristiano = new User(null,"Cristiano","Germano Carmanin","662.685.356-26","cristiano@gmail.com","(32) 99865-0747",pe.encode("cristiano123"),uni2404);
		
		
		cristiano.addPerfil(Perfil.ROLE_ADMIN);
		dayana.addPerfil(Perfil.ROLE_USER);		
		denise.addPerfil(Perfil.ROLE_USER);
		rebeca.addPerfil(Perfil.ROLE_USER);
		nelma.addPerfil(Perfil.ROLE_USER);
		maria.addPerfil(Perfil.ROLE_COLABORADOR);		

		
		userRepository.saveAll(Arrays.asList(maria,dayana,denise,rebeca,nelma,cristiano));
		
		//Date dataAtual = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//String dataFormatada = sdf.format(dataAtual);
		
		
		Ocorrencias oc1 = new Ocorrencias(
				null,
				"Vazamento de Gás",
				"Prezados, eu percebi um forte cheiro de gás próximo ao Bloco 02",
				Status.ABERTO,
				new AuthorDTO(cristiano),
				sdf.parse("07/07/2022"),
				"",
				null,
				null);
		
		Ocorrencias oc2 = new Ocorrencias(
				null,
				"Portão Aberto",
				"Prezados, hoje o portão ficou aberto durante a noite!",
				Status.FECHADO,
				new AuthorDTO(dayana),
				sdf.parse("29/05/2022"),
				"Motor do portão estava com defeito, mas o mesmo já foi consertado",
				sdf.parse("31/05/2022"),
				new AuthorDTO(cristiano));	
		
		
		ocorrenciasRepository.saveAll(Arrays.asList(oc1,oc2));
		
		cristiano.getOcorrencias().addAll(Arrays.asList(oc1));
		dayana.getOcorrencias().addAll(Arrays.asList(oc2));
		
		Comunicados com1 = new Comunicados(null,"Convocação de Assembleia", "Prezados moradores, convocamos a todos para a realização de uma Assembleia para discutir sobre a reforma do muro",new AuthorDTO(cristiano), sdf.parse("05/05/2022"));
		Comunicados com2 = new Comunicados(null, "Manutenção Bloco 03", "Prezados moradores do bloco 03, vamos precisar realizar manutenção na rede de gás dos apartamentos 101,201,301 e 401", new AuthorDTO(cristiano), sdf.parse("10/05/2022"));
		Comunicados com3 = new Comunicados(null,"Manutenção Portaria", "Prezados moradores, iremos realizar uma manutenção no motor do portão da portaria. Grato pela compreensão",new AuthorDTO(cristiano), sdf.parse("15/05/2022"));
		
		comunicadosRepository.saveAll(Arrays.asList(com1,com2,com3));		
		cristiano.getComunicados().addAll(Arrays.asList(com1,com2,com3));
		
		userRepository.saveAll(Arrays.asList(cristiano,dayana));
		
		
		
		
		
	
		Saldo SaldoInicial = new Saldo(null,0.0);
		
		
		Lancamentos rec1 = new Lancamentos(null,TipoLancamento.RECEITA,"Taxa de Condominio",9000.00,sdf.parse("10/04/2022"));		
		Lancamentos des1 = new Lancamentos(null,TipoLancamento.DESPESA,"Pagamento Luz",-2000.00,sdf.parse("12/04/2022"));		
		Lancamentos des2 = new Lancamentos(null,TipoLancamento.DESPESA,"Pagamento Agua",-1500.00,sdf.parse("15/04/2022"));		
		Lancamentos des3 = new Lancamentos(null,TipoLancamento.DESPESA,"Pagamento Internet",-150.00,sdf.parse("28/04/2022"));		
		Lancamentos des4 = new Lancamentos(null,TipoLancamento.DESPESA,"Serviço de Portaria/Limpeza",-3000.00,sdf.parse("30/04/2022"));
		
		Saldo SaldoAntPen = new Saldo(null,2350.00,sdf.parse("30/04/2022"));
		
		
		Lancamentos des5 = new Lancamentos(null,TipoLancamento.DESPESA,"Pagamento Gás",-1200.00,sdf.parse("01/05/2022"));		
		Lancamentos rec2 = new Lancamentos(null,TipoLancamento.RECEITA,"Taxa de Condominio",8400.00,sdf.parse("10/05/2022"));		
		Lancamentos des6 = new Lancamentos(null,TipoLancamento.DESPESA,"Pagamento Luz",-1850.00,sdf.parse("12/05/2022"));		
		Lancamentos des7 = new Lancamentos(null,TipoLancamento.DESPESA,"Pagamento Agua",-1790.00,sdf.parse("15/05/2022"));		
		Lancamentos des8 = new Lancamentos(null,TipoLancamento.DESPESA,"Pagamento Internet",-150.00,sdf.parse("28/05/2022"));		
		Lancamentos des9 = new Lancamentos(null,TipoLancamento.DESPESA,"Serviço de Portaria/Limpeza",-3000.00,sdf.parse("31/05/2022"));
		
		Saldo SaldoPen = new Saldo(null,2760.00,sdf.parse("31/05/2022"));
		
		
		Lancamentos des10 = new Lancamentos(null,TipoLancamento.DESPESA,"Pagamento Gás",-1450.00,sdf.parse("01/06/2022"));		
		Lancamentos rec3 = new Lancamentos(null,TipoLancamento.RECEITA,"Taxa de Condominio",8900.00,sdf.parse("10/06/2022"));		
		Lancamentos des11 = new Lancamentos(null,TipoLancamento.DESPESA,"Pagamento Luz",-2500.00,sdf.parse("12/06/2022"));		
		Lancamentos des12 = new Lancamentos(null,TipoLancamento.DESPESA,"Pagamento Agua",-2000.00,sdf.parse("15/06/2022"));		
		Lancamentos des13 = new Lancamentos(null,TipoLancamento.DESPESA,"Pagamento Internet",-150.00,sdf.parse("28/06/2022"));		
		Lancamentos des14 = new Lancamentos(null,TipoLancamento.DESPESA,"Serviço de Portaria/Limpeza",-3000.00,sdf.parse("30/06/2022"));
		
		Saldo SaldoUlt = new Saldo(null,2560.00,sdf.parse("30/06/2022"));
		
		
		lancamentosRepository.saveAll(Arrays.asList(rec1,des1,des2,des3,des4,des5,rec2,des6,des7,des8,
				des9,des10,rec3,des11,des12,des13,des14));
		
		saldoRepository.saveAll(Arrays.asList(SaldoInicial,SaldoAntPen,SaldoPen,SaldoUlt));
		
		SimpleDateFormat sdfAgenda = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		
		Agendamentos agenda1 = new Agendamentos(null, "RESERVA - Area de Lazer - Dayana", false, sdfAgenda.parse("08/07/2022 07:00"), sdfAgenda.parse("08/07/2022 19:00"),"blue","white");
		Agendamentos agenda2 = new Agendamentos(null, "RESERVA - Area de Lazer - Denise", false, sdfAgenda.parse("09/07/2022 12:00"), sdfAgenda.parse("09/07/2022 19:00"),"blue","white");
		Agendamentos agenda3 = new Agendamentos(null, "REUNIÃO  - Condôminio - Cristiano", false, sdfAgenda.parse("16/07/2022 06:00"), sdfAgenda.parse("16/07/2022 07:00"),"green","white");
		
		agendamentoRepository.saveAll(Arrays.asList(agenda1,agenda2,agenda3));
		
		Visitas visita1 = new Visitas(null, "Murilo Cauê Antonio Martins", sdfAgenda.parse("08/07/2022 10:00"),TipoVisita.VISITANTE ,101,1);
		Visitas visita2 = new Visitas(null, "Isabel Bruna Aurora Cavalcanti", sdfAgenda.parse("15/07/2022 12:00"),TipoVisita.PRESTADOR_SERVICO , 301,1);
		Visitas visita3 = new Visitas(null, "André Guilherme Sérgio Lopes", sdfAgenda.parse("15/07/2022 09:00"), TipoVisita.PRESTADOR_SERVICO, 304,1);
		Visitas visita4 = new Visitas(null, "Lucas Leandro Giovanni Fogaça", sdfAgenda.parse("20/07/2022 17:00"),TipoVisita.VISITANTE , 101,1);
		Visitas visita5 = new Visitas(null, "Marcelo Danilo Oliveira", sdfAgenda.parse("25/07/2022 15:00"),TipoVisita.PRESTADOR_SERVICO, 401,2);
		Visitas visita6 = new Visitas(null, "Paulo André Julio Barros", sdfAgenda.parse("29/07/2022 10:00"),TipoVisita.VISITANTE , 101,2);
		Visitas visita7 = new Visitas(null, "Ryan Breno Yuri Fernandes", sdfAgenda.parse("29/07/2022 08:30"),TipoVisita.PRESTADOR_SERVICO, 202,2);
		Visitas visita8 = new Visitas(null, "Isabelly Carla Aurora Almada", sdfAgenda.parse("01/08/2022 12:45"),TipoVisita.VISITANTE, 101,1);
		Visitas visita9 = new Visitas(null, "Silvana Antonella Bernardes", sdfAgenda.parse("01/08/2022 15:10"),TipoVisita.VISITANTE , 201,1);
		Visitas visita10 = new Visitas(null, "Lorenzo Nathan Isaac Galvão", sdfAgenda.parse("01/08/2022 17:25"),TipoVisita.VISITANTE , 401,2);
		
		visitasRepository.saveAll(Arrays.asList(visita1,visita2,visita3,visita4,visita5,visita6,visita7,visita8,visita9,visita10));
	}

}
