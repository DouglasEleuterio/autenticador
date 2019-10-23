package br.com.autenticador.exception;

import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gruposaga.sdk.cad.jwt.dto.ReponseExceptionDto;
import br.com.gruposaga.sdk.cad.jwt.service.ServiceFilter;

public class AutenticarException {
	
	@Inject
	private ServiceFilter serviceFilter;
	
	public Response informacoesInvalidas() {
		Response response = Response
				.status(Response.Status.BAD_REQUEST)
				.type(MediaType.APPLICATION_JSON)
				.entity(respostaJson(400, "Informações inválidas"))
				.build();
		return response;
	}
	
	public Response docNaoCadastrado() {
		Response response = Response
				.status(Response.Status.BAD_REQUEST)
				.type(MediaType.APPLICATION_JSON)
				.entity(respostaJson(400, "Colaborador sem doc. de identificação cadastrado"))
				.build();
		return response;
	}
	
	public Response docCadastradoIncorreto() {
		Response response = Response
				.status(Response.Status.BAD_REQUEST)
				.type(MediaType.APPLICATION_JSON)
				.entity(respostaJson(400, "Colaborador com doc. de identificação inválido"))
				.build();
		return response;
	}
	
	public Response autenticado(String docColaborador, String nomeColaborador) {
		Response response = Response
				.status(Response.Status.OK)
				.type(MediaType.APPLICATION_JSON)
				.entity(serviceFilter.generateToken(docColaborador, nomeColaborador))
				.build();
		return response;
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	public ReponseExceptionDto respostaJson(int erro, String mensagem) {
		ReponseExceptionDto response = new ReponseExceptionDto();
		response.setStatus(erro);
		response.setDescricao(mensagem);
		return response;
	}
}