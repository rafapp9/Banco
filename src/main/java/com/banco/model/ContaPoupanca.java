package com.banco.model;

public class ContaPoupanca extends ContaAbstrata {

	private static final double RENDIMENTO_ANUAL = 10;
	private static final String TP_CONTA = "Poupanca";

	public static double getRendimentoAnual() {
		return RENDIMENTO_ANUAL;
	}

	@Override
	public String getTpConta() {
		return TP_CONTA;
	}

}