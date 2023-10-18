package com.banco.controller;

import com.banco.model.FuncionarioAbstrato;
import com.banco.service.FuncionarioService;
import com.banco.service.impl.FuncionarioServiceImpl;

public class FuncionarioController {

	private FuncionarioService service;

	public FuncionarioController() {
		service = new FuncionarioServiceImpl();
	}

	public void create(FuncionarioAbstrato obj) {
		service.create(obj);
	}

	public FuncionarioAbstrato read(String id) {
		return service.read(id);
	}

}