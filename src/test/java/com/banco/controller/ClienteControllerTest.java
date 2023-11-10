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
import com.banco.model.ContaAbstrata;
import com.banco.model.ContaDTO;
import com.banco.service.ClienteService;
import com.banco.service.ContaService;
import com.banco.service.impl.ContaServiceImpl;

public class ClienteControllerTest {

	private static ClienteController service = new ClienteController();

	@Test
	public void create() {
		ClienteAbstrato cliente = new ClienteStandard("355643161", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22),
				500);
		service.create(cliente);
		ClienteAbstrato clienteRead = service.read("355643161");
		assertEquals("355643161", clienteRead.getId());
	}

	@Test(expected = IllegalArgumentException.class)
	public void createNifExist() {
		ClienteAbstrato cliente = new ClienteStandard("234582011", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22),
				500);
		ClienteAbstrato cliente2 = new ClienteStandard("234582011", "Antonio Serra", "Homem", LocalDate.of(1995, 1, 1),
				500);
		service.create(cliente);
		service.create(cliente2);
		ClienteAbstrato clienteRead = service.read("234582011");
		assertEquals("234582011", clienteRead.getId());
	}

	@Test(expected = IllegalArgumentException.class)
	public void createNifMenor() {
		ClienteAbstrato cliente = new ClienteStandard("12325628", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22),
				500);
		service.create(cliente);
		assertEquals(null, service.read("12325628"));
	}

	@Test
	public void readAll() {
		ClienteAbstrato cliente = new ClienteStandard("121156711", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22),
				500);
		ClienteAbstrato cliente1 = new ClienteStandard("937644145", "Antonio Serra", "Homem", LocalDate.of(1995, 1, 1),
				500);
		service.create(cliente);
		service.create(cliente1);

		List<ClienteAbstrato> clientes = service.readAll();
		assertNotNull(clientes);
		//8 porque está a procurar em toda a class
		assertEquals(8, clientes.size());

	}

	@Test
	public void update() {
		ClienteAbstrato cliente = new ClienteStandard("123156735", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22),
				500);
		service.create(cliente);
		cliente.setNome("Novo Nome");
		service.update("123156735", cliente);
		ClienteAbstrato clienteRead = service.read("123156735");
		assertEquals("Novo Nome", clienteRead.getNome());
	}

	@Test
	public void delete() {
		ClienteAbstrato cliente = new ClienteStandard("125456716", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22),
				500);
		ClienteAbstrato cliente2 = new ClienteStandard("233564351", "Antonio Serra", "Homem", LocalDate.of(1995, 1, 1),
				500);
		service.create(cliente);
		service.create(cliente2);
		service.delete("233564351");
		ClienteAbstrato clienteEliminado = service.read("233564351");
		assertNull(clienteEliminado);

	}
	
	@Test
	public void testFilterCltByAge() {
		service.create(new ClienteStandard("123454775", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22),
				500));
		service.create(new ClienteStandard("923654143", "Antonio Serra", "Homem", LocalDate.of(1995, 1, 1),
				500));

		int ageFilter = 18;
		List<ClienteAbstrato> clientes = service.filterCltByAge(ageFilter);
		//5 porque está a procurar em toda a class
		assertEquals(5, clientes.size());
	}

	@AfterClass
	public static void cleanup() {
		service = null;
	}

}
