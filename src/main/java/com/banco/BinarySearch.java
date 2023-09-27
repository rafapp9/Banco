package com.banco;

public class BinarySearch {
	
	private static int normalLoop = 0;
	private static int binaryLoop = 0;

	public static void main(String[] args) {
		int[] teste = { 2, 10, 20, 45, 53, 90, 240, 300 };
		
		int target = 300;
		
		normalSearch(target, teste);
		System.out.println("Normal Loop: " + normalLoop);
		
		binarySearch(target, teste);
		System.out.println("Binary Loop: " + binaryLoop);
		
	}
	
	private static void normalSearch(int target, int[] array) {
		System.out.println("Normal Search");
		for(int i = 0; i < array.length; i++) {
			normalLoop++;
			int value = array[i];
			if(value == target) {
				System.out.println("Index: " + i);
				break;
			}
		}
	}
	
	private static void binarySearch(int target, int[] array) {
		
		int left = 0;
		int rigth = array.length - 1;
		
		while(left <= rigth) {
			binaryLoop++;
			
			int midle = (rigth - left) / 2;
			
			if(array[midle] == target) {
				System.out.println("Index: " + midle);
				break;
			}else if(array[midle] < target) {
				left = midle - left;
			}else if(array[midle] > target) {
				rigth = midle - rigth;
			}
		}
	
	}

}
