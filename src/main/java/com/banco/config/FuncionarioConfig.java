package com.banco.config;

import java.time.LocalDate;
import java.util.Date;

import com.banco.controller.FuncionarioController;
import com.banco.model.FuncionarioAbstrato;
import com.banco.model.FuncionarioGerente;

public class FuncionarioConfig {

	public static void start() {
		
		FuncionarioAbstrato funcionario1 = new FuncionarioGerente("467839276", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22), 100);
		FuncionarioAbstrato funcionario2 = new FuncionarioGerente("849362718", "Miguel Cunha", "Homem", LocalDate.of(1970, 10, 12), 500);
		FuncionarioAbstrato funcionario3 = new FuncionarioGerente("937251678", "Andre Galante", "Homem", LocalDate.of(2000, 1, 1), 50);
		
		FuncionarioController controller = new FuncionarioController();
		
		controller.create(funcionario1);
		controller.create(funcionario2);
		controller.create(funcionario3);
		
	}
	
}
