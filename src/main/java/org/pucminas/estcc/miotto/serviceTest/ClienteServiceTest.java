package org.pucminas.estcc.miotto.serviceTest;

import org.junit.Before;
import org.junit.Test;
import org.pucminas.estcc.miotto.model.Cliente;
import org.pucminas.estcc.miotto.service.ClienteService;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class ClienteServiceTest {

    ClienteService clienteService;
    Cliente cliente;


    @Before
    public void initialize() {
        clienteService = new ClienteService();
        cliente = new Cliente("cliente@testing.com.br","123456");
    }

    @Test
    public void getCliente() {

        Cliente clienteId = clienteService.getCliente(181);
        assertEquals(181, clienteId.getId());
    }

    @Test
    public void createCliente() {


        Cliente result = clienteService.createCliente(cliente);
        assertNotEquals(0,result.getId());

    }

    @Test
    public void updateCliente() {

        Cliente cliente = clienteService.getCliente(181);
        cliente.setName("Cliente Teste");
        Cliente result = clienteService.updateCliente(cliente);
        assertNotEquals(0,result.getId());
    }

    @Test
    public void deleteCliente() {
        Cliente cliente = clienteService.getCliente(181);
        Cliente result = clienteService.deleteCliente(cliente);
        assertNotEquals(0,result.getId());
    }



}