package com.banco.study;

public enum EnumTeste {

	APELIDO("SERRA");
	
	private String name;

	EnumTeste(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
