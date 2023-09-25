package com.banco.model;

public abstract class ClienteAbstrato extends PessoaAbstrata {
	
	private int montanteDepositado;

	public int getMontanteDepositado() {
		return montanteDepositado;
	}

	public void setMontanteDepositado(int montanteDepositado) {
		this.montanteDepositado = montanteDepositado;
	}

}
