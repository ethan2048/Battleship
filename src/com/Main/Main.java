package com.Main;

import com.Methods.*;
import com.battleship.Field;



public class Main {
	
	
	public static void main(String[] args) {
		int LENGHT = 10;
		int SHIP_LENGTH_1 = 4;
		int SHIP_LENGTH_2 = 5;
		int y = 1;
		int x = 1;
		char ch = ' ';
		
		Input key = new KeyboardInput();
		Field bfield = new Field(LENGHT);
		bfield.setFieldCell(y, x, 'C');
		bfield.view();
		System.out.println();
		//bfield.setField(key.menuHorizontalVertical(bfield.getField(), SHIP_LENGHT_1, y, x));
		bfield.setField(key.menuHorizontalVertical(bfield.getField(), SHIP_LENGTH_1, y, x));
		System.out.println();
		bfield.view();
	}

}
