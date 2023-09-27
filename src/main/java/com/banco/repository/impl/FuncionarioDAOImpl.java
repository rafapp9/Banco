package com.banco.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.banco.model.FuncionarioAbstrato;
import com.banco.repository.FuncionarioDAO;

public class FuncionarioDAOImpl implements FuncionarioDAO {

	//array de funcionarios
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
		for (int i = 0; i < index; i++) {
			listFunc.add(dataBase[i]);
		}
		return listFunc;
	}

	@Override
	public FuncionarioAbstrato update(String id, FuncionarioAbstrato obj) {
		int index = this.readIndex(id);
		dataBase[index] = obj;
		return obj;
	}

	@Override
	public void delete(String id) {
		int index = this.readIndex(id);
		dataBase[index] = null;
		//TODO ajustar array para os preenchidos ficarem nos primeiros index
		//pode usar o this.index
	}

	@Override
	public FuncionarioAbstrato read(String id) {
		for (int i = 0; i < dataBase.length; i++) {
			FuncionarioAbstrato func = dataBase[i];
			if (func.getId().equals(id)) {
				return func;
			}
		}
		return null;
	}

	@Override
	public int readIndex(String id) {
		//loop no database
		for (int i = 0; i < dataBase.length; i++) {
			FuncionarioAbstrato func = dataBase[i];
			if (func.getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public FuncionarioAbstrato updateName(String id, String name) {
		int ind = readIndex(id);
		dataBase[ind].setNome(name);
		return dataBase[ind];
	}

}
