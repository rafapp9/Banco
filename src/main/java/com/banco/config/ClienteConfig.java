package com.banco.config;

import com.banco.controller.ClienteController;
import com.banco.model.ClienteAbstrato;
import com.banco.model.ClienteStandard;

public class ClienteConfig {

	public void start() {
		ClienteAbstrato cliente1 = new ClienteStandard("123456789", "Rafael Cunha", 500);
		ClienteAbstrato cliente2 = new ClienteStandard("123456987", "Antonio Serra", 500);
		
		ClienteController controller = new ClienteController();
		controller.create(cliente1);
		controller.create(cliente2);
	}
}
