package com.banco.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.banco.model.FuncionarioAbstrato;
import com.banco.repository.FuncionarioDAO;

public class FuncionarioDAOImpl implements FuncionarioDAO {

	private static FuncionarioAbstrato[] dataBase = new FuncionarioAbstrato[10];
	private int index = 0;
	
	@Override
	public void create(FuncionarioAbstrato obj) {
		dataBase[index] = obj;
		index++;
	}

	@Override
	public List<FuncionarioAbstrato> readAll() {
		List<FuncionarioAbstrato> listFunc = new ArrayList<>();
		for(int i = 0; i < dataBase.length; i++) {
			if(dataBase[i] == null)
				break;
			
			listFunc.add(dataBase[i]);
		}
		
		return listFunc;
	}
	

	@Override
	public FuncionarioAbstrato update(String id, FuncionarioAbstrato obj) {
		
		return null;
	}

	@Override
	public void delete(String id) {
		
		
	}

	@Override
	public FuncionarioAbstrato read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
