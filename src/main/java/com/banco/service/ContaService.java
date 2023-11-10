package com.banco.service;

import java.util.List;

import com.banco.exceptions.ContaException;
import com.banco.exceptions.ContaValidateException;
import com.banco.exceptions.InsufficientBalanceException;
import com.banco.model.ContaAbstrata;
import com.banco.model.ContaDTO;
import com.banco.repository.GenericCRUD;

public interface ContaService extends GenericCRUD<ContaAbstrata, String> {

	List<ContaAbstrata> filterAccountByAmount(double montanteFiltro); 
	
	void create(ContaDTO contaDTO) throws ContaValidateException;
	ContaAbstrata credit(String id, double montante) throws ContaException;
	ContaAbstrata debit(String id, double montante) throws ContaException, InsufficientBalanceException;
	void clearRepository();
	List<ContaAbstrata> filterByNIF(String nif);
}
