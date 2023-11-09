package com.banco;

import java.time.LocalDate;
import java.util.List;

import com.banco.model.ClienteAbstrato;
import com.banco.model.ClienteStandard;
import com.banco.model.FuncionarioAbstrato;
import com.banco.model.FuncionarioGerente;
import com.banco.repository.FuncionarioDAO;
import com.banco.repository.impl.FuncionarioDAOImpl;

public class MainFuncionario {

	public static void main(String[] args) {

		
		FuncionarioAbstrato funcionario1 = new FuncionarioGerente("123456789", "Rafael Cunha", "Homem", LocalDate.of(1996, 7, 22), 500);
		FuncionarioAbstrato funcionario2 = new FuncionarioGerente("123456987", "Antonio Serra", "Homem", LocalDate.of(1996, 7, 22), 1400);
		FuncionarioAbstrato funcionario3 = new FuncionarioGerente("987645367", "Angela Cunha", "Mulher", LocalDate.of(1995, 1, 30), 4000);
		FuncionarioAbstrato funcionario4 = new FuncionarioGerente("261738495", "Marisa Cunha", "Mulher", LocalDate.of(2003, 8, 31), 1200);
		FuncionarioAbstrato funcionario5 = new FuncionarioGerente("235654321", "Rosa Cunha", "Mulher", LocalDate.of(1976, 10, 6), 1000);
		FuncionarioAbstrato funcionario6 = new FuncionarioGerente("234567543", "Miguel Cunha", "Homem", LocalDate.of(1970, 10, 12), 500);
		FuncionarioAbstrato funcionario7 = new FuncionarioGerente("244564321", "Andre Galante", "Homem", LocalDate.of(2000, 1, 1), 50);

		FuncionarioDAO repository1 = new FuncionarioDAOImpl();

		repository1.create(funcionario1);
		repository1.create(funcionario2);
		repository1.create(funcionario3);
		repository1.create(funcionario4);
		repository1.create(funcionario5);
		repository1.create(funcionario6);
		
		//binarySearch
		FuncionarioAbstrato antonio = repository1.read("654321");
		System.out.println(antonio.getNome());
		
		
		
		
		
		List<FuncionarioAbstrato> listaFuncionarios = repository1.readAll();
		//ordenação por nif
		/* for (FuncionarioAbstrato funcionario : listaFuncionarios) {
			System.out.println(funcionario.getId() + " - " + funcionario.getNome());
		

		}
		 */
	}

}
