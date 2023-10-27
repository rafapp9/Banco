package com.banco.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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
	
}
