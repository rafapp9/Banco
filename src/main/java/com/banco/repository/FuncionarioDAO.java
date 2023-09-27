package com.banco.repository;

import com.banco.model.FuncionarioAbstrato;

public interface FuncionarioDAO extends GenericCRUD<FuncionarioAbstrato, String> {

	int readIndex(String id);
	
	FuncionarioAbstrato updateName(String id, String name);
	
}
