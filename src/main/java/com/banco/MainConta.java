package com.banco;

import java.util.Date;
import java.util.List;

import com.banco.model.ContaAbstrata;
import com.banco.model.ContaCorrente;
import com.banco.repository.ContaDAO;
import com.banco.repository.impl.ContaDAOImpl;

public class MainConta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ContaAbstrata conta1 = new ContaCorrente();
		Date d1 = new Date();
		conta1.setDataCriacao(d1);
		conta1.setId("54321");
		conta1.setNumeroConta("67583");
		conta1.setMontanteConta(50000);
		
		ContaAbstrata conta2 = new ContaCorrente();
		Date d2 = new Date();
		conta2.setDataCriacao(d2);
		conta2.setId("12345");
		conta2.setNumeroConta("123456");
		conta2.setMontanteConta(200);
		
	
		
		ContaDAO repository1 = new ContaDAOImpl();
		
		repository1.create(conta1);
		repository1.create(conta2);
		
		System.out.println(conta2.getId());
		
		
		
		List<ContaAbstrata> readValor = repository1.readValor(500);
		
		for(ContaAbstrata conta : readValor) {
			System.out.println(conta.getId() + " - " + conta.getMontanteConta());
			
		}
		
		List<ContaAbstrata> readConta = repository1.readAll();
		for(ContaAbstrata conta : readConta) {
			System.out.println(conta2.getId() + " - " + conta2.getNumeroConta());
		}

	}

}
