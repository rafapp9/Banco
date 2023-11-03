package com.banco.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.banco.model.FuncionarioAbstrato;
import com.banco.model.FuncionarioGerente;
import com.banco.service.FuncionarioService;
import com.banco.service.impl.FuncionarioServiceImpl;

public class FuncionarioControllerTest {

	@Before
	@Test
	public void create() {
		FuncionarioAbstrato funcionario = new FuncionarioGerente("123456789", "Rafael Cunha", 200);
		FuncionarioController service = new FuncionarioController();
		service.create(funcionario);
		FuncionarioAbstrato funcionarioRead = service.read("123456789");
		assertEquals("123456789", funcionarioRead.getId());
	}

	@Before
	@Test
	public void createNifExist() {
		FuncionarioAbstrato funcionario = new FuncionarioGerente("123456789", "Rafael Cunha", 500);
		FuncionarioAbstrato funcionario1 = new FuncionarioGerente("123456789", "Antonio Cunha", 500);
		FuncionarioController service = new FuncionarioController();
		service.create(funcionario);
		service.create(funcionario1);
		FuncionarioAbstrato funcionarioRead = service.read("123456789");
		assertEquals("123456789", funcionarioRead.getId());
	}

	@Before
	@Test
	public void createNifMenor() {
		FuncionarioAbstrato funcionario = new FuncionarioGerente("12345678", "Rafael Cunha", 500);
		FuncionarioController service = new FuncionarioController();
		service.create(funcionario);
		assertEquals(null, service.read("12345678"));
	}

	@Before
	@Test
	public void filterFuncsByGoal() {
		FuncionarioController service = new FuncionarioController();
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

	@Before
	@Test
	public void update() {
		FuncionarioAbstrato funcionario = new FuncionarioGerente("987654323", "Rafael Cunha", 1000);
		FuncionarioController service = new FuncionarioController();
		service.create(funcionario);
		funcionario.setNome("Novo Nome");
		service.update("987654323", funcionario);
		FuncionarioAbstrato clienteRead = service.read("987654323");
		assertEquals("Novo Nome", clienteRead.getNome());
	}

}
