package com.banco.model;

public abstract class ClienteAbstrato {
	
	private String nomeCliente;
	private int montanteDepositado;
	private String nifNipc;

	
	
	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getMontanteDepositado() {
		return montanteDepositado;
	}

	public void setMontanteDepositado(int montanteDepositado) {
		this.montanteDepositado = montanteDepositado;
	}

	
	public String getNifNipc() {
		return nifNipc;
	}

	public void setNifNipc(String nifNipc) {
		this.nifNipc = nifNipc;
	}

	@Override
	public String toString() {
		return "ClienteAbstrato [nifNipc=" + nifNipc + ", nomeCliente=" + nomeCliente + ", montanteDepositado=" + montanteDepositado
				+ "]";
		
	}

}
