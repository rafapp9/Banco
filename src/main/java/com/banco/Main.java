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
		conta1.setId("12345678912");
		conta1.setNumeroConta("123456");
		conta1.setMontanteConta(50000);
		conta1.setMontanteMinimo(20000);
		
		ContaAbstrata conta2 = new ContaCorrente();
		Date d2 = new Date();
		conta2.setDataCriacao(d2);
		conta2.setId("12345678912");
		conta2.setNumeroConta("123456");
		conta2.setMontanteConta(200);
		conta2.setMontanteMinimo(20000);
		
		ContaDAO repository1 = new ContaDAOImpl();
		
		//automatizar este processo (pesquisar random para gerar dados automaticamente java)
		repository1.create(conta1);
		repository1.create(conta2);
		repository1.update("34562766");
		repository1.readValor(500);
		
		
		
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
				

				
						
		
			//como invocar o delete	
		//repository1.delete("123456789");
		
		
					//ignorar para já
		/*
		//for normal
		for(int i = 0; i < contas.size(); i++) {
			ContaAbstrata conta = contas.get(i);
			System.out.println(conta.getNumeroConta()); 
		}
		
		//List<ContaAbstrata> contas = repository1.readAll();
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
