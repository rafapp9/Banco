package com.banco.config;

import java.util.Date;

import com.banco.controller.FuncionarioController;
import com.banco.model.FuncionarioAbstrato;
import com.banco.model.FuncionarioGerente;

public class FuncionarioConfig {

	public static void start() {
		
		FuncionarioAbstrato funcionario1 = new FuncionarioGerente("123456789", "Rafael Cunha", 200);
		FuncionarioAbstrato funcionario2 = new FuncionarioGerente("234567543", "Miguel Cunha", 300);
		FuncionarioAbstrato funcionario3 = new FuncionarioGerente("244564321", "André Galante", 100);
		
		FuncionarioController controller = new FuncionarioController();
		
		controller.create(funcionario1);
		controller.create(funcionario2);
		controller.create(funcionario3);
		
	}
	
}
