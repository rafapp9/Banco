package com.banco;

import java.util.Date;
import java.util.List;

import com.banco.controller.ContaController;
import com.banco.model.ContaAbstrata;
import com.banco.model.ContaCorrente;
import com.banco.model.ContaDTO;
import com.banco.repository.ContaDAO;

public class MainConta {

	public static void main(String[] args) {

		ContaDTO conta1 = new ContaDTO("12345", "12345", 500);
		ContaDTO conta2 = new ContaDTO("123456789", "54321", 1500);

		ContaController controller = new ContaController();

		controller.create(conta1);
		controller.create(conta2);

		List<ContaAbstrata> readConta = controller.readAll();
		for (ContaAbstrata conta : readConta) {
			System.out.println(conta.getId() + " - " + conta.getMontanteConta());
		}

	}

}
