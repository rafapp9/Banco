package com.banco.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.banco.model.FuncionarioAbstrato;
import com.banco.model.FuncionarioGerente;
import com.banco.service.impl.FuncionarioServiceImpl;

public class FuncionarioServiceTest {

	@Test
	public void create() {
		FuncionarioAbstrato funcionario = new FuncionarioGerente("123456789", "Rafael Cunha", 200);
		FuncionarioService service = new FuncionarioServiceImpl();
		service.create(funcionario);
		FuncionarioAbstrato funcionarioRead = service.read("123456789");
		assertEquals("123456789", funcionarioRead.getId());
	}
	
	@Test
	public void createNifExist() {
		FuncionarioAbstrato cliente = new FuncionarioGerente("123456789", "Rafael Cunha", 500);
		FuncionarioAbstrato cliente2 = new FuncionarioGerente("123456789", "Antonio Cunha", 500);
		FuncionarioService service = new FuncionarioServiceImpl();
		service.create(cliente);
		service.create(cliente2);
		FuncionarioAbstrato clienteRead = service.read("123456789");
		assertEquals("123456789", clienteRead.getId());
	}

	@Test
	public void createNifMenor() {
		FuncionarioAbstrato cliente = new FuncionarioGerente("12345678", "Rafael Cunha", 500);
		FuncionarioService service = new FuncionarioServiceImpl();
		service.create(cliente);
		assertEquals(null, service.read("12345678"));
	}
	
	@Test
	public void filterFuncsByGoal() {
		FuncionarioService service = new FuncionarioServiceImpl();
		service.create(new FuncionarioGerente("987654321", "Rafael Cunha", 100));
		service.create(new FuncionarioGerente("987654322", "Rafael Cunha", 100));
		service.create(new FuncionarioGerente("987654323", "Rafael Cunha", 1000));
		service.create(new FuncionarioGerente("987654324", "Rafael Cunha", 1000));
		service.create(new FuncionarioGerente("987654325", "Rafael Cunha", 1000));
		
		List<FuncionarioAbstrato> filter = service.filterFuncsByGoal(1000);
		assertEquals(filter.size(), 3);
		assertEquals(filter.get(0).getId(), "987654323");
		assertEquals(filter.get(1).getId(), "987654324");
		assertEquals(filter.get(2).getId(), "987654325");
		
	}


}
