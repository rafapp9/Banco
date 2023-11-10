 package com.banco.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.banco.model.ClienteAbstrato;
import com.banco.model.ClienteStandard;
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
	
	@Override
	public List<ClienteAbstrato> filterCltByAge(int age) {
		List<ClienteAbstrato> filter = new ArrayList<>();
		for(ClienteAbstrato c : dataBase) {
			if(c instanceof ClienteStandard ) {
				ClienteStandard cliente = (ClienteStandard) c;
				int clienteAge = cliente.calculateAge();
				if(clienteAge >= age) {
					filter.add(cliente);
				}
			}
		}
		return filter;
	}


}
