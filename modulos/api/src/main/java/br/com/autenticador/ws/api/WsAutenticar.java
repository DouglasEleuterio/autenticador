package br.com.autenticador.ws.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.autenticador.dto.AutenticarDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Autenticar")
@Path(WebServicesAutenticar.RAIZ)
public interface WsAutenticar {
    @POST
    @Path(WebServicesAutenticar.LOGAR)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation("Realiza autenticação no AD com Login e Senha")
    Response autenticar (AutenticarDto autenticar) ;
}