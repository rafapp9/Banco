package com.banco.model;

import java.util.Date;

public abstract class ContaAbstrata {

	private String nifNipc;
	private String numeroConta;
	private Date dataCriacao;

	public String getNifNipc() {
		return nifNipc;
	}

	public void setNifNipc(String nifNipc) {
		this.nifNipc = nifNipc;
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
		return "ContaAbstrata [cpfCnpj=" + nifNipc + ", numeroConta=" + numeroConta + ", dataCriacao=" + dataCriacao
				+ "]";
	}

}
