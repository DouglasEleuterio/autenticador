package br.com.autenticador.ws.impl;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import br.com.autenticador.dto.AutenticarDto;
import br.com.autenticador.servico.ServicoAutenticar;
import br.com.autenticador.ws.api.WsAutenticar;

public class ImplWsAutenticar implements WsAutenticar{
    
	private @Inject ServicoAutenticar servicoAutenticar;

	public Response autenticar(AutenticarDto autenticarDto) {
		return servicoAutenticar.autenticar(autenticarDto);
	}
}