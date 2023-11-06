package com.banco.study;

public class ExemploThread {

	public static void main(String[] args) {
		Thread fazerCafe = new Thread(() ->{
			for(int i = 0; i < 7; i++) {
				System.out.println("Fazendo cafe");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread prepararOvos = new Thread(() ->{
			for(int i = 0; i < 5; i++) {
				System.out.println("Fazendo ovos");
				try {
					Thread.sleep(800);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		fazerCafe.start();
		prepararOvos.start();
		
		try {
			prepararOvos.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		if(fazerCafe.isAlive()) {
			System.out.println("Café da manhã está pronto, mas falta o café preto!");
		}else {
			System.out.println("Café da manhã está pronto!");
		}
		
	}
}
