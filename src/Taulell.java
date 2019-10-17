
public class Taulell { //Inicialmente 10x25
	
	private int mida_horitzontal;
	private int mida_vertical;
	private char[][] Matriu;
	private char caracter='-';
	private String string_taulell="";
	
	Taulell(int mida_x, int mida_y ) {
		
		mida_horitzontal=mida_x;
		mida_vertical=mida_y;
		Matriu = new char[mida_vertical][mida_horitzontal];
		
		for (int i=0; i<mida_vertical;i++) 
		{
			for (int j=0; j<mida_horitzontal;j++)
			{
				Matriu[i][j]=caracter;
			}
		}
		
		String string_taulell = Construeix_Taulell(Matriu);
		
		printa_matriu(string_taulell);
		
		
		
	}
	
	public String get_string_taulell() { return string_taulell;}
	
	private String Construeix_Taulell(char[][] matriu) {
		
		String taulell="";
		
		for (int i=0; i<mida_vertical;i++) 
		{
			for (int j=0; j<mida_horitzontal;j++)
			{
				taulell+=caracter;
			}
		taulell+='\n';
		}
		
		return taulell;
		
	}
	
	private void printa_matriu(String cadena)
	{
		
		
		System.out.print(cadena);

	}
	
}
//para comprobar tablero comparar el string (bueno con el constructor y eso)
