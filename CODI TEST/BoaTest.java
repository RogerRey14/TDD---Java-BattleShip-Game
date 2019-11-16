import static org.junit.Assert.*;

import org.junit.Test;

public class BoaTest {

	@Test
	public void test() {
		
	//Prova de caixa Negra --- getters ------------
		
		Boat b1 = new Boat(5);
		Boat b2 = new Boat(3);
		Boat b3 = new Boat(4);
		Boat b4 = new Boat(2);
		
		assertEquals(b1.getName(),"Portaavio");
		assertEquals(b2.getName(),"Creuer");
		assertEquals(b3.getName(),"Destructor");
		assertEquals(b4.getName(),"Fragata");
		
		assertEquals(b1.getLongitud(),5);
		assertEquals(b2.getLongitud(),3);
		assertEquals(b3.getLongitud(),4);
		assertEquals(b4.getLongitud(),2);
	
		
		
		
		
		
	}

}
