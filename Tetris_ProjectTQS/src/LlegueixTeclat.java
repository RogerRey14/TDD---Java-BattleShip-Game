import java.util.Scanner;

public class LlegueixTeclat {
	
	//Mètodes per poder llegir caràcters tipo int i char per teclat
	
	public int LlegeixInt() {
		
		Scanner sc = new Scanner(System.in);
		int x = (int) sc.next().charAt(0) - 48;
		
		return x;
		
	}
	
	public char LlegeixChar() {
		
		Scanner sc = new Scanner(System.in);
		char col= sc.next().charAt(0);
		
		return col;
	}
}
