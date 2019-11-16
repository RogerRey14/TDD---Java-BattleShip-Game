
import java.awt.Point;
import java.util.Arrays;

public class Boat {

	//Atributs-------------------------------------------------------------------
	
	private String name;
	private int longitud;
	private Point[] coordernades;
	private boolean[] partsTocades;
	
	//Constructors---------------------------------------------------------------
	
	Boat(){
		
		this.name="";
	}
	
	Boat( int longitud){
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
		
		this.longitud=longitud;
	}
	
	Boat(int longitud, Point[] coordenades, boolean[] partsTocades){
		
		
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
	
		this.longitud=longitud;
		this.coordernades=coordenades;
		this.partsTocades=partsTocades;
		
	}
	
	
	//Getters--------------------------------------------------------------------
	
	public String getName() {return this.name;}
	public int getLongitud() {return this.longitud;}
	
	
	
	
}
