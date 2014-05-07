package com.Methods;
import java.util.Scanner;
import com.Methods.Array;


public class KeyboardInput implements Input{
	
	private static final char SHIP_CHAR = 'o';
	
	//Override
	public int inputInt(){
		//System.out.print("Input number: ");
		Scanner sc = new Scanner (System.in);
		int number = sc.nextInt();
		System.out.print(number);
		return number;
	}
	
	public char[][] menuHorizontalVertical(char[][] array, int SHIP_LENGTH, int y, int x) {
		System.out.println("1. Horizontal\n2. Vertical\n3. Exit\n\nEnter number: ");
		int keyboardNum = inputInt();
		boolean menuID = false;
		char[][] newArray = new char[array.length][array.length];
		do {
			switch(keyboardNum) {
				case 1: 
					System.out.println("CASE 1");
					newArray = insertInArray(array, SHIP_LENGTH, y, x);
					menuID = true;
					return newArray;
				case 2:	
					newArray = insertVertical(array, SHIP_LENGTH, y, x);
					menuID = true;
					return newArray;
						
				case 3: 
					menuID = true;
					return array;
				
				default: System.out.println("ERROR CODE\n\n Enter number: ");
			}
			keyboardNum = inputInt();
		} while(menuID != true);
		return array;
	}
//	
	public char[][] insertInArray(char[][] array, int SHIP_LENGTH, int y, int x) { //закрыть, возвращает отредактированный массив, если ок и клон если не ок
		if ((x > -1) && (y > -1) && (x < array.length) && (y < array.length)) {
			char[][] arrayClone = new char[array.length][array.length];
			arrayClone = array;
			if (arrayTest(array[y], x, SHIP_LENGTH) == true) {
				//System.out.println("Joy and fun");
				for (int i = x; i < SHIP_LENGTH + 1; i++) { //+1 потому что несоотвествие между массивом и длиной
					arrayClone[y][i] = SHIP_CHAR;
				}
				return arrayClone;
			}
			else {
				//System.out.println("Death and rebirth");
				return array;
			}
		}
		else return array;
		
		
	}
	
	public char[][] insertVertical(char[][] array, int SHIP_LENGTH, int y, int x) {
		char[][] cloneArray = new char[array.length][array.length];
		cloneArray = Array.transpose(array);
		this.insertInArray(cloneArray, SHIP_LENGTH, y, x);
		cloneArray = Array.transpose(cloneArray);
		return cloneArray;
	}
	
	private boolean arrayTestCopy(char[] array, int SHIP_SIZE, int x, char CHARACTER) {
		
		//boolean indicator = false;
		
		for (int i = x; i < x + SHIP_SIZE - 1; i++) {
			if (array[i] == CHARACTER) {
				System.out.println("IN");
				return false;
			}
		}
		return true;
	}
	
	
	private boolean arrayTest(char[] array, int x, int SHIP_LENGTH) { //закрыть
		if (this.arrayTestCopy(array, SHIP_LENGTH, x, SHIP_CHAR)&&((x + SHIP_LENGTH - 1) < array.length) && (x>-1)) return true; //-1 потому что смещение на одну клетку (SHIP_LENGHT больше на единицу длины массива)
		else return false;
	}
	
	
	
}
