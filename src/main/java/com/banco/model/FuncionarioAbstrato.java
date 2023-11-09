package com.banco.model;

import java.time.LocalDate;

public abstract class FuncionarioAbstrato extends PessoaAbstrata {
	
	public FuncionarioAbstrato(String id, String nome, String sexo, LocalDate dataNascimento, double vendaMensal) {
		super.setId(id);
		super.setNome(nome);
		super.setSexo(sexo);
		super.setDataNascimento(dataNascimento.getYear(), dataNascimento.getMonthValue(), dataNascimento.getDayOfMonth());
	}

	private double ordenado;

	public double getOrdenado() {
		return ordenado;
	}

	public void setOrdenado(double ordenado) {
		this.ordenado = ordenado;

	}

}