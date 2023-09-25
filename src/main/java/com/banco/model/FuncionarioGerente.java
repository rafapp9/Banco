package com.banco.model;

public class FuncionarioGerente extends FuncionarioAbstrato {

	/**
	 * 
	 * @param id
	 * @param nome
	 * @param vendaMensal
	 */
	public FuncionarioGerente(String id, String nome, double vendaMensal) {
		this.vendaMensal = vendaMensal;
		super.setId(id);
		super.setNome(nome);
	}
	
	private double vendaMensal;

	public double getVendaMensal() {
		return vendaMensal;
	}

	public void setVendaMensal(double vendaMensal) {
		this.vendaMensal = vendaMensal;
	}
	
}
