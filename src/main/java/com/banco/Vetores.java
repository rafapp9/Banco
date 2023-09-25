package com.banco;

import com.banco.model.FuncionarioAbstrato;
import com.banco.model.FuncionarioGerente;
import com.banco.repository.FuncionarioDAO;
import com.banco.repository.impl.FuncionarioDAOImpl;

public class Vetores {

	public static void main(String[] args) {
		FuncionarioAbstrato f1 = new FuncionarioGerente("123456789", "Rafael", 500);
		FuncionarioAbstrato f2 = new FuncionarioGerente("789456123", "Antonio", 300);
		
		FuncionarioDAO repository = new FuncionarioDAOImpl();
		
		repository.create(f1);
		repository.create(f2);
		
		repository.readAll().forEach(f ->{
			FuncionarioGerente gerente = (FuncionarioGerente) f;
			System.out.print(f.getNome());
			System.out.println(" " + gerente.getVendaMensal());
		});

	}

}
