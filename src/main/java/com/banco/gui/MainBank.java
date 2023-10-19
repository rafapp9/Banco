package com.banco.gui;

import java.util.Date;
import java.util.Scanner;

import com.banco.config.ContaConfig;
import com.banco.controller.ContaController;
import com.banco.model.ContaAbstrata;
import com.banco.model.ContaCorrente;

public class MainBank {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int option = 0;
		
		ContaConfig.start();
		
		ContaController contaController = new ContaController();
		
		while (option != 99) {
			
			System.out.println("1 - Criar Conta\n2 - Pesquisar todas as Contas");
			option = scan.nextInt();
			
			if(option == 1) {
				ContaAbstrata conta = new ContaCorrente();
				Date d1 = new Date();
				conta.setDataCriacao(d1);
				System.out.println("Digite o NIF do cliente:");
				String id = scan.next();
				conta.setId(id);
				System.out.println("Digite o número da conta:");
				String nConta = scan.next();
				conta.setNumeroConta(nConta);
				contaController.create(conta);
				System.out.println("Conta Criada com sucesso.\n");
			}else if(option == 2) {
				contaController.readAll().forEach(c ->{
					System.out.println(c.toString());
				});
			}else if(option == 99){
				System.out.println("Programa Finalizado!!!");
				break;
			}else {
				System.out.println("Opção Inválida!");
			}
			
		}
	}
}
