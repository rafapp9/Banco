package com.banco.repository;

import java.util.List;

import com.banco.model.ContaAbstrata;

public interface ContaDAO extends GenericCRUD<ContaAbstrata, String> {

	List<ContaAbstrata> filterAccountByAmount(double montanteFiltro);
	
}
