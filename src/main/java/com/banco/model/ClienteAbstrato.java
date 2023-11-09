package com.banco.model;

import java.time.LocalDate;

public abstract class ClienteAbstrato extends PessoaAbstrata {
	
	private double montanteDepositado;

	
	public ClienteAbstrato(String id, String nome, String sexo, LocalDate dataNascimento, double montanteDepositado) {
		super.setId(id);
		super.setNome(nome);
		super.setSexo(sexo);
		super.setDataNascimento(dataNascimento.getYear(), dataNascimento.getMonthValue(), dataNascimento.getDayOfMonth());
		this.montanteDepositado = montanteDepositado;
	}

	public double getMontanteDepositado() {
		return montanteDepositado;
	}

	public void setMontanteDepositado(double montanteDepositado) {
		this.montanteDepositado = montanteDepositado;
	}

}

