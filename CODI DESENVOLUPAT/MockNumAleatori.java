
public class MockNumAleatori extends NumAleatori{

	private static int valors[] = {0,0,1,2,0,1,7,4,0,6,3,1};
	private static int i=-1;
	
	 public static int generaNumeroAleatori(int minimo,int maximo){
	     
		 i++;
		 return valors[i];
		 
	 }
	
}
