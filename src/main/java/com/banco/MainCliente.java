package com.banco;

import com.banco.model.ClienteAbstrato;
import com.banco.model.ClienteStandard;
import com.banco.repository.ClienteDAO;
import com.banco.repository.impl.ClienteDAOImpl;

public class MainCliente {

	public static void main(String[] args) {
		
		ClienteAbstrato cliente = new ClienteStandard("2135", "Rafel" , 500);
		
		ClienteDAO repository = new ClienteDAOImpl();
	
		repository.create(cliente);
		
		System.out.println(cliente.getId());
	}

}
