
import java.util.Scanner;

public class Joc {

	public static final int INEXPLORAT =  0;
	public static final int VAIXELL =  1;
	public static final int AIGUA =  2;
	public static final int TOCAT =  3;
	public static final int ENFONSAT =  4;
	
	
	private Taulell taulellJugador; 
	private Taulell taulellIA;
	
	Joc(Taulell t1, Taulell t2)
	{
		this.taulellJugador=t1;
		this.taulellIA=t2;
		
	}
	
	//Creem taulells i inicialitzem la partida escrivint per teclat les posicions dels vaixell 
	//i on els volem colocar, després els mostrem per pantalla
	
	public void preparaTaulells()
	{

		//emplenar taulell jugador
		//Scanner sc = new Scanner(System.in);
		boolean horitzontal = false, valorinvalid;
		int i=5;
		LlegueixTeclat teclat = new LlegueixTeclat();
		while(i>1)
		{
			
			//taulellJugador.printa_matriu(taulellJugador.get_string_taulell());
			
			if(i==5)
				System.out.print(taulellJugador.Construeix_Taulell( taulellJugador.getMatriu()));
			
			valorinvalid=false;
			
			System.out.println();
			System.out.println("Coloca el vaixell amb "+i+" caselles");
			System.out.println("Posició inicial X(número): ");
			
			//int x= sc.nextInt();
			
			int x=teclat.LlegeixInt();
			
			if(x>9 || x<0)
				valorinvalid=true;
			

			
			System.out.println("Posició inicial Y(lletra): ");
			
			//char col= sc.next().charAt(0);
		
			char col=teclat.LlegeixChar();
			
			int y=this.tradueix(col);
			if(y>9 || y<0)
				valorinvalid=true;
			
			System.out.println("Vaixell vertical(0) o horitzontal?(1): ");
			int hor = teclat.LlegeixInt();
			
			
			if(hor==1)
				horitzontal=true;
			else {
				if(hor==0)
					horitzontal=false;
				else
					valorinvalid=true;
			}
			
			if(!valorinvalid)
				valorinvalid=taulellJugador.colocaVaixell(x,y,i,horitzontal);
			if(valorinvalid) {
				i--;
				taulellJugador.Construeix_Taulell(taulellJugador.getMatriu());
				System.out.print(taulellJugador.Construeix_Taulell( taulellJugador.getMatriu()));
			}
			
			
		}
		
		
		
		
		
		//emplenar taulell IA
		
		taulellIA.creaTaulellIA();
		
		
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
	
	
	
}
