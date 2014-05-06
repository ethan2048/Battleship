package com.Main;

import com.Methods.*;
import com.battleship.Field;



public class Main {
	
	
	public static void main(String[] args) {
		int LENGHT = 6;
		int SHIP_LENGHT = 3;
		int y = 4;
		int x = 1;
		
		Input key = new KeyboardInput();
		Field bfield = new Field(LENGHT);
		bfield.setFieldCell(y, x, 'C');
		bfield.fieldView();
		System.out.println();
		//KeyboardInput kb = new KeyboardInput();
		bfield.setField(key.insertInArray(bfield.getField(), SHIP_LENGHT, y, x, LENGHT)); //адовая строчка, которая возвращает отредактированный массив в замену
		bfield.fieldView();
		
		
		
	}

}
