
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
	
	Boat(String name, int longitud){
		this.name=name;
		this.longitud=longitud;
	}
	
	Boat(String name, int longitud, Point[] coordenades, boolean[] partsTocades){
		
		this.name=name;
		this.longitud=longitud;
		this.coordernades=coordenades;
		this.partsTocades=partsTocades;
		
	}
	
	
	//Getters--------------------------------------------------------------------
	
	public String getName() {return this.name;}
	public int getLongitud() {return this.longitud;}
	
	
	
	
}
