package com.banco.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Test;

import com.banco.exceptions.ContaValidateException;
import com.banco.exceptions.NifException;
import com.banco.model.ContaAbstrata;
import com.banco.model.ContaDTO;

public class ContaControllerTest {

	private static ContaController service = new ContaController();

	@Test
	public void readAll() {
		ContaDTO conta = new ContaDTO("123456789", "245678", 500);
		ContaDTO conta1 = new ContaDTO("987654321", "78643", 1500);
		service.create(conta);
		service.create(conta1);
		List<ContaAbstrata> contas = service.readAll();
		assertNotNull(contas);

	}

	@Test
	public void createContaNifOk() {
		ContaDTO conta = new ContaDTO("123456785", "9456778", 500);
		service.create(conta);
		ContaAbstrata contaRead = service.read("123456785");
		assertEquals("123456785", contaRead.getId());
	}

	@Test(expected = NifException.class)
	public void createContaNifBlank() {
		ContaDTO conta = new ContaDTO("", "9456778", 500);
		service.create(conta);
	}
	
	@Test(expected = ContaValidateException.class)
	public void createContaLowAmount() {
		ContaDTO conta = new ContaDTO("837421212", "9456778", 19);
		service.create(conta);
	}

	@Test
	public void update() {
		ContaDTO conta = new ContaDTO("123456789", "245678", 500);
		service.create(conta);
		ContaAbstrata contaAbs = service.read("123456789");
		contaAbs.setNumeroConta("147");
		service.update("123456789", contaAbs);
		ContaAbstrata contaRead = service.read("123456789");
		assertEquals("147", contaRead.getNumeroConta());
	}

	@Test
	public void delete() {
		ContaDTO conta = new ContaDTO("123456789", "245678", 500);
		ContaDTO conta1 = new ContaDTO("986848388", "098647", 1500);
		service.create(conta);
		service.create(conta1);
		service.delete("923456779");
		ContaAbstrata contaEliminada = service.read("923456779");
		assertNull(contaEliminada);
	}

	@AfterClass
	public static void cleanup() {
		service = null;
	}

}
