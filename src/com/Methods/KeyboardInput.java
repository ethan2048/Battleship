package com.Methods;
import java.util.Scanner;

public class KeyboardInput implements Input{
	
	//Override
	public int inputInt(){
		System.out.print("Input number: ");
		Scanner sc = new Scanner (System.in);
		int number = sc.nextInt();
		System.out.print(number);
		return number;
	}
	
//	public 
//	
//	public void menuHorizontalVertical() {
//		System.out.println("1. Horizontal\n2. Vertical\n3. Exit\n\nEnter number: ");
//		int keyboardNum = inputInt();
//		boolean menuID = false;
//		while(menuID){
//			switch(keyboardNum){
//		
//				case 1: 
//				
//				case 2:
//			
//				case 3: break;
//				case default: return 0;
//			}
//	}
//	
	public boolean insertInArray(char[][] array, int SHIP_LENGHT, int y, int x, int ARRAY_LENGHT) { //закрыть, возможно сделать булевым
		if (arrayTest(array[y], x, ARRAY_LENGHT, SHIP_LENGHT) == true) {
			for (int i = x; i < SHIP_LENGHT; i++) {
				array[y][i] = 'X';
			}
			return true;
		}
		else return false;
	}
	
	
	public boolean arrayTest(char[] array, int x, int ARRAY_LENGHT, int SHIP_LENGHT){ //закрыть
		if (((x + SHIP_LENGHT - 1) < ARRAY_LENGHT) && (x>-1)) return true; //-1 потому что смещение на одну клетку (SHIP_LENGHT больше на единицу длины массива)
		else return false;
	}
	
	
	
}
