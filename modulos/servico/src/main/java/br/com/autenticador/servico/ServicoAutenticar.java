package br.com.autenticador.servico;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import br.com.autenticador.exception.AutenticarException;
import br.com.autenticador.uteis.AutenticarUteis;
import org.slf4j.Logger;

import br.com.autenticador.dto.AutenticarDto;
import br.com.gruposaga.cad.ldap.dto.DadosUsuarioADDto;
import br.com.gruposaga.cad.ldap.exception.ErroIntegracaoComAD;
import br.com.gruposaga.cad.ldap.servico.ServicoLdap;

public class ServicoAutenticar {
	
	@Inject
	private ServicoLdap servicoLdap;
	
	@Inject
	private AutenticarException autenticarException;
	
	@Inject
	private Logger logger;
	
	public Response autenticar(AutenticarDto autenticarDto) {
		
		DadosUsuarioADDto dadosUsuarioADDto = new DadosUsuarioADDto();
		
		try {
			dadosUsuarioADDto = servicoLdap.autenticarAd(autenticarDto.getLogin(), autenticarDto.getSenha());
			
			if (dadosUsuarioADDto.getLogin() == null) {
				return autenticarException.informacoesInvalidas();
			}
			
			if (dadosUsuarioADDto.getCpf() == null) {
				return autenticarException.docNaoCadastrado();
			}else {
				return validarDocColaborador(dadosUsuarioADDto);
			}
		} catch (ErroIntegracaoComAD e) {
			logger.error("ServicoAutenticar - autenticar"+e);
			return autenticarException.informacoesInvalidas();
		}
	}
	
	public Response validarDocColaborador(DadosUsuarioADDto dadosUsuarioADDto) {
		if (AutenticarUteis.isValidCpf(dadosUsuarioADDto.getCpf())) {
			return autenticarException.autenticado(dadosUsuarioADDto.getCpf(), dadosUsuarioADDto.getNome());
		}else {
			return autenticarException.docCadastradoIncorreto();
		}
	}
}