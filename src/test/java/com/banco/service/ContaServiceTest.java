package com.banco.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import com.banco.model.ContaAbstrata;
import com.banco.model.ContaDTO;
import com.banco.service.impl.ContaServiceImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContaServiceTest {
	
	@Test
	@Order(1)
	public void readAll() {
		ContaDTO conta = new ContaDTO("123456789", "245678", 500);
		ContaDTO conta1 = new ContaDTO("987654321", "78643", 1500);
		ContaService service = new ContaServiceImpl();
		service.create(conta);
		service.create(conta1);
		List<ContaAbstrata> contas = service.readAll();
		assertNotNull(contas);

	}
	
	@Test
	@Order(2)
	public void createContaNifOk() {
		ContaDTO conta = new ContaDTO("123456785", "9456778", 500);
		ContaService service = new ContaServiceImpl();
		service.create(conta);
		ContaAbstrata contaRead = service.read("123456789");
		assertEquals("123456789", contaRead.getId());
	}

	@Test
	@Order(3)
	public void createContaNifBlank() {
		ContaDTO conta = new ContaDTO("", "9456778", 500);
		ContaService service = new ContaServiceImpl();
		service.create(conta);
		ContaAbstrata contaRead = service.read("");
		assertNull(contaRead);
	}
	
/*	@Test //olhar para factoryConta
	public void update() {
		ContaDTO conta = new ContaDTO("123456789", "245678", 500);
	    ContaService service = new ContaServiceImpl();   
	    service.create(conta);
	    service.update("123456789", new contaDTO);
	    ContaDTO clienteRead = service.read("123456789");
	    assertEquals(1000.0, clienteRead.montanteInicial(), 0.01);
	}
	
*/
	
	
}
