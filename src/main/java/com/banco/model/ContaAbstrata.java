package com.banco.model;

import java.util.Date;

public abstract class ContaAbstrata {

	private String Id;
	private String numeroConta;
	private Date dataCriacao;
	private int montanteConta;
	private int montanteMinimo;

	public String getId() {
		return Id;
	}

	public void setId(String Id) {
		this.Id = Id;
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
		return "ContaAbstrata [Id=" + Id + ", numeroConta=" + numeroConta + ", dataCriacao=" + dataCriacao
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

}
