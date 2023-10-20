package com.banco.config;

import java.util.Date;

import com.banco.model.ContaAbstrata;
import com.banco.model.ContaCorrente;
import com.banco.model.ContaPoupanca;
import com.banco.model.ContaPremium;
import com.banco.repository.ContaDAO;
import com.banco.repository.impl.ContaDAOImpl;

public class ContaConfig {

	public static void start() {
		
		ContaAbstrata conta1 = new ContaCorrente();
		Date d1 = new Date();
		conta1.setDataCriacao(d1);
		conta1.setId("123456789");
		conta1.setNumeroConta("123456");
		
		ContaAbstrata conta2 = new ContaCorrente();
		Date d2 = new Date();
		conta2.setDataCriacao(d2);
		conta2.setId("123456987");
		conta2.setNumeroConta("123321");
		
		ContaAbstrata conta3 = new ContaPoupanca();
		conta3.setDataCriacao(d2);
		conta3.setId("123456789");
		conta3.setNumeroConta("123456");
		
		ContaAbstrata conta4 = new ContaPoupanca();
		conta4.setDataCriacao(d2);
		conta4.setId("123456987");
		conta4.setNumeroConta("123456");
		
		ContaAbstrata conta5 = new ContaPremium();
		conta4.setDataCriacao(d2);
		conta4.setId("987645367");
		conta4.setNumeroConta("748318");
		
		ContaAbstrata conta6 = new ContaCorrente();
		conta4.setDataCriacao(d2);
		conta4.setId("261738495");
		conta4.setNumeroConta("432213");
		
		ContaAbstrata conta7 = new ContaPremium();
		conta4.setDataCriacao(d2);
		conta4.setId("235654321");
		conta4.setNumeroConta("567875");
		
		
		
		
		ContaDAO controller = new ContaDAOImpl();
		
		controller.create(conta1);
		controller.create(conta2);
		controller.create(conta3);
		controller.create(conta4);
		controller.create(conta5);
		controller.create(conta6);
		controller.create(conta7);
		
	}
	
}
