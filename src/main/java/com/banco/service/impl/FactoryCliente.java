package com.banco.service.impl;

import java.util.Date;

import com.banco.model.ClienteAbstrato;
import com.banco.model.ClienteStandard;

public class FactoryCliente {

	public static ClienteAbstrato getCliente (ClienteAbstrato clienteAbstrato) {
		if (clienteAbstrato.getId().length()>=9) {
			return new ClienteStandard(clienteAbstrato.getId(), clienteAbstrato.getNome(), clienteAbstrato.getMontanteDepositado());
			
		} else {
			System.out.println("NIF Inválido");
			return null;
		}

		
	}
	
}
