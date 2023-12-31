package com.banco.controller;

import java.util.List;

import org.junit.BeforeClass;

import com.banco.config.FuncionarioConfig;
import com.banco.model.FuncionarioAbstrato;
import com.banco.service.FuncionarioService;
import com.banco.service.impl.FuncionarioServiceImpl;

public class FuncionarioController {
	
	@BeforeClass
	public static void setup() {
		// Initiate the FuncionarioConfig code before running any tests
		FuncionarioConfig.start();
	}

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
	
	public FuncionarioAbstrato update(String id, FuncionarioAbstrato obj) {
		return service.update(id, obj);
	}
	
	public List<FuncionarioAbstrato> readlAll() {
		return service.readAll();
		
	}
	
	public void delete(String id) {
		service.delete(id);
	}

	public List<FuncionarioAbstrato> filterFuncsByGoal(double amount) {
		return filterFuncsByGoal(amount);
	}

}
