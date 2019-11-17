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
	
	@Test
	public void DisparatTest() {
		Boat b = new Boat(5);
		
		b.disparat();
		assertEquals(b.getVides(),4);
		b.disparat();
		assertEquals(b.getVides(),3);
		b.disparat();
		assertEquals(b.getVides(),2);
		b.disparat();
		assertEquals(b.getVides(),1);
		b.disparat();
		assertEquals(b.getVides(),0);
		b.disparat();
		assertEquals(b.getVides(),-1);//No suposa cap problema, 
		//ja que en la partida no es veura influenciat si passa de 0 la vida del vaixell
		//mentres arribi a 0 no hi ha cap probelma, ho comprovem en un altre mètode	
		
	}
	
	@Test
	public void afegeixCoordenadaTest() {
		
		Boat b=new Boat(2);
		
		b.afegeixCoordenada(0, 0);
		
		assertEquals(b.getCoordenadaX(0),0);
		assertEquals(b.getCoordenadaY(0),0);
		assertEquals(b.getAux(),1);
		
		
		b.afegeixCoordenada(1, 1);
		
		assertEquals(b.getCoordenadaX(1),1);
		assertEquals(b.getCoordenadaY(1),1);
		assertEquals(b.getAux(),2);
		
	}

}
