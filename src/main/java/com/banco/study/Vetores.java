package com.banco.study;

import java.time.LocalDate;

import com.banco.model.FuncionarioAbstrato;
import com.banco.model.FuncionarioGerente;
import com.banco.repository.FuncionarioDAO;
import com.banco.repository.impl.FuncionarioDAOImpl;

public class Vetores {

	public static void main(String[] args) {
		FuncionarioAbstrato f1 = new FuncionarioGerente("123456781", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22), 100);
		FuncionarioAbstrato f2 = new FuncionarioGerente("234567543", "Miguel Cunha", "Homem", LocalDate.of(1970, 10, 12), 500);
		FuncionarioAbstrato f3 = new FuncionarioGerente("234567543", "André Galante", "Homem", LocalDate.of(2000, 1, 1), 500);

		FuncionarioDAO repository = new FuncionarioDAOImpl();

		repository.create(f1);
		repository.create(f2);
		repository.create(f3);

		FuncionarioAbstrato fUpdate = new FuncionarioGerente("123456781", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22), 700);

		repository.update("123456789", fUpdate);
		
		repository.updateName("789456123", "Antonio Serra");

		repository.readAll().forEach(f -> {
			FuncionarioGerente gerente = (FuncionarioGerente) f;
			System.out.print(f.getNome());
			System.out.println(" " + gerente.getVendaMensal());
		});

		repository.delete("789456123");
	}

}
