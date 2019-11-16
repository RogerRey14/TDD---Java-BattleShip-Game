

public class Taulell { //Inicialmente 10x10
	


public static final int INEXPLORAT =  0;
public static final int VAIXELL =  1;
public static final int AIGUA =  2;
public static final int TOCAT =  3;
public static final int ENFONSAT =  4;


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
	
	//Constrium la matriu 10x10
	private String Construeix_Taulell(int[][] matriu2) {
		
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
	
	
	//comprovem si a la posició pasada per paràmetre de la matriu ja està ocupada per un vaixell o no
	public boolean hihaVaixell(int x, int y)
	{
		
		if (this.matriuTaulell[x][y]==AIGUA)
			return false;
		else
			return true;
		
	}
	
	
	//Es coloca el vaixell a al taulell, comprovant totes les posicions.
	public void colocaVaixell(int x, int y, int mida, boolean horitzontal) 
	{
		
		if(hihaVaixell(x,y)) 
		{
			
			System.out.println( "Posició ocupada per un vaixell");
			
			//return false;
			
		}
		else 
		{
			
			if(x>=0 && x<=9) 
			{
				
				if(y>=0 && y<=9) 
				{
					//Posició passada per paràmetre és vàlida, ara comprovar la mida i el sentit 
					
					if(horitzontal) 
					{
						for(int i=0; i<mida;i++)
						{
							if(x+i>=0 && x+i<=9)
								this.matriuTaulell[x+i][y]= VAIXELL;
							else
							{
								System.out.println( "Posició 'x' fora del taulell");
								//return false; 
							}
							
						}
						
					}
					else //posició vertical
					{
						for(int i=0; i<mida;i++)
						{
							if(y+i>=0 && y+i<=9)
								this.matriuTaulell[x][y+i]= VAIXELL;
							else 
							{
								System.out.println( "Posició 'y' fora del taulell");
								//return false; 
							}
						}
					}
					
				}
				else
				{
					System.out.println( "Posició 'y' fora del taulell");
					//return false;  
				}
				
			}
			else
			{
				System.out.println( "Posició 'x' fora del taulell");
				//return false; 
			}
			
		}
		
		
	}
	
	
	//Retorna el valor de la posició passada per paràmetre de la matriu
	public int getValor(int x, int y) {return matriuTaulell[x][y];}
	
	
	//Printa la matriu per pantalla
	private void printa_matriu(String cadena)
	{
		
		
		System.out.print(cadena);

	}
	
}
//para comprobar tablero comparar el string (bueno con el constructor y eso)
