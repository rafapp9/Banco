package com.banco.controller;

import java.util.List;

import com.banco.model.ContaAbstrata;
import com.banco.service.ContaService;
import com.banco.service.impl.ContaServiceImpl;

public class ContaController {

	private ContaService service;

	public ContaController() {
		service = new ContaServiceImpl();
	}

	public void create(ContaAbstrata obj) {
		service.create(obj);
	}

	public ContaAbstrata read(String id) {
		return service.read(id);
	}
	
	public List<ContaAbstrata> readAll(){
		return service.readAll();
	}

}
