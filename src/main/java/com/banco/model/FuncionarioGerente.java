package com.banco.model;

import java.time.LocalDate;

public class FuncionarioGerente extends FuncionarioAbstrato {

	public FuncionarioGerente(String id, String nome, String sexo, LocalDate dataNascimento, double vendaMensal) {
		super(id, nome, sexo, dataNascimento, vendaMensal);
	}

	/**
	 * 
	 * @param id
	 * @param nome
	 * @param vendaMensal
	 */
	
	private double vendaMensal;

	public double getVendaMensal() {
		return vendaMensal;
	}

	public void setVendaMensal(double vendaMensal) {
		this.vendaMensal = vendaMensal;
	}
	
}
