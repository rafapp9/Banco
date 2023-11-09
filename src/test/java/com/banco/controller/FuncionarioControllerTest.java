package com.banco.controller;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.banco.model.FuncionarioAbstrato;
import com.banco.model.FuncionarioGerente;
import com.banco.service.FuncionarioService;
import com.banco.service.impl.FuncionarioServiceImpl;

public class FuncionarioControllerTest {

	private static FuncionarioController service = new FuncionarioController();

	@Test
	public void create() {
		FuncionarioAbstrato funcionario = new FuncionarioGerente("123456789", "Rafael Cunha", "Homem",
				LocalDate.of(1996, 7, 22), 200);
		service.create(funcionario);
		FuncionarioAbstrato funcionarioRead = service.read("123456789");
		assertEquals("123456789", funcionarioRead.getId());
	}

	@Test(expected = IllegalArgumentException.class)
	public void createNifExist() {
		FuncionarioAbstrato funcionario = new FuncionarioGerente("999999991", "Rafael Cunha", "Homem",
				LocalDate.of(1996, 7, 22), 200);
		FuncionarioAbstrato funcionario1 = new FuncionarioGerente("999999991", "Antonio Serra", "Homem",
				LocalDate.of(1995, 1, 1), 500);
		service.create(funcionario);
		service.create(funcionario1);
		FuncionarioAbstrato funcionarioRead = service.read("999999991");
		assertEquals("999999991", funcionarioRead.getId());
	}

	@Test(expected = IllegalArgumentException.class)
	public void createNifMenor() {
		FuncionarioAbstrato funcionario = new FuncionarioGerente("99999999", "Rafael Cunha", "Homem",
				LocalDate.of(1996, 7, 22), 500);
		service.create(funcionario);
		assertEquals(null, service.read("99999999"));
	}

	@Test
	public void filterFuncsByGoal() {
		service.create(new FuncionarioGerente("999999981", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22), 100));
		service.create(new FuncionarioGerente("999999982", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22), 200));
		service.create(new FuncionarioGerente("999999813", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22), 4000));
		service.create(new FuncionarioGerente("999999814", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22), 20));
		service.create(new FuncionarioGerente("999999815", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22), 1400));

		List<FuncionarioAbstrato> filter = service.filterFuncsByGoal(1000);
		assertEquals(filter.size(), 3);
		assertEquals(filter.get(0).getId(), "999999981");
		assertEquals(filter.get(1).getId(), "999999982");
		assertEquals(filter.get(2).getId(), "999999813");

	}

	@Test
	public void update() {
		FuncionarioAbstrato funcionario = new FuncionarioGerente("999999816", "Rafael Cunha", "Homem",
				LocalDate.of(1996, 7, 22), 500);
		service.create(funcionario);
		funcionario.setNome("Novo Nome");
		service.update("999999816", funcionario);
		FuncionarioAbstrato clienteRead = service.read("999999816");
		assertEquals("Novo Nome", clienteRead.getNome());
	}

	@AfterClass
	public static void cleanup() {
		service = null;
	}

}
