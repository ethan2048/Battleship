package com.Methods;

public class Array {
	
	private static final char CHARACTER = 'o'; //заполнитель клеток
	
	public static char getCharacter() {
		return CHARACTER;
	}

	public static void view(char[][] array){
		for (int i = 0; i < array.length; i++) {
			viewCharArray(array[i]);
		}
	}
	public static void viewCharArray(char[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print("[" + array[i] + "]");
		}
		System.out.println();
	}
	
	public static void fillCharArray(char[] array, int LINE_SIZE) {
		for (int i = 0; i < LINE_SIZE; i++) {
			array[i] = CHARACTER;
		}
	}
	
	public static char[][] transpose(char[][] field){
		char[][] cloneField = new char[field.length][field.length];
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field.length; j++) {
				cloneField[i][j] = field[j][i];
			}
		}
		return cloneField;
	}
	
	
}
