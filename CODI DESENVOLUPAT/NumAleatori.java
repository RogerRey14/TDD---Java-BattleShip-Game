

public class NumAleatori {
		 
	   public static int generaNumeroAleatori(int minimo,int maximo){
	        
	       int num=(int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo));
	       return num;
	   }
	    

}
