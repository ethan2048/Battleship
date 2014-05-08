package com.Main;

import com.Methods.*;
import com.battleship.Field;



public class Main {
	
	
	public static void main(String[] args) {
		int LENGHT = 20;
		char ch = ' ';
		int oneDeck = 4, twoDeck = 3, threeDeck = 2, fourDeck = 1; 
		final int ONE_DECK_COUNT = 4, TWO_DECK_COUNT = 3, THREE_DECK_COUNT = 2, FOUR_DECK_COUNT = 1;
		
		IFInput key = new KeyboardInput();
		Field bfield = new Field(LENGHT);
		//bfield.setFieldCell(y, x, 'C');
		bfield.view();
		System.out.println();
		System.out.println();
		bfield.setField(key.shipMenu(bfield.getField(), ONE_DECK_COUNT, TWO_DECK_COUNT, THREE_DECK_COUNT, FOUR_DECK_COUNT));
		
		System.out.println("one decker count is: " + oneDeck);
		System.out.println();
		bfield.view();
	}

}
