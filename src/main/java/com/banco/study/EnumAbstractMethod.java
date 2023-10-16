package com.banco.study;

import com.banco.model.ContaAbstrata;
import com.banco.model.ContaCorrente;
import com.banco.model.ContaPoupanca;
import com.banco.model.ContaPremium;

public enum EnumAbstractMethod {

	CORRENTE() {
		@Override
		public ContaAbstrata typeAccount() {
			return new ContaCorrente();
		}
	},
	POUPANCA() {
		@Override
		public ContaAbstrata typeAccount() {
			return new ContaPoupanca();
		}
	},
	PREMIUM(){
		@Override
		public ContaAbstrata typeAccount() {
			return new ContaPremium();
		}
	};
	
	public abstract ContaAbstrata typeAccount();
	
}
