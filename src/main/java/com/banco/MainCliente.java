package com.banco;

import java.time.LocalDate;

import com.banco.model.ClienteAbstrato;
import com.banco.model.ClienteStandard;
import com.banco.repository.ClienteDAO;
import com.banco.repository.impl.ClienteDAOImpl;

public class MainCliente {

	public static void main(String[] args) {
		
		ClienteAbstrato cliente = new ClienteStandard("21399995", "Rafel" , "Homem", LocalDate.of(1996, 7, 22), 500);
		
		ClienteDAO repository = new ClienteDAOImpl();
	
		repository.create(cliente);
		
		System.out.println(cliente.getId() + " - " + cliente.getSexo() + " - " + cliente.getDataNascimento());
	}

}
