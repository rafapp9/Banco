package com.banco.repository;

import java.util.List;

import com.banco.exceptions.ContaException;
import com.banco.model.ContaAbstrata;

public interface ContaDAO extends GenericCRUD<ContaAbstrata, String> {

	List<ContaAbstrata> filterAccountByAmount(double montanteFiltro);

	ContaAbstrata credit(String id, double montante) throws ContaException;
	ContaAbstrata debit(String id, double montante) throws ContaException;
    void clearRepository();
	
	
}
