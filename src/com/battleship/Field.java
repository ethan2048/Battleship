package com.battleship;

public class Field {
	
	private final int LINE_SIZE;
	
	private char[][] field;
	
	public Field() {
		LINE_SIZE = 10;
		field = new char[LINE_SIZE][LINE_SIZE];
	}
	
	public Field(int LINE_SIZE) {
		this.LINE_SIZE = LINE_SIZE;
		this.field = new char[LINE_SIZE][LINE_SIZE];
	}

	public char[][] getField() {
		return field;
	}

	public void setField(char[][] field) {
		this.field = field;
	}
	
	public char getFieldCell(int y, int x) { //возвращает значение клетки поля, либо '0' если невозможно получить
		if ((x<this.LINE_SIZE) && (y<this.LINE_SIZE) && (x>-1) && (y>-1)) return this.field[y][x];
		else return '0';
	}
	
	public void setFieldCell(int y, int x, char character) { //сеттер для клетки
		if ((x<this.LINE_SIZE) && (y<this.LINE_SIZE) && (x>-1) && (y>-1)) this.field[y][x] = character;
	}
		
	public int getLINE_SIZE() {
		return LINE_SIZE;
	}
	
	public char[] getFieldVector(int y) {
		return field[y]; 
	}
	
	public void fieldView() {
		for (int i = 0; i < LINE_SIZE; i++) {
			com.Methods.Array.viewCharArray(this.field[i], this.LINE_SIZE);
		}
	}
	
	
}
