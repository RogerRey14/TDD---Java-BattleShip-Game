import static org.junit.Assert.*;

import org.junit.Test;

public class BoaTest {

	@Test
	public void test() {
		
	//Prova de caixa Negra ---- M�tode changeBoat(string name) ---- 
	//Comprovem que li canvia el nom del tipus de vaixell correctament
	//Seg�ents proves aquest m�tode canviara la langitud del vaixell 	
		
		Boat b = new Boat();
		
		String boatName= "Portaavio";
		
		b.ChangeBoat(boatName);
		
		assertEquals(b.getName(),"Portaavio");
		
		boatName="Creuer";
		
		asserEquals(b.getName(),"Creuer");
		
		boatName="Fragata";
		
		asserEquals(b.getName(),"Fragata");
		
		
		
		
		
		
		
	}

}
