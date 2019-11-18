import org.junit.Test;

public class MasterTest {
	
	@Test
	public void ExecutaTest() {
		
		BoaTest testBoat=new BoaTest();
		
		testBoat.afegeixCoordenadaTest();
		testBoat.testBoat();
		testBoat.DisparatTest();
		
		
		TestJoc testJoc=new TestJoc();
		
		testJoc.testJoc();
		testJoc.testAcabaJoc();
		testJoc.tradueixTest();
		testJoc.preparaTaulellsTest();
		testJoc.llegeixCoordenadesTest();
		
		TaulellTest testTaulell=new TaulellTest();
		
		testTaulell.testTaulell();
		testTaulell.testconstrueixTaulell();
		testTaulell.testhihaVaixell();
		testTaulell.testColocaVaixell();
		testTaulell.testTraductor();
		testTaulell.testcreaTaulellIA();
		testTaulell.testTraductorIA();
		testTaulell.testDispara();
		testTaulell.testIAdispara();
		testTaulell.testModificaMatriu();
		testTaulell.testGetBoat();
		
	}
	
}
