package com.banco.service.impl;

import java.util.List;

import com.banco.model.FuncionarioAbstrato;
import com.banco.repository.FuncionarioDAO;
import com.banco.repository.impl.FuncionarioDAOImpl;
import com.banco.service.FuncionarioService;

public class FuncionarioServiceImpl implements FuncionarioService {

	private FuncionarioDAO repository;

	public FuncionarioServiceImpl() {
		repository = new FuncionarioDAOImpl();
	}
	
	@Override
	public void create(FuncionarioAbstrato obj) {
		if (obj.getId().length() == 9) {

			if (this.read(obj.getId()) != null) {
				System.out.println("NIF já existe");
			} else {
				repository.create(obj);
			}

		} else {
			System.out.println("NIF Inválido");
		}

	}

	@Override
	public void delete(String id) {
		repository.delete(id);

	}

	@Override
	public int readIndex(String id) {
		return repository.readIndex(id);
	}

	@Override
	public FuncionarioAbstrato updateName(String id, String name) {
		return repository.updateName(id, name);
	}

	@Override
	public FuncionarioAbstrato update(String id, FuncionarioAbstrato obj) {
		return repository.update(id, obj);
	}

	@Override
	public FuncionarioAbstrato read(String id) {
		return repository.read(id);
	}

	@Override
	public List<FuncionarioAbstrato> readAll() {
		return repository.readAll();
	}

	@Override
	public List<FuncionarioAbstrato> filterFuncsByGoal(double amount) {
		return repository.filterFuncsByGoal(amount);
	}

}
