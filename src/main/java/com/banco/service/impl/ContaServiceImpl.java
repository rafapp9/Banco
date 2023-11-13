package com.banco.service.impl;

import java.util.List;

import com.banco.exceptions.ContaException;
import com.banco.exceptions.InsufficientBalanceException;
import com.banco.exceptions.NifException;
import com.banco.model.ClienteAbstrato;
import com.banco.model.ContaAbstrata;
import com.banco.model.ContaDTO;
import com.banco.repository.ClienteDAO;
import com.banco.repository.ContaDAO;
import com.banco.repository.impl.ClienteDAOImpl;
import com.banco.repository.impl.ContaDAOImpl;
import com.banco.service.ContaService;

public class ContaServiceImpl implements ContaService {

	private ContaDAO repository;
	private ClienteDAO cliente;

	public ContaServiceImpl() {
		repository = new ContaDAOImpl();
		cliente = new ClienteDAOImpl();
	}

	private boolean clienteIdExists(String id) {
		for (ClienteAbstrato clienteId : cliente.readAll()) {
			if (clienteId.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void create(ContaDTO contaDTO) throws NifException {
		if (contaDTO.id() == null || contaDTO.id().isBlank()) {
			throw new NifException();
		} else {
	        String newId = contaDTO.id();

	        if (clienteIdExists(newId)) {
	            ContaAbstrata conta = FactoryConta.getConta(contaDTO);
	            create(conta);
	        } else {
	            throw new NifException();
	        }
	    }
	}

	@Override
	public void create(ContaAbstrata obj) {
		repository.create(obj);

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
	public ContaAbstrata update(String id, ContaAbstrata obj) {
		return repository.update(id, obj);
	}

	@Override
	public List<ContaAbstrata> filterAccountByAmount(double montanteFiltro) {
		return repository.filterAccountByAmount(montanteFiltro);
	}

	@Override
	public ContaAbstrata credit(String id, double montante) throws ContaException {
		ContaAbstrata conta = repository.read(id);
		if (conta == null) {
			throw new ContaException();
		} else {
			conta = repository.credit(id, montante);
			return conta;
		}
	}

	@Override
	public ContaAbstrata debit(String id, double montante) throws ContaException, InsufficientBalanceException {
		// TODO CALL debit in repository
		ContaAbstrata conta = repository.read(id);
		if (conta == null) {
			throw new ContaException();
		}

		double montanteAtual = conta.getMontanteConta();
		if (montanteAtual >= montante) {
			double novoMontante = montanteAtual - montante;
			conta.setMontanteConta(novoMontante);
			return conta;
		} else {
			throw new InsufficientBalanceException();
		}

	}

	public void clearRepository() {
		repository.clearRepository();
	}

	@Override
	public List<ContaAbstrata> filterByNIF(String nif) {
		return repository.filterByNIF(nif);
	}

}
