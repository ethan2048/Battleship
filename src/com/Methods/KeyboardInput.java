package com.Methods;
import java.util.Scanner;
import com.Methods.Array;


public class KeyboardInput implements IFInput{
	
	private static final char SHIP_CHAR = 'o';
	private static final int ONE_DECK = 1, TWO_DECK = 2, THREE_DECK = 3, FOUR_DECK = 4; 
	private static final int ONE_DECK_COUNT = 4, TWO_DECK_COUNT = 3, THREE_DECK_COUNT = 2, FOUR_DECK_COUNT = 1;
	private char[][] сloneArray;
	//Override
	public int inputInt(){
		//System.out.print("Input number: ");
		Scanner sc = new Scanner (System.in);
		int number = sc.nextInt();
		System.out.print(number);
		return number;
	}
	
	public char[][] menuHorizontalVertical(char[][] array, int SHIP_LENGTH, int y, int x) { //важная менюшка для размещения корабликов
		System.out.println("1. Horizontal\n2. Vertical\n3. Exit\n\nEnter number: ");
		int keyboardNum = inputInt();
		boolean menuID = false;
		char[][] newArray = new char[array.length][array.length];
		do {
			switch(keyboardNum) {
				case 1: 
					System.out.println("CASE 1");
					newArray = insertHorizontal(array, SHIP_LENGTH, y, x);
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

	private char[][] insertHorizontal(char[][] array, int SHIP_LENGTH, int y, int x) { //возвращает отредактированный массив, если ок и клон если не ок
		if ((x > -1) && (y > -1) && (x < array.length) && (y < array.length)) {
			char[][] arrayClone = new char[array.length][array.length];
			arrayClone = array;
			if (arrayTest(array[y], x, SHIP_LENGTH) == true) {
				System.out.println("Im inside");
				for (int i = x, j = 0; j < SHIP_LENGTH ; i++, j++) {
					arrayClone[y][i] = SHIP_CHAR;
				}
				return arrayClone;
			}
			else {
				return array;
			}
		}
		else return array;
	}
	
	public char[][] insertVertical(char[][] array, int SHIP_LENGTH, int y, int x) { 
		char[][] cloneArray = new char[array.length][array.length];
		cloneArray = Array.transpose(array);
		this.insertHorizontal(cloneArray, SHIP_LENGTH, x, y);
		cloneArray = Array.transpose(cloneArray);
		return cloneArray;
	}
	
	private boolean arrayTestCopy(char[] array, int SHIP_SIZE, int x, char CHARACTER) { //проверка на существующие кораблики
		for (int i = x; i < x + SHIP_SIZE - 1; i++) {
			if (array[i] == CHARACTER) {
				System.out.println("IN");
				return false;
			}
		}
		return true;
	}

	private boolean arrayTest(char[] array, int x, int SHIP_LENGTH) { //общая проверка на возможность поставить кораблик
		if (this.arrayTestCopy(array, SHIP_LENGTH, x, SHIP_CHAR)&&((x + SHIP_LENGTH - 1) < array.length) && (x>-1)) return true; //-1 потому что смещение на одну клетку (SHIP_LENGHT больше на единицу длины массива)
		else return false;
	}
	
	private int messageInsert(char coordinate) {
		System.out.println("Enter your " + coordinate + " coordinate code: ");
		return this.inputInt();
	}
	
	public char[][] shipMenu(char[][] array, int oneDeck, int twoDeck, int threeDeck, int fourDeck) {
		System.out.println("1. insert one decker, "+ oneDeck + "\n2. insert two decker, " + twoDeck + "\n3. insert three, " + threeDeck + "\n4. insert fourDeck, " + fourDeck + "\n5. Exit");
		int count = oneDeck + twoDeck + threeDeck + fourDeck;
		char[][] cloneArray = new char[array.length][array.length];
		cloneArray = array;
		boolean indent = false;
		int id = this.inputInt();
		do {
			switch (id) {
				case 1:
					if (oneDeck > 0) {
						//oneDeck--;
						cloneArray = this.insertHorizontal(cloneArray, ONE_DECK, this.messageInsert('y'), this.messageInsert('x'));
						//сравненить два массива (один до вызова менюшки, другой после). если равны, то не удалять каунт.
						Array.view(cloneArray);
						break;
					} else {
						System.out.println("There is no one decker!");
						break;
					}
				case 2:
					if (twoDeck > 0) {
						twoDeck--;
						cloneArray = this.menuHorizontalVertical(cloneArray, TWO_DECK, this.messageInsert('y'), this.messageInsert('x'));
						Array.view(cloneArray);
						break;
					} else {
						System.out.println("There is no two decker!");
						break;
					}
				case 3:
					if (threeDeck > 0) {
						threeDeck--;
						cloneArray = this.menuHorizontalVertical(cloneArray, THREE_DECK, this.messageInsert('y'), this.messageInsert('x'));
						Array.view(cloneArray);
						break;
					} else {
						System.out.println("There is no three decker!");
						return array;
					}
				case 4:
					if (fourDeck > 0) {
						fourDeck--;
						cloneArray = this.menuHorizontalVertical(cloneArray, FOUR_DECK, this.messageInsert('y'), this.messageInsert('x'));
						Array.view(cloneArray);
						break;
					} else {
						System.out.println("There is no four decker!");
						break;
					}
				
				case 5: 
					return cloneArray;
				
				default: 
					return array;
			}
			System.out.println("1. insert one decker, "+ oneDeck + "\n2. insert two decker, " + twoDeck + "\n3. insert three, " + threeDeck + "\n4. insert fourDeck, " + fourDeck + "\n5. Exit");
			id = inputInt();
		} while (count != 0);
		return cloneArray;
	}

	
	
}
