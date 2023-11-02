package com.banco.controller;

import java.util.List;

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
	
	public ClienteAbstrato update(String id, ClienteAbstrato obj) {
		return service.update(id, obj);
	}

	public ClienteAbstrato read(String id) {
		return service.read(id);
	}
	
	public List<ClienteAbstrato> readAll() {
		return service.readAll();
	}
	
	public void delete(String id) {
		service.delete(id);
	}

}
