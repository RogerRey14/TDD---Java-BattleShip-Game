import static org.junit.Assert.*;

import org.junit.Test;
import java.lang.String;

public class TaulellTest {

	
	//Test de caixa negra per comprovar que el taulell s'ha construit correctament.
	@Test
	public void testTaulell() {
		
		//constructor testing

		Taulell taulell= new Taulell(10,10);

		
		String taulell_copia = ("    | A | B | C | D | E | F | G | H | I | J | \n")+("----|---|---|---|---|---|---|---|---|---|---| \n")+
				("  1 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | \n")+("----|---|---|---|---|---|---|---|---|---|---| \n")+
				("  2 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | \n")+("----|---|---|---|---|---|---|---|---|---|---| \n")+
				("  3 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | \n")+("----|---|---|---|---|---|---|---|---|---|---| \n")+
				("  4 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | \n")+("----|---|---|---|---|---|---|---|---|---|---| \n")+
				("  5 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | \n")+("----|---|---|---|---|---|---|---|---|---|---| \n")+
				("  6 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | \n")+("----|---|---|---|---|---|---|---|---|---|---| \n")+
				("  7 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | \n")+("----|---|---|---|---|---|---|---|---|---|---| \n")+
				("  8 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | \n")+("----|---|---|---|---|---|---|---|---|---|---| \n")+
				("  9 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | \n")+("----|---|---|---|---|---|---|---|---|---|---| \n")+
				(" 10 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | \n")+("----|---|---|---|---|---|---|---|---|---|---| \n");
	 	
		assertEquals(taulell.get_string_taulell(), taulell_copia);
		
	}
	
	//test de caixa negre per comprovar que els vaixells s'han colocat correctament dins la matriu
	@Test
	public void testColocarVaixells ()
	{
	
		Taulell taulell = new Taulell(10,10);

		taulell.colocaVaixell(1, 2, 2, false);
		taulell.colocaVaixell(2, 5, 3, true);
		taulell.colocaVaixell(4, 1, 4, true);
		taulell.colocaVaixell(6, 1, 5, true);

		
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

	}

}
