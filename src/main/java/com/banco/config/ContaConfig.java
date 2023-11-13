package com.banco.config;

import com.banco.controller.ContaController;
import com.banco.model.ContaDTO;

public class ContaConfig {

	public static void start() {
		
	
		ContaDTO conta1 = new ContaDTO("917263616", "321654", 500);
		ContaDTO conta2 = new ContaDTO("917263616", "123321", 500);
		ContaDTO conta3 = new ContaDTO("982154567", "123856", 1000);
		ContaDTO conta4 = new ContaDTO("221454321", "123456", 15000);
		ContaDTO conta5 = new ContaDTO("254264321", "748318", 1600);
		
		
		ContaController controller = new ContaController();
		
		controller.create(conta1);
		controller.create(conta2);
		controller.create(conta3);
		controller.create(conta4);
		controller.create(conta5);
		
	}
	
}
