package com.banco.model;

import java.util.Date;

public abstract class ContaAbstrata {

	/**
	 * nif do Cliente
	 */
	private String id;
	private String numeroConta;
	private Date dataCriacao;
	private int montanteConta;
	private int montanteMinimo;
	private double montanteDepositado;

	/**
	 * nif do Cliente
	 */
	public String getId() {
		return id;
	}

	public void setId(String Id) {
		this.id = Id;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public String toString() {
		return "ContaAbstrata [Id=" + id + ", numeroConta=" + numeroConta + ", dataCriacao=" + dataCriacao
				+ "]";
	}

	public int getMontanteConta() {
		return montanteConta;
	}

	public void setMontanteConta(int montanteConta) {
		this.montanteConta = montanteConta;
	}

	public int getMontanteMinimo() {
		return montanteMinimo;
	}

	public void setMontanteMinimo(int montanteMinimo) {
		this.montanteMinimo = montanteMinimo;
	}

	public double getMontanteDepositado() {
		return montanteDepositado;
	}

	public void setMontanteDepositado(double montanteDepositado) {
		this.montanteDepositado = montanteDepositado;
	}

}
