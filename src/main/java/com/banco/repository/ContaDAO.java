package com.banco.repository;

import java.util.List;

import com.banco.model.ContaAbstrata;

public interface ContaDAO {

	/**
	 * Create an account in database
	 * 
	 * @param conta
	 */
	void create(ContaAbstrata conta);
	
	List<ContaAbstrata> readAll();
	
	ContaAbstrata update(String numeroConta, ContaAbstrata conta);
	
	void delete(String numeroConta);
}
