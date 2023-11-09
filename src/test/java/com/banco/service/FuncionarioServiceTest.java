package com.banco.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Test;

import com.banco.model.FuncionarioAbstrato;
import com.banco.model.FuncionarioGerente;
import com.banco.service.impl.FuncionarioServiceImpl;

public class FuncionarioServiceTest {
	
	private static FuncionarioService service = new FuncionarioServiceImpl();
	
	@Test
	public void readAll() {
		FuncionarioAbstrato funcionario = new FuncionarioGerente("874637387", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22), 200);
		FuncionarioAbstrato funcionario1 = new FuncionarioGerente("253647836", "Ângela Cunha", "Mulher", LocalDate.of(1995, 1, 30), 200);
		service.create(funcionario);
		service.create(funcionario1);
		List<FuncionarioAbstrato> funcionarios = service.readAll();
		assertNotNull(funcionarios);

	}

	@Test
	public void create() {
		FuncionarioAbstrato funcionario = new FuncionarioGerente("123456789", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22), 200);
		service.create(funcionario);
		FuncionarioAbstrato funcionarioRead = service.read("123456789");
		assertEquals("123456789", funcionarioRead.getId());
	}

	@Test(expected = IllegalArgumentException.class)
	public void createNifExist() {
		FuncionarioAbstrato funcionario = new FuncionarioGerente("123456789", "Rafael Cunha", "Homem",
				LocalDate.of(1996, 7, 22), 200);
		FuncionarioAbstrato funcionario1 = new FuncionarioGerente("123456789", "Antonio Serra", "Homem",
				LocalDate.of(1995, 1, 1), 500);
		service.create(funcionario);
		service.create(funcionario1);
		FuncionarioAbstrato funcionarioRead = service.read("123456789");
		assertEquals("123456789", funcionarioRead.getId());
	}

	@Test(expected = IllegalArgumentException.class)
	public void createNifMenor() {
		FuncionarioAbstrato funcionario = new FuncionarioGerente("12345678", "Rafael Cunha", "Homem",
				LocalDate.of(1996, 7, 22), 500);
		service.create(funcionario);
		assertEquals(null, service.read("12345678"));
	}

	@Test
	public void filterFuncsByGoal() {
		service.create(new FuncionarioGerente("123456781", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22), 1230));
		service.create(new FuncionarioGerente("123456782", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22), 2345));
		service.create(new FuncionarioGerente("123456783", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22), 4000));
		service.create(new FuncionarioGerente("123456784", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22), 20));
		service.create(new FuncionarioGerente("123456785", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22), 100));

		List<FuncionarioAbstrato> filter = service.filterFuncsByGoal(1000);
		assertEquals(filter.size(), 3);
		assertEquals(filter.get(0).getId(), "123456781");
		assertEquals(filter.get(1).getId(), "123456782");
		assertEquals(filter.get(2).getId(), "123456783");

	}

	@Test
	public void update() {
		FuncionarioAbstrato funcionario = new FuncionarioGerente("987654399", "Rafael Cunha", "Homem",
				LocalDate.of(1996, 7, 22), 500);
		service.create(funcionario);
		funcionario.setNome("Novo Nome");
		service.update("987654399", funcionario);
		FuncionarioAbstrato clienteRead = service.read("987654399");
		assertEquals("Novo Nome", clienteRead.getNome());
	}
	
	
	 @AfterClass
	    public static void cleanup() {
	        service = null;
	    }

}
