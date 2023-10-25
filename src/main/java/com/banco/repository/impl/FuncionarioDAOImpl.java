package com.banco.repository.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.banco.model.FuncionarioAbstrato;
import com.banco.repository.FuncionarioDAO;

public class FuncionarioDAOImpl implements FuncionarioDAO {

	// array de funcionarios
	private static FuncionarioAbstrato[] dataBase = new FuncionarioAbstrato[10];
	private int index = 0;

	@Override
	public void create(FuncionarioAbstrato obj) {
		dataBase[index] = obj;
		index++;
		bubbleSort();

	}

	private void bubbleSort() {

		FuncionarioAbstrato aux = null;
		int i = 0;

		for (i = 0; i < this.index; i++) {
			for (int j = 0; j < this.index - 1; j++) {
				int idj = Integer.parseInt(dataBase[j].getId());
				int idj1 = Integer.parseInt(dataBase[j + 1].getId());
				if (idj > idj1) {
					aux = dataBase[j];
					dataBase[j] = dataBase[j + 1];
					dataBase[j + 1] = aux;
				}
			}
		}

	}

	@Override
	public List<FuncionarioAbstrato> readAll() {
		List<FuncionarioAbstrato> listFunc = new ArrayList<>();
		for (int i = 0; i < index; i++) {
			listFunc.add(dataBase[i]);
		}
		return listFunc;
	}

	@Override
	public FuncionarioAbstrato update(String id, FuncionarioAbstrato obj) {
		int index = this.readIndex(id);
		dataBase[index] = obj;
		return obj;
	}

	@Override
	// ajustar array para os preenchidos ficarem nos primeiros index
	public void delete(String id) {
		int index = this.readIndex(id);
		dataBase[index] = dataBase[this.index - 1];
		dataBase[this.index - 1] = null;

		this.index--;

	}

	@Override
	// alterar para binary search
	public FuncionarioAbstrato read(String id) {
		return binarySearch(Integer.parseInt(id), dataBase);
		
	
	}
	
	private FuncionarioAbstrato binarySearch(int target, FuncionarioAbstrato[] array) {
		
		int left = 0;
		int rigth = this.index - 1;
		
		while(left <= rigth) {
			
			int midle = (rigth + left) / 2;
			
			if(Integer.parseInt(array[midle].getId()) == target) {
				System.out.println("Index: " + midle);
				return array[midle];
			}else if(Integer.parseInt(array[midle].getId()) < target) {
				left = midle + 1;
			}else if(Integer.parseInt(array[midle].getId()) > target) {
				rigth = midle - 1;
			}
		}
		return null;
	}


	@Override
	public int readIndex(String id) {
		// loop no database
		for (int i = 0; i < dataBase.length; i++) {
			FuncionarioAbstrato func = dataBase[i];
			if (func.getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public FuncionarioAbstrato updateName(String id, String name) {
		int ind = readIndex(id);
		dataBase[ind].setNome(name);
		return dataBase[ind];
	}



}
