
public class MockNumAleatori extends NumAleatori{

	private int valors[] = {0,0,1,2,0,1,7,4,0,6,3,1};
	private int i;
	
	public MockNumAleatori() {
		this.i = -1;
	}
	
	public void restart() {
		this.i = -1;
	}
	
	
	public int generaNumeroAleatori(int minimo,int maximo){
	     
		 i++;
		 return valors[i];
		 
	 }
	
}
