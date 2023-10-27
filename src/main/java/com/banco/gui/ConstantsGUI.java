package com.banco.gui;

public enum ConstantsGUI {

	MENU("1. Menu Contas\n2. Menu Clientes\n3. Menu Funcionarios"),
	SUBMENU_CONTAS("1 - Criar Conta\n2 - Pesquisar todas as Contas\n3 - Pesquisar uma conta\n4 - Atualizar uma Conta\n5 - Remover uma Conta\""),
	SUBMENU_CLIENTES("1 - Criar Cliente\n2 - Pesquisar todos os Clientes");
	
	private String value;
	
	private ConstantsGUI(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}	
	
}
