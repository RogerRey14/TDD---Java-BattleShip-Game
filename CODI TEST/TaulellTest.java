import static org.junit.Assert.*;

import org.junit.Test;
import java.lang.String;

public class TaulellTest {

	public static final int INEXPLORAT =  0;
	public static final int VAIXELL =  1;
	public static final int AIGUA =  2;
	public static final int TOCAT =  3;
	public static final int ENFONSAT =  4;
	
	@Test
	public void testTaulell()
	{
		int num_vaixells_inicials=0, midax=10, miday=10;
		
		
		Taulell t=new Taulell(midax,miday);
		
		assertEquals(t.getNumVaixells(),num_vaixells_inicials);
		assertEquals(t.getMidaX(),midax);
		assertEquals(t.getMidaY(),miday);
	}
	
	
	
	
	
	//Test de caixa negra per comprovar que el taulell s'ha construit correctament.
	@Test
	public void testconstrueixTaulell() {
	
		Taulell taulell= new Taulell(10,10);

		
		String taulell_copia = ("   | A | B | C | D | E | F | G | H | I | J | \n")+("---|---|---|---|---|---|---|---|---|---|---| \n")+
				(" 0 | o | o | o | o | o | o | o | o | o | o | \n")+("---|---|---|---|---|---|---|---|---|---|---| \n")+
				(" 1 | o | o | o | o | o | o | o | o | o | o | \n")+("---|---|---|---|---|---|---|---|---|---|---| \n")+
				(" 2 | o | o | o | o | o | o | o | o | o | o | \n")+("---|---|---|---|---|---|---|---|---|---|---| \n")+
				(" 3 | o | o | o | o | o | o | o | o | o | o | \n")+("---|---|---|---|---|---|---|---|---|---|---| \n")+
				(" 4 | o | o | o | o | o | o | o | o | o | o | \n")+("---|---|---|---|---|---|---|---|---|---|---| \n")+
				(" 5 | o | o | o | o | o | o | o | o | o | o | \n")+("---|---|---|---|---|---|---|---|---|---|---| \n")+
				(" 6 | o | o | o | o | o | o | o | o | o | o | \n")+("---|---|---|---|---|---|---|---|---|---|---| \n")+
				(" 7 | o | o | o | o | o | o | o | o | o | o | \n")+("---|---|---|---|---|---|---|---|---|---|---| \n")+
				(" 8 | o | o | o | o | o | o | o | o | o | o | \n")+("---|---|---|---|---|---|---|---|---|---|---| \n")+
				(" 9 | o | o | o | o | o | o | o | o | o | o | \n")+("---|---|---|---|---|---|---|---|---|---|---| \n");
	 	
		assertEquals(taulell.get_string_taulell(), taulell_copia);
		
	}
	
	@Test
	public void testhihaVaixell()
	{
		Taulell taulell = new Taulell(10,10);
		
		taulell.colocaVaixell(0, 0, 2, false);
		
		assertTrue(taulell.hihaVaixell(0, 0));
		assertTrue(taulell.hihaVaixell(1, 0));
		assertFalse(taulell.hihaVaixell(3, 0));
		assertFalse(taulell.hihaVaixell(0, 1));
		assertFalse(taulell.hihaVaixell(1, 1));
		assertFalse(taulell.hihaVaixell(3, 3));
	}
	
	
	//test de caixa negre per comprovar que els vaixells s'han colocat correctament dins la matriu
	//Comprovem path coverage
	//Comprovem condition i decision coverage------------------------------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testColocaVaixell ()
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
		assertFalse(taulell.colocaVaixell(4, 1, 4, true));
		assertFalse(taulell.colocaVaixell(6, 1, 5, true));
		
		//intentem colocar vaixells fora dels limits del taulell
		assertFalse(taulell.colocaVaixell(11, 4, 4, false));
		assertFalse(taulell.colocaVaixell(2, 10, 5, true));
		assertFalse(taulell.colocaVaixell(8, 4, 4, false));
		assertFalse(taulell.colocaVaixell(-1, 3, 5, true));
		assertFalse(taulell.colocaVaixell(11, -1, 4, false));
		assertFalse(taulell.colocaVaixell(2, 9, 5, true));
		assertFalse(taulell.colocaVaixell(2, -5, 5, true));
		assertFalse(taulell.colocaVaixell(2, 20, 4, false));
		assertFalse(taulell.colocaVaixell(2, 100, 5, true));
		
		//intentem colocar vaixells que toquin amb els ja existents
		assertFalse(taulell.colocaVaixell(1, 1, 4, true));
		assertFalse(taulell.colocaVaixell(2, 1, 5, true));
		
		assertFalse(taulell.colocaVaixell(4, 2, 4, false));
		assertFalse(taulell.colocaVaixell(5, 4, 5, false));
		

		
		//fent aquestes comprovacions demostro que estic fent loop testing simple
		//en el bucle del mètode colocaVaixell() de la classe Taulell linea 139
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
	public void testTraductor() {
		
		Taulell taulell = new Taulell(10,10);
		
		assertEquals(taulell.traductor(VAIXELL),'V');
		assertEquals(taulell.traductor(AIGUA),'A');
		assertEquals(taulell.traductor(ENFONSAT),'X');
		assertEquals(taulell.traductor(TOCAT),'x');
		assertEquals(taulell.traductor(INEXPLORAT),'o');
		
	}
	
	
	@Test
	public void testcreaTaulellIA ()
	{
		
		MockNumAleatori mock = new MockNumAleatori();
		Taulell taulellIA = new Taulell(10,10);
		taulellIA.setRandom(mock);
		
		taulellIA.creaTaulellIA();
		
		//comprovar que s'han cret vaixells en el taulell aleatoriament gràcies al mock
		
		//Vaixell mida 5
		assertEquals(taulellIA.getValor(0, 0), 1);//Frontera
		assertEquals(taulellIA.getValor(0, 1), 1);//Limit interior
		assertEquals(taulellIA.getValor(0, 2), 1);
		assertEquals(taulellIA.getValor(0, 3), 1);//Limit interior
		assertEquals(taulellIA.getValor(0, 4), 1);//Frontera
		assertEquals(taulellIA.getValor(0, 5), 0);//Limit exterior
		
		//Vaixell mida 4
		assertEquals(taulellIA.getValor(2, 0), 1);//Frontera
		assertEquals(taulellIA.getValor(2, 1), 1);//Limit interior
		assertEquals(taulellIA.getValor(2, 2), 1);//Limit interior
		assertEquals(taulellIA.getValor(2, 3), 1);//Frontera
		assertEquals(taulellIA.getValor(2, 4), 0);//Limit exterior
		
		//Vaixell mida 3
		assertEquals(taulellIA.getValor(7, 4), 1);//Frontera
		assertEquals(taulellIA.getValor(8, 4), 1);//Limit interior
		assertEquals(taulellIA.getValor(9, 4), 1);//Frontera
		
		//Vaixell mida 2
		assertEquals(taulellIA.getValor(6, 2), 0);//Limit
		assertEquals(taulellIA.getValor(6, 3), 1);//Frontera
		assertEquals(taulellIA.getValor(6, 4), 1);//Frontera
		assertEquals(taulellIA.getValor(6, 5), 0);//Limit
		
	}

	@Test
	public void testDispara() {
		
		Taulell taulell= new Taulell(10,10);
		Taulell taulellVictima= new Taulell(10,10);
		//coloquem vaixells correctament
		taulellVictima.colocaVaixell(1, 2, 2, false);
		taulellVictima.colocaVaixell(2, 5, 3, true);
		taulellVictima.colocaVaixell(4, 1, 4, true);
		taulellVictima.colocaVaixell(6, 1, 5, true);
		
		
		
		assertTrue(taulell.dispara(taulellVictima,4,2)); //hay barco
		assertFalse(taulell.dispara(taulellVictima,4,2));//disparo a un barco ya tocado 
		assertTrue(taulell.dispara(taulellVictima,2,2)); 
		assertTrue(taulell.dispara(taulellVictima,6,4)); 
		
		
		assertFalse(taulell.dispara(taulellVictima,0,0)); 
		assertFalse(taulell.dispara(taulellVictima,12,3)); 
		assertFalse(taulell.dispara(taulellVictima,4,22)); 
		assertFalse(taulell.dispara(taulellVictima,10,10)); 
		
		//System.out.print(taulellVictima.Construeix_Taulell( taulellVictima.getMatriu()));
		
	}
	
	@Test
	public void testIAdispara() {
		
		MockNumAleatori mock = new MockNumAleatori();
		Taulell taulellIA = new Taulell(10,10);
		taulellIA.setRandom(mock);
		taulellIA.creaTaulellIA();
		
		mock.restart();
		
		Taulell taulellVictima= new Taulell(10,10);
		//coloquem vaixells correctament
		taulellVictima.colocaVaixell(0, 0, 2, true);
		taulellVictima.colocaVaixell(2, 0, 3, true);
		taulellVictima.colocaVaixell(7, 4, 4, true);
		taulellVictima.colocaVaixell(3, 1, 5, true);
		
		//array mockobject retorna els seguents valors
		assertTrue(taulellIA.IAdispara(taulellVictima)); //hay barco disparo 00
		assertFalse(taulellIA.IAdispara(taulellVictima)); //no hi ha vaixell disparo 1,2
		assertTrue(taulellIA.IAdispara(taulellVictima)); // disparo 0,1
		assertTrue(taulellIA.IAdispara(taulellVictima)); //disparo 7,4
		assertFalse(taulellIA.IAdispara(taulellVictima)); // disparo 0,6
		assertTrue(taulellIA.IAdispara(taulellVictima));// disparo 3,1

		
		
	}
	
	
	
	
	@Test
	public void testModificaMatriu() {
		
		Taulell taulell= new Taulell(10,10);
		
		taulell.modificaMatriu(1, 0, 0);
		taulell.modificaMatriu(2, 5, 5);
		taulell.modificaMatriu(3, 9, 9);
		
		assertEquals(taulell.getValor(0, 0),1);
		assertEquals(taulell.getValor(9, 9),3);
		assertEquals(taulell.getValor(5, 5),2);
		
		taulell.modificaMatriu(3, 5, 5);
		taulell.modificaMatriu(2, 0, 0);
		taulell.modificaMatriu(1, 9, 9);
		
		assertEquals(taulell.getValor(5, 5),3);
		assertEquals(taulell.getValor(0, 0),2);
		assertEquals(taulell.getValor(9, 9),1);
		
		
	}
	
	@Test
	public void testTraductorIA()
	{
		Taulell t=new Taulell(10,10);
		t.colocaVaixell(1, 2, 2, false);
		t.colocaVaixell(2, 5, 3, true);

		
		int[][] matriuaux= t.traductorIA(t.getMatriu());
		
		//valors frontera
		assertEquals(matriuaux[1][2],INEXPLORAT);
		assertEquals(matriuaux[1][3],INEXPLORAT);
		assertEquals(matriuaux[2][5],INEXPLORAT);
		assertEquals(matriuaux[2][7],INEXPLORAT);
		
		
		//valors limit
		assertEquals(matriuaux[2][6],INEXPLORAT);
		assertEquals(matriuaux[1][1],INEXPLORAT);
		assertEquals(matriuaux[1][4],INEXPLORAT);
		assertEquals(matriuaux[2][8],INEXPLORAT);
		
		
		
		
		
	}
	
	@Test 
	public void testGetBoat()
	{
		
		Taulell t= new Taulell(10,10);
		
		t.colocaVaixell(1, 2, 5, false);
		
		//frontera
		assertEquals(t.getLlistaVaixells()[0], t.getBoat(1, 2) );
		assertEquals(t.getLlistaVaixells()[0], t.getBoat(5, 2) );
		
		//limits interiors
		assertEquals(t.getLlistaVaixells()[0], t.getBoat(2, 2) );
		assertEquals(t.getLlistaVaixells()[0], t.getBoat(4, 2) );
		
		//valor interior
		assertEquals(t.getLlistaVaixells()[0], t.getBoat(3, 2) );
		
		t.colocaVaixell(4, 7, 2, true);
		
		//frontera
		assertEquals(t.getLlistaVaixells()[1], t.getBoat(4, 7) );
		assertEquals(t.getLlistaVaixells()[1], t.getBoat(4, 8) );
		
		//limits exteriors
		assertEquals(null, t.getBoat(4, 6) );
		assertEquals(null, t.getBoat(4, 9) );
	}
}
