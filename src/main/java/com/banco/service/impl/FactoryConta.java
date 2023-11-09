package com.banco.service.impl;

import java.util.Date;

import com.banco.exceptions.ContaValidateException;
import com.banco.model.ContaAbstrata;
import com.banco.model.ContaCorrente;
import com.banco.model.ContaDTO;
import com.banco.model.ContaPremium;

public class FactoryConta {

	public static ContaAbstrata getConta(ContaDTO contaDTO) throws ContaValidateException {
		if(contaDTO.montanteConta() >= 1500) {
			return new ContaPremium(contaDTO.id(), contaDTO.numeroDaConta(), new Date(), contaDTO.montanteConta());
		}else if(contaDTO.montanteConta() < 1500 && contaDTO.montanteConta() > 20) {
			return new ContaCorrente(contaDTO.id(), contaDTO.numeroDaConta(), new Date(), contaDTO.montanteConta());
		}
		throw new ContaValidateException();
	}
}
