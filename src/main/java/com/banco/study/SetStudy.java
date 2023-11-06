package com.banco.study;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

public class SetStudy {

	public static void main(String[] args) {
		List<String> nomesList = new ArrayList<>();
		nomesList.add("rafael");
		nomesList.add("rafael");
		nomesList.add("rafael");
		nomesList.add("antonio");

		System.out.println("============LIST===============");
		nomesList.forEach(n -> {
			System.out.println(n);
		});
		System.out.println("============LIST===============");

		Set<String> nomesSet = new HashSet<>();
		nomesSet.addAll(nomesList);

		Iterator<String> nomeIt = nomesSet.iterator();

		while (nomeIt.hasNext()) {
			System.out.println(nomeIt.next());
		}

		System.out.println("============String Joiner===============");
		StringJoiner sj = new StringJoiner(", ");
		nomesList.forEach(n -> {
			sj.add(n);
		});
		System.out.println(sj.toString() + ".");

		System.out.println("============String Joiner===============");

	}
}
