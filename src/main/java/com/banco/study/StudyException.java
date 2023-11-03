package com.banco.study;

import com.banco.controller.ContaController;
import com.banco.exceptions.ContaValidateException;
import com.banco.model.ContaDTO;

public class StudyException {

	public static void main(String[] args) {
		ContaDTO conta1 = new ContaDTO("123456789", "123456", 50);
		
		ContaController controller = new ContaController();
		try {
			controller.create(conta1);
		} catch (ContaValidateException e) {
			System.out.println("Algum valor da conta está incorreto!");
		} catch (Exception e) {
			System.out.println("Entrou no exception!");
		} finally {
			System.out.println("fim");
		}
		
		
		
	}
}
