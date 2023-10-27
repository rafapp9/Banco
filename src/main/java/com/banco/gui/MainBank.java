package com.banco.gui;

import java.util.Scanner;

import com.banco.config.ContaConfig;
import com.banco.controller.ContaController;
import com.banco.model.ContaDTO;

public class MainBank {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int option = 0;

		ContaConfig.start();

		ContaController contaController = new ContaController();

		while (option != 99) {

			System.out.println(ConstantsGUI.MENU_CONTAS.getValue());
			System.out.println(ConstantsGUI.MENU_CLIENTES.getValue());
			option = scan.nextInt();

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
			} else if (option == 99) {
				System.out.println("Programa Finalizado!!!");
				break;
			} else {
				System.out.println("Opção Inválida!");
			}

		}
	}
}
