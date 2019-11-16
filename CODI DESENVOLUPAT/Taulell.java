/*
public class Taulell { //Inicialmente 10x25
	
	private int mida_horitzontal;
	private int mida_vertical;
	private String[][] Matriu;
	private String caracter="   |";
	private String string_taulell="";
	
	Taulell(int mida_x, int mida_y ) {
		
		mida_horitzontal=mida_x;
		mida_vertical=mida_y;
		Matriu = new String[mida_vertical][mida_horitzontal];
		
		for (int i=0; i<mida_vertical;i++) 
		{
			for (int j=0; j<mida_horitzontal;j++)
			{
				Matriu[i][j]=caracter + " ";
				
			}
		}
		
		Construeix_Taulell(Matriu);
		
		printa_matriu(string_taulell);
		
		
		
	}
	
	public String get_string_taulell() { return string_taulell;}
	
	private void Construeix_Taulell(String[][] matriu) {
		
		System.out.println("   | A | B | C | D | E | F | G | H | I | J |");
		//System.out.println("")
		
		for (int i=0; i<mida_vertical;i++) 
		{
			System.out.println("---|---|---|---|---|---|---|---|---|---|---|");
			System.out.print(" " + (i) + " |");
			for (int j=0; j<mida_horitzontal;j++)
			{
				System.out.print(" " + matriu[i][j] + " |");
				
			}
			System.out.println(" " + (i));
		}
		
	}
	
	private void printa_matriu(String cadena)
	{
		
		
		System.out.print(cadena);

	}
	
}
//para comprobar tablero comparar el string (bueno con el constructor y eso)*/



public class Taulell { //Inicialmente 10x25
	
	private int mida_horitzontal;
	private int mida_vertical;
	private int[][] matriuTaulell;
	private String caracter="|   ";
	private String string_taulell;
	
	Taulell(int mida_x, int mida_y ) {
		
		mida_horitzontal=mida_x;
		mida_vertical=mida_y;
		matriuTaulell = new int[mida_vertical][mida_horitzontal];
		
		
		string_taulell = Construeix_Taulell(matriuTaulell);
		
		//printa_matriu(string_taulell);
		
		
		
	}
	
	public String get_string_taulell() { return string_taulell;}
	
	private String Construeix_Taulell(int[][] matriu2) {
		
		/* String taulell="   | A | B | C | D | E | F | G | H | I | J |\n---|---|---|---|---|---|---|---|---|---|---|\n";
		
		
		for (int i=0; i<mida_vertical;i++) 
		{
			if(i<9) {
				taulell+=" "+(i+1)+" ";}
			else {
				taulell+=(i+1)+" ";}
			for (int j=0; j<mida_horitzontal;j++)
			{
					taulell+=caracter;
				//System.out.print(" " + matriu[i][j] + " |");
			}
		taulell+="|\n---|---|---|---|---|---|---|---|---|---|---|\n";
		}
		
		return taulell;
		*/
		
		
		String taulell = "";
		taulell = taulell+("    | A | B | C | D | E | F | G | H | I | J | \n");
		for (int i = 0; i < mida_vertical; i++) {
			taulell = taulell+("----|---|---|---|---|---|---|---|---|---|---| \n");
			if(i<9) {
				taulell = taulell+" ";
			}
			taulell = taulell+(" " + (i+1) + " |");
			for (int j = 0; j < mida_horitzontal; j++)
			{
				taulell = taulell+(" " + matriuTaulell[i][j] + " |");
			}
			taulell = taulell + " \n";
		}	
		taulell = taulell+("----|---|---|---|---|---|---|---|---|---|---| \n");
		
		
		return taulell;
	}
	
	public void setMatriu(int[][] matriu) {matriuTaulell = matriu; }
	
	private void printa_matriu(String cadena)
	{
		
		
		System.out.print(cadena);

	}
	
}
//para comprobar tablero comparar el string (bueno con el constructor y eso)
