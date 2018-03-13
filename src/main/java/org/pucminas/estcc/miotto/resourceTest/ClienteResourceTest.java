package org.pucminas.estcc.miotto.resourceTest;

import org.junit.Before;
import org.junit.Test;
import org.pucminas.estcc.miotto.model.Cliente;
import org.pucminas.estcc.miotto.resource.ClienteResource;
import org.pucminas.estcc.miotto.service.ClienteService;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class ClienteResourceTest {

    ClienteResource clienteResource;
    Cliente cliente;

    private final String MSG_USUARIO_NAO_AUTORIZADO = "Usuário não autorizado.";
    private final String MSG_ERRO_NOVO_USUARIO = "Erro criando o usuário.";

    @Before
    public void initialize() {

        clienteResource = new ClienteResource();
        cliente = new Cliente("cliente@test.com.br","123456");
    }


    @Test
    public void getCliente() {

        Cliente clienteId = clienteResource.getCliente(241);
        assertEquals(241, clienteId.getId());
    }

    @Test
    public void createCliente() {

        Cliente result = clienteResource.createCliente(cliente);
        assertNotEquals(0,result.getId());
    }


    @Test
    public void updateCliente() {
        Cliente cliente = clienteResource.getCliente(261);
        cliente.setName("Cliente Teste");
        Cliente result = clienteResource.updateCliente(cliente);
        assertNotEquals(0,result.getId());
    }

    @Test
    public void deleteCliente() {
        Cliente cliente = clienteResource.getCliente(241);
        Cliente result = clienteResource.deleteCliente(cliente);
        assertNotEquals(0,result.getId());
    }

}