import java.util.Scanner;

public class LlegueixTeclat {
	
	//M�todes per poder llegir car�cters tipo int i char per teclat
	
	public int LlegeixInt() {
		
		Scanner sc = new Scanner(System.in);
		int x= sc.nextInt();
		
		return x;
		
	}
	
	public char LlegeixChar() {
		
		Scanner sc = new Scanner(System.in);
		char col= sc.next().charAt(0);
		
		return col;
	}
}
