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
	public ClienteAbstrato update(String id, ClienteAbstrato obj) {
		for (int i = 0; i < dataBase.size(); i++) {
			ClienteAbstrato cliente = dataBase.get(i);
			if (cliente.getId().equals(id)) {
				dataBase.set(i, obj);
				break;
			}
						
		}
		return obj;
		
	}


	@Override
	public void delete(String id) {
		ClienteAbstrato cliente = read(id);
		dataBase.remove(cliente);
	}

	@Override
	public ClienteAbstrato read(String id) {
		for (ClienteAbstrato cliente : dataBase) {
			if (cliente.getId().equals(id)) {
				return cliente;
			}
		}
		return null;
	}


}
