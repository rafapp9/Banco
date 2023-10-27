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
		
		if (obj.getId().length() == 9) {
			
			if(this.read(obj.getId()) != null) {
				System.out.println("NIF já existe");
			}else {
				repository.create(obj);
			}
			
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
	public ClienteAbstrato update(String id, ClienteAbstrato obj) {
		return repository.update(id, obj);
	}

	@Override
	public void delete(String id) {
		repository.delete(id);

	}

}
