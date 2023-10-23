package com.banco.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.banco.model.ContaAbstrata;
import com.banco.repository.ContaDAO;

public class ContaDAOImpl implements ContaDAO {

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
	//TODO
	public ContaAbstrata update(String id, ContaAbstrata obj) {
		for (int i = 0; i < dataBase.size(); i++) {
			ContaAbstrata conta = dataBase.get(i);
			if (conta.getId().equals(id)) {
				dataBase.set(i, conta);
				break;

			}

		}
		return null;

	}

	@Override
	public ContaAbstrata read(String id) {
		for (ContaAbstrata conta : dataBase) {
			if (conta.getId().equals(id)) {
				return conta;
			}
		}
		return null;
	}

	@Override
	public void delete(String id) {
		for (ContaAbstrata conta : dataBase) {
			if (conta.getId().equals(id)) {
				dataBase.remove(conta);
				break;
			}

		}
	}

	@Override
	public List<ContaAbstrata> readValor(double montanteFiltro) {
		List<ContaAbstrata> filtroValor = new ArrayList<>();
		for (ContaAbstrata conta : dataBase) {
			if (conta.getMontanteConta() >= montanteFiltro) {
				filtroValor.add(conta);

			}
		}
		return filtroValor;
	}

	// @Override
	// public ContaAbstrata read(String id) {
	// TODO Auto-generated method stub
	// return null;
//	}

	/*
	 * @Override public ContaAbstrata read(String montanteConta) { for
	 * (ContaAbstrata conta : dataBase) { if
	 * (conta.getMontanteConta().equals(montanteConta)) { return conta; }
	 */

}
