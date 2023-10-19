package com.banco.config;

import java.util.Date;

import com.banco.model.ContaAbstrata;
import com.banco.model.ContaCorrente;
import com.banco.model.ContaPoupanca;
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
		
		ContaDAO repository = new ContaDAOImpl();
		
		repository.create(conta1);
		repository.create(conta2);
		repository.create(conta3);
		repository.create(conta4);
		
	}
	
}
