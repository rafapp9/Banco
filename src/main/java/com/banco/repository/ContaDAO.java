package com.banco.repository;

import java.util.List;

import com.banco.model.ContaAbstrata;
import com.banco.model.ContaDTO;

public interface ContaDAO extends GenericCRUD<ContaAbstrata, String> {

	List<ContaAbstrata> filterAccountByAmount(double montanteFiltro);

	ContaDTO update(String id, ContaDTO conta);
	
}
