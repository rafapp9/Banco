package com.banco.config;

import java.time.LocalDate;

import com.banco.controller.ClienteController;
import com.banco.model.ClienteAbstrato;
import com.banco.model.ClienteStandard;

public class ClienteConfig {

	public void start() {
		ClienteAbstrato cliente1 = new ClienteStandard("123456789", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22), 500);
		ClienteAbstrato cliente2 = new ClienteStandard("123456987", "Antonio Serra", "Homem", LocalDate.of(1996, 7, 22), 1400);
		ClienteAbstrato cliente3 = new ClienteStandard("987645367", "Angela Cunha", "Mulher", LocalDate.of(1995, 1, 30), 4000);
		ClienteAbstrato cliente4 = new ClienteStandard("261738495", "Marisa Cunha", "Mulher", LocalDate.of(2003, 8, 31), 1200);
		ClienteAbstrato cliente5 = new ClienteStandard("235654321", "Rosa Cunha", "Mulher", LocalDate.of(1976, 10, 6), 1000);
		ClienteAbstrato cliente6 = new ClienteStandard("234567543", "Miguel Cunha", "Homem", LocalDate.of(1970, 10, 12), 500);
		ClienteAbstrato cliente7 = new ClienteStandard("244564321", "Andre Galante", "Homem", LocalDate.of(2000, 1, 1), 50);
		
		ClienteController controller = new ClienteController();
		controller.create(cliente1);
		controller.create(cliente2);
		controller.create(cliente3);
		controller.create(cliente4);
		controller.create(cliente5);
		controller.create(cliente6);
		controller.create(cliente7);

	}
}
