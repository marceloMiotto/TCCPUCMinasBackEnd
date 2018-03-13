package org.pucminas.estcc.miotto.resource;

import org.pucminas.estcc.miotto.model.Cliente;
import org.pucminas.estcc.miotto.service.AutenticarService;
import org.pucminas.estcc.miotto.service.ClienteService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
/*
 ** Classe que recebera as requisicoes CRUD do Cliente
 ** Utiliza a Classe de Servico ClienteService
 */
@Path("cliente")
public class ClienteResource {


    ClienteService clienteService = new ClienteService();


    /*
    ** Metodo getCliente faz a busca dos dados do cliente
    ** Recebe o Id no URL e retorna um objeto JSON Cliente
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente getCliente(@PathParam("id") long id) {

            return clienteService.getCliente(id);

    }

    /*
     ** Metodo createCliente faz o insert dos dados do Cliente
     ** Recebe e produz um objeto JSON Cliente
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Cliente createCliente(Cliente cliente) {
         return  clienteService.createCliente(cliente);         
    }

    /*
     ** Metodo updateCliente faz o update dos dados do Cliente
     ** Recebe e produz um objeto JSON Cliente
     */
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Cliente updateCliente(Cliente cliente){

            return clienteService.updateCliente(cliente);

    }

    /*
     ** Metodo deleteCliente faz o delete dos dados do Cliente
     ** Recebe e produz um objeto JSON Cliente
     */
    @POST
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Cliente deleteCliente(Cliente cliente){
            return clienteService.deleteCliente(cliente);

    }

}
