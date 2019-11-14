import static org.junit.Assert.*;

import org.junit.Test;

public class BoaTest {

	@Test
	public void test() {
		
	//Prova de caixa Negra ---- Mètode changeBoat(string name) ---- 
	//Comprovem que li canvia el nom del tipus de vaixell correctament
	//Següents proves aquest mètode canviara la langitud del vaixell 	
		
		Boat b = new Boat();
		
		String name;
		String boatName= "Portaavio";
		
		b.ChangeBoat(boatName);
		
		name=b.getName();
		
		assertEquals(name,boatName);
		
		boatName="Creuer";
		
		name=b.getName();
		
		assertEquals(name,boatName);
		
		boatName="Fragata";
		
		name=b.getName();
		
		assertEquals(name,boatName);
		
		
		
		
		
		
		
	}

}
