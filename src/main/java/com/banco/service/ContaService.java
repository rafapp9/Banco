package com.banco.service;

import java.util.List;

import com.banco.controller.ContaController;
import com.banco.model.ContaAbstrata;
import com.banco.model.ContaDTO;
import com.banco.repository.GenericCRUD;

public interface ContaService extends GenericCRUD<ContaAbstrata, String> {

	List<ContaAbstrata> filterAccountByAmount(double montanteFiltro); 
	
	void create(ContaDTO contaDTO);

	ContaDTO update(String id, ContaController obj);
}
