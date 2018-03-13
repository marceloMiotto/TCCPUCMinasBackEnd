package org.pucminas.estcc.miotto.resourceTest;

import org.junit.Before;
import org.junit.Test;
import org.pucminas.estcc.miotto.model.Cliente;
import org.pucminas.estcc.miotto.resource.AutenticarResource;
import org.pucminas.estcc.miotto.service.ClienteService;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class AutenticarResourceTest {

    AutenticarResource autenticarResource;
    ClienteService clienteService;
    Cliente cliente;


    @Before
    public void initialize() {

        clienteService = new ClienteService();
        autenticarResource = new AutenticarResource();
        cliente = clienteService.getCliente(42);
    }

    @Test
    public void autenticarCliente() {
        System.out.println(cliente.getEmail());
        Cliente result =  autenticarResource.autenticarCliente(cliente);
        assertNotEquals(-1,result.getId());
    }
}