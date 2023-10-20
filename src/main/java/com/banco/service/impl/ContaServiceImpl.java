package com.banco.service.impl;

import java.util.List;

import com.banco.model.ContaAbstrata;
import com.banco.repository.ContaDAO;
import com.banco.repository.impl.ContaDAOImpl;
import com.banco.service.ContaService;

public class ContaServiceImpl implements ContaService {

	private ContaDAO repository;

	public ContaServiceImpl() {
		repository = new ContaDAOImpl();
	}

	@Override
	public void create(ContaAbstrata obj) {

				
		if (obj.getMontanteDepositado() >= 1500) {
			repository.create(obj);
			System.out.println("Conta Premium");

		} else if (obj.getMontanteDepositado() < 1500 && obj.getMontanteDepositado()< 20) {
			repository.create(obj);
			System.out.println("Conta Corrente");
		} else {
			System.out.println("Valor depositado insuficiente!");
		}

	}

	@Override
	public List<ContaAbstrata> readAll() {
		return repository.readAll();
	}

	@Override
	public ContaAbstrata read(String id) {
		return repository.read(id);
	}

	@Override
	public void delete(String id) {
		repository.delete(id);
	}

	@Override
	public ContaAbstrata update(String id) {
		return repository.update(id);
	}

	@Override
	public List<ContaAbstrata> readValor(double montanteFiltro) {
		return repository.readValor(montanteFiltro);
	}

}
