package com.banco;

import java.util.Date;
import java.util.List;

import com.banco.model.ClienteAbstrato;
import com.banco.model.ClienteStandard;
import com.banco.model.ContaAbstrata;
import com.banco.model.ContaCorrente;
import com.banco.repository.ClienteDAO;
import com.banco.repository.ContaDAO;
import com.banco.repository.impl.ClienteDAOImpl;
import com.banco.repository.impl.ContaDAOImpl;

public class Main {

	public static void main(String[] args) {
	
		// Criação de contas
		ContaAbstrata conta1 = new ContaCorrente();
		Date d1 = new Date();
		conta1.setDataCriacao(d1);
		conta1.setNifNipc("12345678912");
		conta1.setNumeroConta("123456");
		
		ContaAbstrata conta2 = new ContaCorrente();
		Date d2 = new Date();
		conta2.setDataCriacao(d2);
		conta2.setNifNipc("12345678912");
		conta2.setNumeroConta("123456");
		
		ContaDAO repository1 = new ContaDAOImpl();
		
		repository1.create(conta1);
		repository1.create(conta2);
		
		List<ContaAbstrata> contas = repository1.readAll();
		
		
		
		//Criação de clientes
		ClienteAbstrato clienteStd1 = new ClienteStandard();
		clienteStd1.setNome("Rafael");
		clienteStd1.setId("123456789");
		clienteStd1.setMontanteDepositado(2500);
		
		ClienteAbstrato clienteStd2 = new ClienteStandard();
		clienteStd2.setNome("Antonio");
		clienteStd2.setId("987654321");
		clienteStd2.setMontanteDepositado(3500);
		
		
		
		ClienteDAO repository2 = new ClienteDAOImpl();
		
		repository2.create(clienteStd1);
		repository2.create(clienteStd2);
		
		
		List<ClienteAbstrato> cliente = repository2.readAll();
				
				
				for(ClienteAbstrato cliente1 : cliente) {
					System.out.println(cliente1.getNome());
					
				}
		
		
					//ignorar para já
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
		/*
		contas.forEach(conta ->{
			System.out.println(conta.getNumeroConta());
		});
		
		ContaDAO repository = new ContaDAOImpl();
		
		repository2.readAll().forEach(c -> {System.out.println(c.getNifNipc());});
		
		
		ContaDAO repository4 = new ContaDAOImpl();
		
		repository4.readAll().forEach(c -> {System.out.println(c.getNifNipc());});*/
	
	}
}
