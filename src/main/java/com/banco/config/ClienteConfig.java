package com.banco.config;

import com.banco.controller.ClienteController;
import com.banco.model.ClienteAbstrato;
import com.banco.model.ClienteStandard;

public class ClienteConfig {

	public void start() {
		ClienteAbstrato cliente1 = new ClienteStandard("123456789", "Rafael Cunha", 500);
		ClienteAbstrato cliente2 = new ClienteStandard("123456987", "Antonio Serra", 500);
		ClienteAbstrato cliente3 = new ClienteStandard("987645367", "Angela Cunha", 500);
		ClienteAbstrato cliente4 = new ClienteStandard("261738495", "Marisa Cunha", 500);
		ClienteAbstrato cliente5 = new ClienteStandard("235654321", "Rosa Cunha", 500);
		ClienteAbstrato cliente6 = new ClienteStandard("234567543", "Miguel Cunha", 500);
		ClienteAbstrato cliente7 = new ClienteStandard("244564321", "Andre Galante", 500);
		
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
