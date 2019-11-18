import java.io.IOException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException, InterruptedException {
	
		
		System.out.println("DICCIONARI DE JOC:");
		System.out.println("VAIXELL V");
		System.out.println("INEXPLORAT o");
		System.out.println("TOCAT x");
		System.out.println("ENFONSAT X");
		System.out.println("AIGUA A");
		System.out.println();
		
		Thread.sleep(7000);
		
	Taulell taulellJugador=new Taulell(10,10);
	Taulell taulellIA=new Taulell(10,10);	
	
	NumAleatori numAleatori= new NumAleatori();
	
	taulellIA.setRandom(numAleatori);
	Joc joc=new Joc(taulellJugador,taulellIA);
	LlegueixTeclat l = new LlegueixTeclat();
	int x;
	int y;
	char col;
	joc.preparaTaulells();
	
	while(!joc.acabaJoc())
	{
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("TAULELL ENEMIC:");
		
		System.out.println(taulellIA.Construeix_Taulell(taulellIA.traductorIA(taulellIA.getMatriu())));
		
		System.out.println("És el teu torn d'atac, selecciona les coordenades per disparar:");
		System.out.println("Coordenada y: (lletra)");
		col=l.LlegeixChar();
		y=joc.tradueix(col);
		System.out.println("Coordenada x: (número)");
		x=l.LlegeixInt();
		taulellJugador.dispara(taulellIA, x, y);
	
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		System.out.println("TAULELL ENEMIC:");
		System.out.println(taulellIA.Construeix_Taulell(taulellIA.traductorIA(taulellIA.getMatriu())));
		
		Thread.sleep(5000);

		taulellIA.IAdispara(taulellJugador);
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		System.out.println("La IA ha disparat, així queda el teu taulell");
		System.out.println("TAULELL JUGADOR:");
		System.out.println(taulellJugador.Construeix_Taulell(taulellJugador.getMatriu()));
		

		Thread.sleep(6000);
		
		if(joc.acabaJoc())
		{
			System.out.println("HAS GUANYAT! ENHORABONA!");
		}
		
		
		
	}
	
	
	
	}

}
