package com.banco.model;

import java.util.Date;

public class ContaPremium extends ContaAbstrata {
	
	public ContaPremium() {
	}
	
	public ContaPremium(String id, String numeroConta, Date dataCriacao, double montanteDepositado) {
		super(id, numeroConta, dataCriacao, montanteDepositado);
	}

	private static final double RENDIMENTO_ANUAL = 20;
	private static final String TP_CONTA = "Premium";

	public static double getRendimentoAnual() {
		return RENDIMENTO_ANUAL;
	}
	
	@Override
	public String getTpConta() {
		return TP_CONTA;
	}

}
