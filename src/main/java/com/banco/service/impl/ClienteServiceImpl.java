package com.banco.service.impl;

import java.util.List;

import com.banco.model.ClienteAbstrato;
import com.banco.repository.ClienteDAO;
import com.banco.repository.impl.ClienteDAOImpl;
import com.banco.service.ClienteService;

public class ClienteServiceImpl implements ClienteService {

	private ClienteDAO repository;

	public ClienteServiceImpl() {
		repository = new ClienteDAOImpl();
	}

	@Override
	public void create(ClienteAbstrato obj) {
		repository.create(obj);
		
		if (obj.getId().length() >= 9) {
			repository.create(obj); 
			
		} else {
			System.out.println("NIF Inválido");
			
		}

	}

	@Override
	public List<ClienteAbstrato> readAll() {
		return repository.readAll();
	}

	@Override
	public ClienteAbstrato read(String id) {
		return repository.read(id);
	}

	@Override
	public ClienteAbstrato update(String id) {
		return repository.update(id);
	}

	@Override
	public void delete(String id) {
		repository.delete(id);

	}

}
