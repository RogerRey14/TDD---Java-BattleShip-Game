import java.io.IOException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException {
	
	Taulell t=new Taulell(10,10);
	Taulell t2=new Taulell(10,10);	
	Joc joc=new Joc(t,t2);
	
	joc.preparaTaulells();
	
	}

}
