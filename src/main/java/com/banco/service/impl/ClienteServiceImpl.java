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
		
		if(obj.getMontanteDepositado() < 20) {
			System.out.println("Cliente com valor depositado invalido!");
		}else {
			repository.create(obj);
		}
		
	}

	@Override
	public List<ClienteAbstrato> readAll() {
		return null;
	}

	@Override
	public ClienteAbstrato read(String id) {
		return null;
	}

	@Override
	public ClienteAbstrato update(String id) {
		return null;
	}

	@Override
	public void delete(String id) {
		
	}



}
