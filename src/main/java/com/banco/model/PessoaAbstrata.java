package com.banco.model;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public abstract class PessoaAbstrata {

	private String nome;
	private String id;
	private String sexo;
	private LocalDate dataNascimento;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(int ano, int mes, int dia) {
		this.dataNascimento = LocalDate.of(ano, mes, dia);
	}
	
	   public int calculateAge() {
	        LocalDate today = LocalDate.now();
	        return Period.between(dataNascimento, today).getYears();
	    }

}
