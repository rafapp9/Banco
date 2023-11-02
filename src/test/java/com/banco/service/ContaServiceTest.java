package com.banco.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.banco.model.ClienteAbstrato;
import com.banco.model.ClienteStandard;
import com.banco.model.ContaAbstrata;
import com.banco.model.ContaDTO;
import com.banco.service.impl.ClienteServiceImpl;
import com.banco.service.impl.ContaServiceImpl;


public class ContaServiceTest {
	
	@Before
	@Test
	public void readAll() {
		ContaDTO conta = new ContaDTO("123456789", "245678", 500);
		ContaDTO conta1 = new ContaDTO("987654321", "78643", 1500);
		ContaService service = new ContaServiceImpl();
		service.create(conta);
		service.create(conta1);
		List<ContaAbstrata> contas = service.readAll();
		assertNotNull(contas);

	}
	
	@Before
	@Test
	public void createContaNifOk() {
		ContaDTO conta = new ContaDTO("123456785", "9456778", 500);
		ContaService service = new ContaServiceImpl();
		service.create(conta);
		ContaAbstrata contaRead = service.read("123456789");
		assertEquals("123456789", contaRead.getId());
	}

	@Before
	@Test
	public void createContaNifBlank() {
		ContaDTO conta = new ContaDTO("", "9456778", 500);
		ContaService service = new ContaServiceImpl();
		service.create(conta);
		ContaAbstrata contaRead = service.read("");
		assertNull(contaRead);
	}
	
	@Before
	@Test
	public void update() {
		ContaDTO conta = new ContaDTO("123456789", "245678", 500);
	    ContaService service = new ContaServiceImpl();   
	    service.create(conta);
	    service.update("123456789", conta);
	    ContaAbstrata contaRead = service.read("123456789");
	    assertEquals(1000.0, contaRead.getMontanteConta(), 0.01);
	}
	
	@Before
	@Test
	public void delete() {
		ContaDTO conta = new ContaDTO("123456789", "245678", 500);
		ContaDTO conta1 = new ContaDTO("986848388", "098647", 1500);
		ContaService service = new ContaServiceImpl();
		service.create(conta);
		service.create(conta1);
		service.delete("923456779");
		ContaAbstrata contaEliminada = service.read("923456779");
		assertNull(contaEliminada);
	}
	

	
	
}
