package Methods;

public class Array {
	
	private static final char CHARACTER = 'o'; //заполнитель клеток
	
	public static char getCharacter() {
		return CHARACTER;
	}

	public static void viewCharArray(char[] array, int LINE_SIZE) {
		for (int i = 0; i < LINE_SIZE; i++) {
			System.out.print("[" + array[i] + "]");
		}
		System.out.println();
	}
	
	public static void fillCharArray(char[] array, int LINE_SIZE) {
		for (int i = 0; i < LINE_SIZE; i++) {
			array[i] = CHARACTER;
		}
	}
	
	
}
