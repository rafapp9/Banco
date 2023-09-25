package com.banco.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.banco.model.ContaAbstrata;
import com.banco.repository.ContaDAO;

public class ContaDAOImpl implements ContaDAO{
	
	private static List<ContaAbstrata> dataBase = new ArrayList<>();
	

	@Override
	public void create(ContaAbstrata conta) {
		dataBase.add(conta);
		
	}

	@Override
	public List<ContaAbstrata> readAll() {
		return dataBase;
	}

	@Override
	public ContaAbstrata update(String numeroConta, ContaAbstrata conta) {
		return null;
	}

	@Override
	public void delete(String numeroConta) {
		
	}

	@Override
	public ContaAbstrata read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
