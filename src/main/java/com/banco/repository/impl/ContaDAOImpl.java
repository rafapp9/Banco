package com.banco.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.banco.exceptions.ContaException;
import com.banco.model.ContaAbstrata;
import com.banco.repository.ContaDAO;

public class ContaDAOImpl implements ContaDAO {
	private static Map<String, ContaAbstrata> dataBase = new HashMap<>();

	@Override
	public void create(ContaAbstrata conta) {
		dataBase.put(conta.getNumeroConta(), conta);
	}

	@Override
	public List<ContaAbstrata> readAll() {
		return List.copyOf(dataBase.values());
	}

	@Override
	public ContaAbstrata update(String id, ContaAbstrata obj) {
		if (dataBase.containsKey(id)) {
			dataBase.put(id, obj);
		}
		return obj;
	}

	@Override
	public ContaAbstrata read(String id) {
		return dataBase.get(id);
	}

	@Override
	public void delete(String id) {
		dataBase.remove(id);
	}

	@Override
	public List<ContaAbstrata> filterAccountByAmount(double montanteFiltro) {
		List<ContaAbstrata> filtroValor = new ArrayList<>();
		for (ContaAbstrata conta : dataBase.values()) {
			if (conta.getMontanteConta() >= montanteFiltro) {
				filtroValor.add(conta);
			}
		}
		return filtroValor;
	}

	@Override
	public ContaAbstrata credit(String id, double montante) throws ContaException {
		ContaAbstrata conta = dataBase.get(id);

		if (conta != null) {
			double montanteAtual = conta.getMontanteConta();
			double montanteAtualizado = montanteAtual + montante;
			conta.setMontanteConta(montanteAtualizado);

			dataBase.put(id, conta);
			return conta;
		}
		throw new ContaException();
	}

	@Override
	public ContaAbstrata debit(String id, double montante) throws ContaException {
		//TODO CALL debit in repository
		ContaAbstrata conta = dataBase.get(id);

		if (conta != null) {
			double montanteAtual = conta.getMontanteConta();
			if (montanteAtual >= montante) {
				double montanteAtualizado = montanteAtual - montante;
				conta.setMontanteConta(montanteAtualizado);
				dataBase.replace(id, conta);
				dataBase.put(id, conta);
				return conta;
			}
		}
		throw new ContaException();
	}

	@Override
	public void clearRepository() {
		dataBase.clear();
	}

	@Override
	public List<ContaAbstrata> filterByNIF(String nif) {
		List<ContaAbstrata> contasFilter = new ArrayList<>();
		dataBase.forEach((k, v) -> {
			if(v.getId().equals(nif)) {
				contasFilter.add(v);
			}
		});
		return contasFilter;
	}
	
	@Override
	public ContaAbstrata directDebit(String id, double montante) throws ContaException {
	    // TODO CALL directDebit in repository
	    ContaAbstrata conta = dataBase.get(id);

	    if (conta != null) {
	        double montanteAtual = conta.getMontanteConta();
	        if (montanteAtual >= montante) {
	            double montanteAtualizado = montanteAtual - montante;
	            conta.setMontanteConta(montanteAtualizado);
	            dataBase.replace(id, conta);
	            return conta;
	        }
	    }
	    throw new ContaException();
	}
}
