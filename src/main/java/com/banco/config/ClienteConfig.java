package com.banco.config;

import java.time.LocalDate;

import com.banco.controller.ClienteController;
import com.banco.model.ClienteAbstrato;
import com.banco.model.ClienteStandard;

public class ClienteConfig {

	public void start() {
		ClienteAbstrato cliente3 = new ClienteStandard("917263616", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22), 500);
		ClienteAbstrato cliente4 = new ClienteStandard("125439218", "Antonio Serra", "Homem", LocalDate.of(1996, 7, 22), 1400);
		ClienteAbstrato cliente5 = new ClienteStandard("982154567", "Angela Cunha", "Mulher", LocalDate.of(1995, 1, 30), 4000);
		ClienteAbstrato cliente6 = new ClienteStandard("261732195", "Marisa Cunha", "Mulher", LocalDate.of(2003, 8, 31), 1200);
		ClienteAbstrato cliente7 = new ClienteStandard("221454321", "Rosa Cunha", "Mulher", LocalDate.of(1976, 10, 6), 1000);
		ClienteAbstrato cliente8 = new ClienteStandard("234556743", "Miguel Cunha", "Homem", LocalDate.of(1970, 10, 12), 500);
		ClienteAbstrato cliente9 = new ClienteStandard("254264321", "Andre Galante", "Homem", LocalDate.of(2000, 1, 1), 50);
		
		ClienteController controller = new ClienteController();
		controller.create(cliente3);
		controller.create(cliente4);
		controller.create(cliente5);
		controller.create(cliente6);
		controller.create(cliente7);
		controller.create(cliente8);
		controller.create(cliente9);

	}
}
