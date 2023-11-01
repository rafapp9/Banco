package com.banco.repository;

import java.util.List;

import com.banco.model.FuncionarioAbstrato;

public interface FuncionarioDAO extends GenericCRUD<FuncionarioAbstrato, String> {

	int readIndex(String id);
	
	FuncionarioAbstrato updateName(String id, String name);
	FuncionarioAbstrato read(String id);

	List<FuncionarioAbstrato> filterFuncsByGoal(double amount);



}
