
import java.util.Scanner;

public class Joc {

	public static final int INEXPLORAT =  0;
	public static final int VAIXELL =  1;
	public static final int AIGUA =  2;
	public static final int TOCAT =  3;
	public static final int ENFONSAT =  4;
	
	
	private Taulell taulellJugador; 
	private Taulell taulellIA;
	private LlegueixTeclat teclat;
	private int x;
	private int y;
	private int horitzontal;
	
	
	
	Joc(Taulell t1, Taulell t2)
	{
		this.taulellJugador=t1;
		this.taulellIA=t2;
		this.teclat = new LlegueixTeclat();
		
	}
	
	public Taulell getTaulellJugador() {return this.taulellJugador;} 
	public Taulell getTaulellIA() {return this.taulellIA;} 
	
	//Creem taulells i inicialitzem la partida escrivint per teclat les posicions dels vaixell 
	//i on els volem colocar, després els mostrem per pantalla
	
	public void preparaTaulells()
	{

		//emplenar taulell jugador
		//Scanner sc = new Scanner(System.in);
		boolean horitzontal = false;
		boolean	valorinvalid=false;
		int i=5;
		while(i>1)
		{
			
			//taulellJugador.printa_matriu(taulellJugador.get_string_taulell());
			
			if(i==5)
				System.out.print(taulellJugador.Construeix_Taulell( taulellJugador.getMatriu()));
			
			valorinvalid=false;
			
			System.out.println();
			System.out.println("Coloca el vaixell amb "+i+" caselles");
			LlegeixCoordenades();
			if(this.x>9 || this.x<0)
				valorinvalid=true;
			
			if(this.y>9 || this.y<0)
				valorinvalid=true;
			
			
		
			if(this.horitzontal==1)
				horitzontal=true;
			else {
				if(this.horitzontal==0)
					horitzontal=false;
				else
					valorinvalid=true;
			}
			
			if(!valorinvalid) {
				if(taulellJugador.colocaVaixell(x,y,i,horitzontal)) {
					i--;
					taulellJugador.Construeix_Taulell(taulellJugador.getMatriu());
					System.out.print(taulellJugador.Construeix_Taulell( taulellJugador.getMatriu()));
				}
			}
				
			
			
		}
		
		//emplenar taulell IA
		
		taulellIA.creaTaulellIA();
		
	}
	
	public void LlegeixCoordenades() {
		
		System.out.println("Posició inicial X(número): ");
		
		//int x= sc.nextInt();
		
		this.x = teclat.LlegeixInt();
		
		System.out.println("Posició inicial Y(lletra): ");
		
		//char col= sc.next().charAt(0);
	
		char col = teclat.LlegeixChar();
		
		this.y = this.tradueix(col);
		
		
		System.out.println("Vaixell vertical(0) o horitzontal?(1): ");
		this.horitzontal = teclat.LlegeixInt();
		

	}
	
	//Per escriure la coordenada Y escrivim una lletra i amb aquest mètode la pasem a int
	public int tradueix(char c)
	{
		switch(c)
		{
		case('A'):
		case('a'):
			return 0;
		case('B'):
		case('b'):
			return 1;
		case('C'):
		case('c'):
			return 2;
		case('D'):
		case('d'):
			return 3;
		case('E'):
		case('e'):
			return 4;
		case('F'):
		case('f'):
			return 5;
		case('G'):
		case('g'):
			return 6;
		case('H'):
		case('h'):
			return 7;
		case('I'):
		case('i'):
			return 8;
		case('J'):
		case('j'):
			return 9;
		default:
			return -1;
		}
		

	}

	
	//Comprovem que no hi hagin vaixells en els taulells per finalizar la partida
	//S'aplica correctament condition i decision coverage
	public boolean acabaJoc()
	{
		int[][] mIA=this.taulellIA.getMatriu();
		int [][] mJugador =this.taulellJugador.getMatriu();
		
		boolean ia=true;
		boolean jugador=true;
		
		for(int i=0;i<taulellIA.getMidaY();i++)
		{
			for (int j=0;j<taulellIA.getMidaX();j++)
			{
				if(mIA[i][j]==VAIXELL) {
					ia=false;
				}
			}
		}
		
		
		for(int i=0;i<taulellJugador.getMidaY();i++)
		{
			for (int j=0;j<taulellJugador.getMidaX();j++)
			{
				if(mJugador[i][j]==VAIXELL) {
					jugador=false;
				}
			}
		}
		
		if (jugador || ia)
			return true;
		else
			return false;
		
	}
	
	
	public void setTeclat(LlegueixTeclat t) {this.teclat = t;}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getHoritzontal() {
		return this.horitzontal;
	}
	
	
	
}
