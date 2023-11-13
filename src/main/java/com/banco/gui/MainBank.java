package com.banco.gui;

import java.util.Scanner;

import com.banco.config.ClienteConfig;
import com.banco.config.ContaConfig;
import com.banco.controller.ContaController;
import com.banco.model.ContaDTO;

public class MainBank {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int option = 0;

		ClienteConfig.start();
		ContaConfig.start();

		while (option != 99) {
			System.out.println(ConstantsGUI.MENU.getValue());
			option = scan.nextInt();
			if(option == 1) {
				menuContas(scan);
			}else if(option == 2) {
				menuClientes(scan);	
			}
		}
		System.out.println("Programa Finalizado!");
	}
	
	private static void menuClientes(Scanner scan) {
		ContaController contas = new ContaController();
		System.out.println(ConstantsGUI.SUBMENU_CLIENTES.getValue());
		int option = scan.nextInt();
		if(option == 3) {
			System.out.println("Digite o NIF para pesquisa de contas:");
			String nif = scan.next();
			System.out.println("=====================");
			contas.filterByNIF(nif).forEach(c -> {System.out.println("\nNúmero Conta: " + c.getNumeroConta() + " -- Montante:" + c.getMontanteConta());});
			System.out.println("=====================");
		}
		
	}
	
	private static void menuContas(Scanner scan) {
		ContaController contaController = new ContaController();
		System.out.println(ConstantsGUI.SUBMENU_CONTAS.getValue());
		int option = scan.nextInt();
		if (option == 1) {
			System.out.println("Montante a depositar:");
			double montanteDepositado = scan.nextDouble();
			System.out.println("Digite o NIF do cliente:");
			String id = scan.next();
			System.out.println("Digite o número da conta:");
			String nConta = scan.next();
			ContaDTO conta = new ContaDTO(id, nConta, montanteDepositado);
			contaController.create(conta);
			
		} else if (option == 2) {
			contaController.readAll().forEach(c -> {
				System.out.println(c.getTpConta());
				System.out.println(c.toString());
			});
		} else {
			System.out.println("Opção Inválida!");
		}
	}
}
