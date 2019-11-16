import static org.junit.Assert.*;

import org.junit.Test;
import java.lang.String;

public class TaulellTest {

	public static final int INEXPLORAT =  0;
	public static final int VAIXELL =  1;
	public static final int AIGUA =  2;
	public static final int TOCAT =  3;
	public static final int ENFONSAT =  4;
	
	//Test de caixa negra per comprovar que el taulell s'ha construit correctament.
	@Test
	public void testTaulell() {
		
		//constructor testing

		Taulell taulell= new Taulell(10,10);

		
		String taulell_copia = ("    | A | B | C | D | E | F | G | H | I | J | \n")+("----|---|---|---|---|---|---|---|---|---|---| \n")+
				("  1 | o | o | o | o | o | o | o | o | o | o | \n")+("----|---|---|---|---|---|---|---|---|---|---| \n")+
				("  2 | o | o | o | o | o | o | o | o | o | o | \n")+("----|---|---|---|---|---|---|---|---|---|---| \n")+
				("  3 | o | o | o | o | o | o | o | o | o | o | \n")+("----|---|---|---|---|---|---|---|---|---|---| \n")+
				("  4 | o | o | o | o | o | o | o | o | o | o | \n")+("----|---|---|---|---|---|---|---|---|---|---| \n")+
				("  5 | o | o | o | o | o | o | o | o | o | o | \n")+("----|---|---|---|---|---|---|---|---|---|---| \n")+
				("  6 | o | o | o | o | o | o | o | o | o | o | \n")+("----|---|---|---|---|---|---|---|---|---|---| \n")+
				("  7 | o | o | o | o | o | o | o | o | o | o | \n")+("----|---|---|---|---|---|---|---|---|---|---| \n")+
				("  8 | o | o | o | o | o | o | o | o | o | o | \n")+("----|---|---|---|---|---|---|---|---|---|---| \n")+
				("  9 | o | o | o | o | o | o | o | o | o | o | \n")+("----|---|---|---|---|---|---|---|---|---|---| \n")+
				(" 10 | o | o | o | o | o | o | o | o | o | o | \n")+("----|---|---|---|---|---|---|---|---|---|---| \n");
	 	
		assertEquals(taulell.get_string_taulell(), taulell_copia);
		
	}
	
	//test de caixa negre per comprovar que els vaixells s'han colocat correctament dins la matriu
	@Test
	public void testColocarVaixells ()
	{
	
		Taulell taulell = new Taulell(10,10);
		//coloquem vaixells correctament
		assertTrue(taulell.colocaVaixell(1, 2, 2, false));
		assertTrue(taulell.colocaVaixell(2, 5, 3, true));
		assertTrue(taulell.colocaVaixell(4, 1, 4, true));
		assertTrue(taulell.colocaVaixell(6, 1, 5, true));
		
		//intentem colocar vaixells ja existents
		assertFalse(taulell.colocaVaixell(1, 2, 2, false));
		assertFalse(taulell.colocaVaixell(2, 5, 3, true));
		
		//intentem colocar vaixells fora dels limits del taulell
		assertFalse(taulell.colocaVaixell(11, 4, 4, false));
		assertFalse(taulell.colocaVaixell(2, 10, 5, true));
		assertFalse(taulell.colocaVaixell(8, 4, 4, false));
		assertFalse(taulell.colocaVaixell(-1, 3, 5, true));
		assertFalse(taulell.colocaVaixell(11, -1, 4, false));
		assertFalse(taulell.colocaVaixell(2, 9, 5, true));
		
		
		//intentem colocar vaixells que toquin amb els ja existents
		
		
		
		
		//Comprovacio Fragata dins taulell
		assertEquals(taulell.getValor(1, 2), 1);
		assertEquals(taulell.getValor(2, 2), 1);

		//Comprovacio Creuer dins taulell
		assertEquals(taulell.getValor(2, 5), 1);
		assertEquals(taulell.getValor(2, 6), 1);
		assertEquals(taulell.getValor(2, 7), 1);
		
		//Comprovacio Destructor dins taulell
		assertEquals(taulell.getValor(4, 1), 1);
		assertEquals(taulell.getValor(4, 2), 1);
		assertEquals(taulell.getValor(4, 3), 1);
		assertEquals(taulell.getValor(4, 4), 1);
		
		//Comprovació Portaviones dins taulell
		assertEquals(taulell.getValor(6, 1), 1);
		assertEquals(taulell.getValor(6, 2), 1);
		assertEquals(taulell.getValor(6, 3), 1);
		assertEquals(taulell.getValor(6, 4), 1);
		assertEquals(taulell.getValor(6, 5), 1);
		
		//Comprovació no vaixell
		assertEquals(taulell.getValor(6, 6), 0);
		assertEquals(taulell.getValor(6, 7), 0);
		assertEquals(taulell.getValor(2, 4), 0);
		
		//System.out.print(taulell.Construeix_Taulell( taulell.getMatriu()));
		

	}
	
	@Test
	public void traductorTest() {
		
		Taulell taulell = new Taulell(10,10);
		
		assertEquals(taulell.traductor(VAIXELL),'V');
		assertEquals(taulell.traductor(AIGUA),'A');
		assertEquals(taulell.traductor(ENFONSAT),'X');
		assertEquals(taulell.traductor(TOCAT),'x');
		assertEquals(taulell.traductor(INEXPLORAT),'o');
		
	}
	
	
	/* NO FUNCIONA EL MOCKOBJECT 
	@Test
	public void testcreaTaulellIA ()
	{
		
		MockNumAleatori mock= new MockNumAleatori();
		Taulell taulellIA = new Taulell(10,10);
		taulellIA.setRandom(mock);
		
		taulellIA.creaTaulellIA();
		
		assertEquals(taulellIA.getValor(0, 1), 1);
		assertEquals(taulellIA.getValor(8, 2), 0);
		
		
		
	}
	*/

}
