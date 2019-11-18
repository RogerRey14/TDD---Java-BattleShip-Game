import static org.junit.Assert.*;

import org.junit.Test;

public class TestJoc {

	@Test 
	public void testJoc()
	{
		Taulell t1= new Taulell(10,10);
		Taulell t2= new Taulell(10,10);
		Joc joc=new Joc(t1,t2);
		
		assertEquals(t1,joc.getTaulellJugador());
		assertEquals(t2,joc.getTaulellIA());
		
		
	}
	
	
	//Test per comprovar si acaba la partida una vega s'hagin enfonsat els tots els vaixell
	//S'aplica correctament condition i decision coverage------------------------------------------------------------------------------------------------------------
	@Test
	public void testAcabaJoc() {
	
			Taulell taulell= new Taulell(10,10);
			taulell.colocaVaixell(2, 5, 3, true);
			taulell.colocaVaixell(5, 0, 2, false);
			taulell.colocaVaixell(0, 8, 5, false);
			taulell.colocaVaixell(9, 0, 4, true);
			
			Taulell taulell2= new Taulell(10,10);
			taulell2.colocaVaixell(2, 5, 3, true);
			taulell2.colocaVaixell(5, 0, 2, false);
			taulell2.colocaVaixell(0, 8, 5, false);
			taulell2.colocaVaixell(9, 0, 4, true);
			
			Joc joc= new Joc(taulell, taulell2);
			
			
			assertFalse(joc.acabaJoc());
			
			taulell2.dispara(taulell,2,5); 
			taulell2.dispara(taulell,2,6); 
			taulell2.dispara(taulell,2,7); 
			
			taulell2.dispara(taulell,5,0);
			taulell2.dispara(taulell,6,0);
			
			taulell2.dispara(taulell, 0, 8);
			taulell2.dispara(taulell, 1, 8);
			taulell2.dispara(taulell, 2, 8);
			taulell2.dispara(taulell, 3, 8);
			taulell2.dispara(taulell, 4, 8);
			
			taulell2.dispara(taulell, 9, 0);
			taulell2.dispara(taulell, 9, 1);
			taulell2.dispara(taulell, 9, 2);
			taulell2.dispara(taulell, 9, 3);

		
			assertTrue(joc.acabaJoc());
			
			taulell.colocaVaixell(2, 5, 3, true); //deixem un vaixell del jugador viu per comprovar si la partida acaba
			//guanyant l'ia
			
			taulell.dispara(taulell2,2,5); 
			taulell.dispara(taulell2,2,6); 
			taulell.dispara(taulell2,2,7); 
			
			taulell.dispara(taulell2,5,0);
			taulell.dispara(taulell2,6,0);
			
			taulell.dispara(taulell2, 0, 8);
			taulell.dispara(taulell2, 1, 8);
			taulell.dispara(taulell2, 2, 8);
			taulell.dispara(taulell2, 3, 8);
			taulell.dispara(taulell2, 4, 8);
			
			taulell.dispara(taulell2, 9, 0);
			taulell.dispara(taulell2, 9, 1);
			taulell.dispara(taulell2, 9, 2);
			taulell.dispara(taulell2, 9, 3);
			
			assertTrue(joc.acabaJoc());
			
			
			
			//comprovem que acabi el joc si perd el jugador
			
		
	}
	
	//Test per comprovar si tradueix correctament de char a int
	@Test
	public void tradueixTest() {
		
		Taulell taulell= new Taulell(10,10);
		Taulell taulell2= new Taulell(10,10);
		
		Joc joc=new Joc(taulell,taulell2);
		
		
		assertEquals(joc.tradueix('a'),0);
		assertEquals(joc.tradueix('A'),0);
		assertEquals(joc.tradueix('b'),1);
		assertEquals(joc.tradueix('B'),1);
		assertEquals(joc.tradueix('c'),2);
		assertEquals(joc.tradueix('C'),2);
		assertEquals(joc.tradueix('d'),3);
		assertEquals(joc.tradueix('D'),3);
		assertEquals(joc.tradueix('J'),9);
		assertEquals(joc.tradueix('j'),9);
		assertEquals(joc.tradueix('e'),4);
		assertEquals(joc.tradueix('E'),4);
		assertEquals(joc.tradueix('F'),5);
		assertEquals(joc.tradueix('f'),5);
		assertEquals(joc.tradueix('G'),6);
		assertEquals(joc.tradueix('g'),6);
		assertEquals(joc.tradueix('h'),7);
		assertEquals(joc.tradueix('H'),7);
		assertEquals(joc.tradueix('i'),8);
		assertEquals(joc.tradueix('I'),8);
		assertEquals(joc.tradueix('m'),-1);
		
		
	}
	
	//Test per comprovar si crea el taulell amb els vaixells colocat per teclat correctament
	//MockObject creat per suposar uns valors entrats per teclat i aixi colocar un vaixell en aquesta posició
	@Test
	public void preparaTaulellsTest() {
		
		Taulell taulell= new Taulell(10,10);
		Taulell taulell2= new Taulell(10,10);
		
		Joc joc = new Joc(taulell,taulell2);
		
		
		
		
		//assertEquals(joc.preparaTaulells(),0);
		
		
		
	}
	
	@Test
	public void llegeixCoordenadesTest() {
		Taulell taulell= new Taulell(10,10);
		Taulell taulell2= new Taulell(10,10);
		
		Joc joc = new Joc(taulell,taulell2);
		
		MockLlegueixTeclat mock = new MockLlegueixTeclat();
		joc.setTeclat(mock);
		
		joc.LlegeixCoordenades();
		
		assertEquals(joc.getX(), 0);
		assertEquals(joc.getY(), 0);
		assertEquals(joc.getHoritzontal(), 0);

	}
	
	
	

}
