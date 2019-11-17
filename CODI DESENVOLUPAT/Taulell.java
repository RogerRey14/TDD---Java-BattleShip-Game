import java.util.ArrayList;

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
	private int num;
	private Boat[] llistaVaixells;
	
	private NumAleatori random;
	
	Taulell(int mida_x, int mida_y ) {
		
		mida_horitzontal=mida_x;
		mida_vertical=mida_y;
		matriuTaulell = new int[mida_vertical][mida_horitzontal];
		num=0;
		llistaVaixells= new Boat[10];
		string_taulell = Construeix_Taulell(matriuTaulell);
		
		//printa_matriu(string_taulell);
		
		
		
	}
	
	public int getMidaX() {return mida_horitzontal;}

	public int getMidaY() {return mida_vertical;}
	
	public String get_string_taulell() { return string_taulell;}
	
	//Constrium la matriu 10x10
	public String Construeix_Taulell(int[][] matriu2) {
		
		String taulell = "";
		taulell = taulell+("   | A | B | C | D | E | F | G | H | I | J | \n");
		for (int i = 0; i < mida_vertical; i++) {
			taulell = taulell+("---|---|---|---|---|---|---|---|---|---|---| \n");
			if(i<9) {
				taulell = taulell;
			}
			taulell = taulell+(" " + (i) + " |");
			for (int j = 0; j < mida_horitzontal; j++)
			{
				taulell = taulell+(" " + this.traductor(matriuTaulell[i][j]) + " |");
			}
			taulell = taulell + " \n";
		}	
		taulell = taulell+("---|---|---|---|---|---|---|---|---|---|---| \n");
		
		
		return taulell;
	}
	
	public int[][] getMatriu(){return this.matriuTaulell;}
	
	
	//Modifiquem el valor de la matriu a la posició desitjada
	public void modificaMatriu(int valor, int posX, int posY) //hacer test
	{
		this.matriuTaulell[posX][posY]=valor;
		
	}
	
	
	public void setMatriu(int[][] matriu) {matriuTaulell = matriu; }
	
	
	//comprovem si a la posició pasada per paràmetre de la matriu ja està ocupada per un vaixell o no
	public boolean hihaVaixell(int x, int y)
	{
		
		if (this.matriuTaulell[x][y]==VAIXELL)
			return true;
		else
			return false;
		
	}
	
	
	//Es coloca el vaixell a al taulell, comprovant totes les posicions.
	public boolean colocaVaixell(int x, int y, int mida, boolean horitzontal) 
	{
		boolean colocat=false;
		boolean vaixell = false;
		if(x<0 || x>9) 
		{
			return colocat;
		}
		if(y<0 || y>9) 
		{
			return colocat;
		}
		
		
		
		if(hihaVaixell(x,y)) 
		{
			
			//System.out.println( "Posició ocupada per un vaixell");
			
			return colocat;
			
		}
		else 
		{
			
			//Posició passada per paràmetre és vàlida, ara comprovar la mida i el sentit 
					
					if(!horitzontal) 
					{
						if(x+mida-1 <= 9) 
						{
							int i = 0;
							while(!vaixell && i<mida) {
								if (!hihaVaixell(x+i,y)) {
									i++;
								}
								else {
									vaixell = true;
								}
							}
							if(!vaixell) {
								
								Boat barco=new Boat(mida);
								
								for(i = 0; i<mida;i++)
								{
									
									this.matriuTaulell[x+i][y]= VAIXELL;
									barco.afegeixCoordenada(x+i, y);
									
									
								}
								this.llistaVaixells[num]=barco;
								num++;
								colocat=true;
								return colocat;
							}
							
						}
						
						
					}
					else //posició horitzontal
					{
						if(y+mida-1 <= 9) 
						{
							int i = 0;
							while(!vaixell && i<mida) {
								if (!hihaVaixell(x,y+i)) {
									i++;
								}
								else {
									vaixell = true;
								}
							}
							if(!vaixell) {
								
								Boat barco=new Boat(mida);
								for(i = 0; i<mida;i++)
								{
									
									this.matriuTaulell[x][y+i]= VAIXELL;
									barco.afegeixCoordenada(x, y+i);
								}
								this.llistaVaixells[num]=barco;
								num++;
								colocat=true;
								return colocat;
							}
					}
						
			}
			
		}
		
		return colocat;
		
	}
	
	
	
	
	//Retorna el valor de la posició passada per paràmetre de la matriu
	public int getValor(int x, int y) {return matriuTaulell[x][y];}
	
	
	//Printa la matriu per pantalla
	public void printa_matriu(String cadena)
	{
		
		
		System.out.print(cadena);

	}
	
	
	
	//Traduim els valors del taulell original per caràcters de tipo char, per a que visualment sigui més fàcil indenticar-ho
	public char traductor(int constant)
	{
		switch (constant)
		{
		case VAIXELL:
			return 'V';
		case AIGUA:
			return 'A';
		case TOCAT:
			return 'x';
		case ENFONSAT:
			return 'X';
		default:
			return 'o';
		
		}

	}
	
	public void setRandom(NumAleatori option)
	{
		this.random=option;
		
	}
	
	//falta test
	//creem taulell de la màquina i coloca els vaixells en posicions aleatories de la matriu
	public void creaTaulellIA()
	{
		int n=5;
		boolean horitzontal;
		boolean colocat=false;
		
		while(n!=1) {
			
			colocat=false;
			
			//generar randoms x, y, horitzontal
			int x=this.random.generaNumeroAleatori(0, 9);
			int y=this.random.generaNumeroAleatori(0, 9);
			int mida=n;
			int horitzontalaux=random.generaNumeroAleatori(0, 1);
			
			
			if(horitzontalaux==1)
				horitzontal=true;
			else
				horitzontal=false;
					
			colocat=this.colocaVaixell(x, y, mida, horitzontal);
			
		
			if(colocat==true)
				n--;
		}
		
	}
	
	public boolean dispara(Taulell t, int x, int y)
	{
		if(x<0 || x>9) 
		{
			return false;
		}
		if(y<0 || y>9) 
		{
			return false;
		}

		
		if(t.getMatriu()[x][y]==AIGUA || t.getMatriu()[x][y]==TOCAT || t.getMatriu()[x][y]==ENFONSAT )
		{
			return false;
		}
		else {

			if(t.getMatriu()[x][y]==INEXPLORAT)
			{
				t.modificaMatriu(AIGUA, x, y);
				return false;
			}
			else
			{
				if(t.getBoat(x,y).getVides()==1)
				{
					for(int i=0;i<t.getBoat(x,y).getLongitud();i++) 
					{
							t.modificaMatriu(ENFONSAT,t.getBoat(x, y).getCoordenadaX(0+i)
									,t.getBoat(x, y).getCoordenadaY(0+i) );
					}
	
				}
				
				else
					t.modificaMatriu(TOCAT, x, y);
					
				t.getBoat(x,y).disparat();
	
			}
		}
		return true;
				
		
		
		
	}

	//falta test
	//retornem un objecte Boat de una llista de Boats en funció d'una de les posicions a la matriu del vaixell
	private Boat getBoat(int x,int y) {
		
		
		
		for(int i=0; i<num;i++)
		{
			//Boat b= (Boat) this.llistaVaixells[i];
			for(int j=0; j<llistaVaixells[i].getLongitud();j++)
			{
				if(x==llistaVaixells[i].getCoordenadaX(j) && y==llistaVaixells[i].getCoordenadaY(j))
					return llistaVaixells[i];
			
			}
			
			
		}
		return null;

	}
	
	
}


