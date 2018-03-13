package org.pucminas.estcc.miotto.resource;

import org.pucminas.estcc.miotto.model.Cliente;
import org.pucminas.estcc.miotto.service.AutenticarService;
import org.pucminas.estcc.miotto.service.ClienteService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
/*
 ** Classe que recebera as requisicoes de autenticacao do Cliente
 ** Utiliza a Classe de Servico AutenticarService
 */
@Path("cliente/autenticar")
public class AutenticarResource {


    AutenticarService autenticarService = new AutenticarService();

    @POST    
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Cliente autenticarCliente(Cliente cliente) {
        return autenticarService.autenticarCliente(cliente);

    }

}
