package com.banco.service.impl;

import com.banco.model.FuncionarioAbstrato;
import com.banco.model.FuncionarioGerente;

public class FactoryFuncionario {

	public static FuncionarioAbstrato getFuncionario (FuncionarioAbstrato funconarioAbstrato) {
		if (funconarioAbstrato.getId().length() >= 9) {
			return new FuncionarioGerente(funconarioAbstrato.getId(), funconarioAbstrato.getNome(), funconarioAbstrato.getOrdenado());
			
		} else {
			System.out.println("NIF Inválido");
			return null;
		}

		
	}
	
}
