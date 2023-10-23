package com.banco.service;

import com.banco.model.FuncionarioAbstrato;
import com.banco.repository.GenericCRUD;

public interface FuncionarioService extends GenericCRUD<FuncionarioAbstrato, String> {
	
	int readIndex(String id);
	
	FuncionarioAbstrato updateName(String id, String name);


}
