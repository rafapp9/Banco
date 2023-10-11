package com.banco.config;

import java.util.Date;

import com.banco.model.ContaAbstrata;
import com.banco.model.ContaCorrente;
import com.banco.repository.ContaDAO;
import com.banco.repository.impl.ContaDAOImpl;

public class ContaConfig {

	public void initContas() {
		
		ContaAbstrata conta1 = new ContaCorrente();
		Date d1 = new Date();
		conta1.setDataCriacao(d1);
		conta1.setId("12345678912");
		conta1.setNumeroConta("123456");
		
		ContaAbstrata conta2 = new ContaCorrente();
		Date d2 = new Date();
		conta2.setDataCriacao(d2);
		conta2.setId("12345678912");
		conta2.setNumeroConta("123456");
		
		ContaDAO repository1 = new ContaDAOImpl();
		
		repository1.create(conta1);
		repository1.create(conta2);
		
	}
	
}
