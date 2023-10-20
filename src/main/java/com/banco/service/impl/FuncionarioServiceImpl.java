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
		
		if (obj.getId().length() >= 9) {
			repository.create(obj); 
			
		} else {
			System.out.println("NIF Inválido");
			
		}
		repository = new FuncionarioDAOImpl();
		
	}

	@Override
	public List<FuncionarioAbstrato> readAll() {
		return repository.readAll();
	}

	@Override
	public FuncionarioAbstrato update(String id) {
		return repository.update(id);
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
	public FuncionarioAbstrato idOrdenado(String id) {
		return repository.idOrdenado(id);
	}

	



}
