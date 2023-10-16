package com.banco.study;

import java.util.Date;

import com.banco.model.ContaAbstrata;
import com.banco.model.ContaCorrente;
import com.banco.model.ContaPoupanca;
import com.banco.model.ContaPremium;

public class EnumAbstractMethodMain {

	public static void main(String[] args) {
		ContaAbstrata conta = createAccount("PREMIUM");
		
		if(conta instanceof ContaCorrente) {
			ContaCorrente corrente = (ContaCorrente) conta;
			System.out.println(corrente.getRendimentoAnual()); 
		}else if(conta instanceof ContaPoupanca) {
			ContaPoupanca poupanca = (ContaPoupanca) conta;
			System.out.println(poupanca.getRendimentoAnual());
		}else if(conta instanceof ContaPremium) {
			ContaPremium premium = (ContaPremium) conta;
			System.out.println(premium.getRendimentoAnual());
		}
		
	}
	
	private static ContaAbstrata createAccount(String type) {
		ContaAbstrata conta1 = null;
		for(EnumAbstractMethod enumT : EnumAbstractMethod.values()) {
			if(type.equals(enumT.name())) {
				conta1 = enumT.typeAccount();
			}
		}
		Date d1 = new Date();
		conta1.setDataCriacao(d1);
		conta1.setId("12345678912");
		conta1.setNumeroConta("123456");
		
		return conta1;
		
	}

}
