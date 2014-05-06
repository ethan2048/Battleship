package com.Main;

import com.Methods.*;
import com.battleship.Field;



public class Main {
	
	
	public static void main(String[] args) {
		int LENGHT = 6;
		int SHIP_LENGHT = 6;
		int y = 0;
		int x = 1;
		
		
		Field bfield = new Field(LENGHT);
		bfield.setFieldCell(y, x, 'C');
		bfield.fieldView();
		KeyboardInput kb = new KeyboardInput();
		bfield.setField(kb.insertInArray(bfield.getField(), SHIP_LENGHT, y, x, LENGHT)); //адовая строчка, которая возвращает отредактированный массив в замену
		bfield.fieldView();
		
		
		
	}

}
