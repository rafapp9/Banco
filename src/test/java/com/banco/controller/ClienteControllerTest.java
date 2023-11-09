package com.banco.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.banco.model.ClienteAbstrato;
import com.banco.model.ClienteStandard;
import com.banco.service.ClienteService;

public class ClienteControllerTest {

	private static ClienteController service = new ClienteController();

	@Test
	public void create() {
		ClienteAbstrato cliente = new ClienteStandard("123456789", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22),
				500);
		service.create(cliente);
		ClienteAbstrato clienteRead = service.read("123456789");
		assertEquals("123456789", clienteRead.getId());
	}

	@Test(expected = IllegalArgumentException.class)
	public void createNifExist() {
		ClienteAbstrato cliente = new ClienteStandard("123456789", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22),
				500);
		ClienteAbstrato cliente2 = new ClienteStandard("123456789", "Antonio Serra", "Homem", LocalDate.of(1995, 1, 1),
				500);
		service.create(cliente);
		service.create(cliente2);
		ClienteAbstrato clienteRead = service.read("123456789");
		assertEquals("123456789", clienteRead.getId());
	}

	@Test(expected = IllegalArgumentException.class)
	public void createNifMenor() {
		ClienteAbstrato cliente = new ClienteStandard("12345678", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22),
				500);
		service.create(cliente);
		assertEquals(null, service.read("12345678"));
	}

	@Test
	public void readAll() {
		ClienteAbstrato cliente = new ClienteStandard("123456712", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22),
				500);
		ClienteAbstrato cliente1 = new ClienteStandard("987654121", "Antonio Serra", "Homem", LocalDate.of(1995, 1, 1),
				500);
		service.create(cliente);
		service.create(cliente1);

		List<ClienteAbstrato> clientes = service.readAll();
		assertNotNull(clientes);
		assertEquals(5, clientes.size());

	}

	@Test
	public void update() {
		ClienteAbstrato cliente = new ClienteStandard("123456713", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22),
				500);
		service.create(cliente);
		cliente.setNome("Novo Nome");
		service.update("123456713", cliente);
		ClienteAbstrato clienteRead = service.read("123456713");
		assertEquals("Novo Nome", clienteRead.getNome());
	}

	@Test
	public void delete() {
		ClienteAbstrato cliente = new ClienteStandard("123456743", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22),
				500);
		ClienteAbstrato cliente2 = new ClienteStandard("234564321", "Antonio Serra", "Homem", LocalDate.of(1995, 1, 1),
				500);
		service.create(cliente);
		service.create(cliente2);
		service.delete("234564321");
		ClienteAbstrato clienteEliminado = service.read("234564321");
		assertNull(clienteEliminado);

	}

	@AfterClass
	public static void cleanup() {
		service = null;
	}

}
