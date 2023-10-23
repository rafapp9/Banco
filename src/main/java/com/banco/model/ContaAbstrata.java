package com.banco.model;

import java.util.Date;

public abstract class ContaAbstrata {
	
	public ContaAbstrata() {}
	
	public ContaAbstrata(String id, String numeroConta, Date dataCriacao, double montanteDepositado) {
		this.id = id;
		this.numeroConta = numeroConta;
		this.dataCriacao = dataCriacao;
		this.montanteDepositado = montanteDepositado;
	}

	/**
	 * nif do Cliente
	 */
	private String id;
	private String numeroConta;
	private Date dataCriacao;
	private int montanteConta;
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

	public double getMontanteDepositado() {
		return montanteDepositado;
	}

	public void setMontanteDepositado(double montanteDepositado) {
		this.montanteDepositado = montanteDepositado;
	}
	
	public abstract String getTpConta();

}
