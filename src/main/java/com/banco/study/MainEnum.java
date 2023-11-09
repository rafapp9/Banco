package com.banco.study;

import java.time.LocalDate;

import com.banco.model.FuncionarioAbstrato;
import com.banco.model.FuncionarioGerente;
import com.banco.repository.FuncionarioDAO;
import com.banco.repository.impl.FuncionarioDAOImpl;

public class MainEnum {

	public static void main(String[] args) {
		FuncionarioAbstrato funcionario1 = new FuncionarioGerente("12356", "Rafael " + EnumTeste.APELIDO.getName(), "Homem", LocalDate.of(1996, 7, 22), 250);
		FuncionarioAbstrato funcionario2 = new FuncionarioGerente("456789", "Antonio " + EnumTeste.APELIDO.getName(), "Homem", LocalDate.of(1995, 1, 1), 250);

		FuncionarioDAO repository1 = new FuncionarioDAOImpl();

		repository1.create(funcionario2);
		
		FuncionarioAbstrato func = repository1.read("456789");
		System.out.println(func.getNome());
		
	}

}
