package com.banco.service;

import static org.junit.Assert.assertEquals;

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


}
