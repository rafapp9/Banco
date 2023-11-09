package com.banco.model;

import java.time.LocalDate;

public class ClienteStandard extends ClienteAbstrato {

	public ClienteStandard(String id, String nome, String sexo, LocalDate dataNascimento, double montanteDepositado) {
		super(id, nome, sexo, dataNascimento, montanteDepositado);
	}

	
}
