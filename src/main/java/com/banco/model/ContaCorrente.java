package com.banco.model;

import java.util.Date;

public class ContaCorrente extends ContaAbstrata {
	
	public ContaCorrente() {};
	
	public ContaCorrente(String id, String numeroConta, Date dataCriacao, double montanteDepositado) {
		super(id, numeroConta, dataCriacao, montanteDepositado);
	}

	private static final double RENDIMENTO_ANUAL = 1;
	private static final String TP_CONTA = "Corrente";

	public double getRendimentoAnual() {
		return RENDIMENTO_ANUAL;
	}
	
	@Override
	public String getTpConta() {
		return TP_CONTA;
	}
	
}
