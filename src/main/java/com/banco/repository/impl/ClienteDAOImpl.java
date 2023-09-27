package com.banco.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.banco.model.ClienteAbstrato;
import com.banco.repository.ClienteDAO;

public class ClienteDAOImpl implements ClienteDAO {

	private static List<ClienteAbstrato> dataBase = new ArrayList<>();

	@Override
	public void create(ClienteAbstrato cliente) {
		dataBase.add(cliente);
		
	}

	@Override
	public List<ClienteAbstrato> readAll() {
		return dataBase;
	}

	@Override
	public ClienteAbstrato update(String id, ClienteAbstrato cliente) {
		//TODO
		return null;
	}

	@Override
	public void delete(String nomeCliente) {
		//TODO
	}

	@Override
	public ClienteAbstrato read(String id) {
		// TODO Auto-generated method stub
		return null;
	}


}
