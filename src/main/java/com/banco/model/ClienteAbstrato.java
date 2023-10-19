package com.banco.model;

public abstract class ClienteAbstrato extends PessoaAbstrata {
	
	private double montanteDepositado;

	
	public ClienteAbstrato(String id, String nome, double montanteDepositado) {
		super.setId(id);
		super.setNome(nome);
		this.montanteDepositado = montanteDepositado;
	}

	public double getMontanteDepositado() {
		return montanteDepositado;
	}

	public void setMontanteDepositado(double montanteDepositado) {
		this.montanteDepositado = montanteDepositado;
	}

}

