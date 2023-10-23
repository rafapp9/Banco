package com.banco.study;

import java.util.HashMap;
import java.util.Map;

public class ExemploHashMap {

	public static void main(String[] args) {
		Map<String, Integer> idades = new HashMap<>();
		
		idades.put("Rafael", 27);
		idades.put("Antonio", 28);
		idades.put("Rafael", 10);
		
		
		System.out.println(idades.get("Antonio"));
		
		System.out.println(idades.containsKey("Rafael"));
		
		System.out.println(idades.containsKey("Cunha"));
		
		for(int idade : idades.values()) {
			System.out.println(idade);
		}
		
		idades.forEach((key, value) ->{
			System.out.println(key);
		});
		
	}
}
