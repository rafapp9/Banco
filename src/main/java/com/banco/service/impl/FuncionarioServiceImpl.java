package com.banco.service.impl;

import java.util.List;

import com.banco.model.FuncionarioAbstrato;
import com.banco.repository.ClienteDAO;
import com.banco.repository.FuncionarioDAO;
import com.banco.repository.impl.FuncionarioDAOImpl;
import com.banco.service.FuncionarioService;

public class FuncionarioServiceImpl implements FuncionarioService {

	private FuncionarioDAO repository;

	@Override
	public void create(FuncionarioAbstrato obj) {
		if (obj.getId().length() == 9) {
			boolean idExists = false;

			for (FuncionarioAbstrato existenciaId : repository.readAll()) {
				if (existenciaId.getId().equals(obj.getId())) {
					idExists = true;
					break;
				}
			}

			if (!idExists) {
				repository.create(obj);
			} else {
				System.out.println("NIF já existe");
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
		// TODO Auto-generated method stub
		return null;
	}

}
