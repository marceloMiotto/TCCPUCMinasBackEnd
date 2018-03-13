package org.pucminas.estcc.miotto.serviceTest;

import org.junit.Before;
import org.junit.Test;
import org.pucminas.estcc.miotto.model.Cliente;
import org.pucminas.estcc.miotto.service.AutenticarService;
import org.pucminas.estcc.miotto.service.ClienteService;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class AutenticarServiceTest {



    AutenticarService autenticarService;
    Cliente cliente;


    @Before
    public void initialize() {
        autenticarService = new AutenticarService();
        cliente = new Cliente("cliente@testing.com.br","123456");
    }


    @Test
    public void autenticarCliente() {

        Cliente  result = autenticarService.autenticarCliente(cliente);
        assertNotNull( result);

    }


}