package com.banco.repository;

import java.util.List;

import com.banco.model.ClienteAbstrato;

public interface ClienteDAO {

	/**
	 * Create a client in database
	 * 
	 * @param cliente
	 */
	void create(ClienteAbstrato cliente);
	
	List<ClienteAbstrato> readAll();
	
	ClienteAbstrato update(String nomeCliente, ClienteAbstrato cliente);
	
	void delete(String nomeCliente);
}