package com.banco;

import java.util.Date;
import java.util.List;

import com.banco.model.ContaAbstrata;
import com.banco.model.ContaCorrente;
import com.banco.repository.ContaDAO;
import com.banco.repository.impl.ContaDAOImpl;

public class Main {

	public static void main(String[] args) {
		ContaAbstrata c1 = new ContaCorrente();
		Date d1 = new Date();
		c1.setDataCriacao(d1);
		c1.setNifNipc("12345678912");
		c1.setNumeroConta("123456");
		
		ContaAbstrata c2 = new ContaCorrente();
		Date d2 = new Date();
		c2.setDataCriacao(d2);
		c2.setNifNipc("12345678912");
		c2.setNumeroConta("123456");
		
		ContaDAO repository = new ContaDAOImpl();
		
		repository.create(c1);
		repository.create(c2);
		
		List<ContaAbstrata> contas = repository.readAll();
		
		/*
		//for normal
		for(int i = 0; i < contas.size(); i++) {
			ContaAbstrata conta = contas.get(i);
			System.out.println(conta.getNumeroConta()); 
		}
		
		//foreach
		for(ContaAbstrata conta : contas) {
			System.out.println(conta.getNumeroConta());
		}*/
		
		//for com lambda
		contas.forEach(conta ->{
			System.out.println(conta.getNumeroConta());
		});
		
		ContaDAO repository2 = new ContaDAOImpl();
		
		repository2.readAll().forEach(c -> {System.out.println(c.getNifNipc());});
		
		
		ContaDAO repository4 = new ContaDAOImpl();
		
		repository4.readAll().forEach(c -> {System.out.println(c.getNifNipc());});
	}

}
