package com.banco;

import java.util.List;

import com.banco.model.FuncionarioAbstrato;
import com.banco.model.FuncionarioGerente;
import com.banco.repository.FuncionarioDAO;
import com.banco.repository.impl.FuncionarioDAOImpl;

public class MainFuncionario {

	public static void main(String[] args) {

		FuncionarioAbstrato funcionario1 = new FuncionarioGerente("12356", "Rafael", 250);
		FuncionarioAbstrato funcionario2 = new FuncionarioGerente("654321", "Antonio", 250);
		FuncionarioAbstrato funcionario3 = new FuncionarioGerente("234567", "Ângela", 250);
		FuncionarioAbstrato funcionario4 = new FuncionarioGerente("568533", "Marisa", 250);
		FuncionarioAbstrato funcionario5 = new FuncionarioGerente("145656", "Rosa", 250);
		FuncionarioAbstrato funcionario6 = new FuncionarioGerente("354353", "Miguel", 250);

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
