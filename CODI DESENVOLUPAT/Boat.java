
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Boat {

	//Atributs-------------------------------------------------------------------
	
	private String name;
	private int longitud;
	private int num_vides;
	private int aux;

	private int[] coordenadesX;
	private int[] coordenadesY;

	//private boolean[] partsTocades;
	
	//Constructors---------------------------------------------------------------
	
	Boat(){
		
		this.name="";
	}
	
	Boat( int longitud){
		
		aux=0;
		coordenadesX= new int[5];
		coordenadesY=new int[5];
		
		switch (longitud) {
			case (5): 
				this.name="Portaavio";
				break;
			case(4):
				this.name="Destructor";
				break;
			case(3):
				this.name="Creuer";
				break;
			case(2):
				this.name="Fragata";
				break;
			default:
				this.name="";
				break;
				
		}
		
		this.num_vides=longitud;
		this.longitud=longitud;
	}

	
	
	//Getters--------------------------------------------------------------------
	
	public String getName() {return this.name;}
	
	public int getLongitud() {return this.longitud;}


	public int getVides() {
		return this.num_vides;
	}

	//si han disparat al vaixell, la vida del vaixell disminuex
	public void disparat() {
		this.num_vides--;
		
	}
	
	public void afegeixCoordenada(int x, int y)
	{
		coordenadesX[aux]=x;
		coordenadesY[aux]=y;
		aux++;
		
	}

	public int getCoordenadaX(int pos) {
		return this.coordenadesX[pos];
	}
	public int getCoordenadaY(int pos) {
		return this.coordenadesY[pos];
	}
	public int getAux() {
		return this.aux;
	}
	
	
	
}
