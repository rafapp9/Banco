package com.banco.model;

public abstract class FuncionarioAbstrato extends PessoaAbstrata{
	
	private double ordenado;

	public double getOrdenado() {
		return ordenado;
	}

	public void setOrdenado(double ordenado) {
		this.ordenado = ordenado;
	}
	
}
