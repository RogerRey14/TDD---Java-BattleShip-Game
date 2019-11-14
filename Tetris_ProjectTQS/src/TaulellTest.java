import static org.junit.Assert.*;

import org.junit.Test;
import java.lang.String;

public class TaulellTest {

	
	@Test
	public void test() {
		
		//constructor testing
		System.out.print("\n\n");
		
		Taulell taulell= new Taulell(10,25);
		
		//System.out.print(taulell.get_string_taulell());
		
		//System.out.print("\n\n");
		
		String taulell_copia = new String( "----------\n----------\n----------\n----------\n----------\n----------\n----------\n----------\n----------\n----------\n----------\n----------\n----------\n----------\n----------\n----------\n----------\n----------\n----------\n----------\n----------\n----------\n----------\n----------\n----------");
		
		//System.out.print(taulell_copia);
		
		assertTrue(taulell.get_string_taulell().equals(taulell_copia));
		
	}

}
