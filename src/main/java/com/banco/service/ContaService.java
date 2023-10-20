package com.banco.service;

import java.util.List;

import com.banco.model.ContaAbstrata;
import com.banco.repository.GenericCRUD;

public interface ContaService extends GenericCRUD<ContaAbstrata, String> {

	List<ContaAbstrata> readValor(double montanteFiltro); 
}
