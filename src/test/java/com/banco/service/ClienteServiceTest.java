package com.banco.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import com.banco.model.ClienteAbstrato;
import com.banco.model.ClienteStandard;
import com.banco.service.impl.ClienteServiceImpl;

public class ClienteServiceTest {

	@Test
	public void create() {
		ClienteAbstrato cliente = new ClienteStandard("123456789", "Rafael Cunha", 500);
		ClienteService service = new ClienteServiceImpl();
		service.create(cliente);
		ClienteAbstrato clienteRead = service.read("123456789");
		assertEquals("123456789", clienteRead.getId());
	}

	@Test
	public void createNifExist() {
		ClienteAbstrato cliente = new ClienteStandard("123456789", "Rafael Cunha", 500);
		ClienteAbstrato cliente2 = new ClienteStandard("123456789", "Antonio Cunha", 500);
		ClienteService service = new ClienteServiceImpl();
		service.create(cliente);
		service.create(cliente2);
		ClienteAbstrato clienteRead = service.read("123456789");
		assertEquals("123456789", clienteRead.getId());
	}

	@Test
	public void createNifMenor() {
		ClienteAbstrato cliente = new ClienteStandard("12345678", "Rafael Cunha", 500);
		ClienteService service = new ClienteServiceImpl();
		service.create(cliente);
		assertEquals(null, service.read("12345678"));
	}

	@Test
	public void readAll() {
		ClienteAbstrato cliente = new ClienteStandard("123456789", "Rafael Cunha", 500);
		ClienteAbstrato cliente1 = new ClienteStandard("987654321", "Antonio Serra", 500);
		ClienteService service = new ClienteServiceImpl();
		service.create(cliente);
		service.create(cliente1);

		List<ClienteAbstrato> clientes = service.readAll();
		assertNotNull(clientes);
		assertEquals(2, clientes.size());

	}

	@Test
	public void update() {
	    ClienteAbstrato cliente = new ClienteStandard("123456789", "Rafael Cunha", 500);
	    ClienteService service = new ClienteServiceImpl();   
	    service.create(cliente);
	    cliente.setNome("Novo Nome");
	    service.update("123456789", cliente);
	    ClienteAbstrato clienteRead = service.read("123456789");
	    assertEquals("Novo Nome", clienteRead.getNome());
	}


	@Test
	public void delete() {
		ClienteAbstrato cliente = new ClienteStandard("123456789", "Rafael Cunha", 500);
		ClienteAbstrato cliente2 = new ClienteStandard("923456779", "Antonio Serra", 500);
		ClienteService service = new ClienteServiceImpl();
		service.create(cliente);
		service.create(cliente2);
		service.delete("923456779");
		ClienteAbstrato clienteEliminado = service.read("923456779");
		assertNull(clienteEliminado);

	}

}
