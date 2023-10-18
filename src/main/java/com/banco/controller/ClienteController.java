package com.banco.controller;

import com.banco.model.ClienteAbstrato;
import com.banco.service.ClienteService;
import com.banco.service.impl.ClienteServiceImpl;

public class ClienteController {

	private ClienteService service;

	public ClienteController() {
		service = new ClienteServiceImpl();
	}

	public void create(ClienteAbstrato obj) {
		service.create(obj);
	}

	public ClienteAbstrato read(String id) {
		return service.read(id);
	}

}
