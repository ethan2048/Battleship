package com.Main;

import com.Methods.*;
import com.battleship.Field;



public class Main {
	
	
	public static void main(String[] args) {
		int LENGHT = 4;
		int SHIP_LENGHT = 4;
		
		Field bfield = new Field(LENGHT);
		KeyboardInput kb = new KeyboardInput();
		boolean indent = kb.arrayTest(bfield.getFieldVector(0), 1, LENGHT, SHIP_LENGHT);
		System.out.println(indent);
		
		
		
	}

}
