package com.banco.service.impl;

import java.util.Date;

import com.banco.model.ContaAbstrata;
import com.banco.model.ContaCorrente;
import com.banco.model.ContaDTO;
import com.banco.model.ContaPremium;

public class FactoryConta {

	public static ContaAbstrata getConta(ContaDTO contaDTO) {
		if(contaDTO.montanteInicial() >= 1500) {
			return new ContaPremium(contaDTO.id(), contaDTO.numeroDaConta(), new Date(), contaDTO.montanteInicial());
		}else if(contaDTO.montanteInicial() < 1500 && contaDTO.montanteInicial() > 20) {
			return new ContaCorrente(contaDTO.id(), contaDTO.numeroDaConta(), new Date(), contaDTO.montanteInicial());
		}
		return null;
	}
}
