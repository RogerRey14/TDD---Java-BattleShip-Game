
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int Matriu[][] = new int[10][10];
		int mida_vertical = 10;
		int mida_horitzontal = 10;

		
		String taulell = "";
		taulell = taulell+("    | A | B | C | D | E | F | G | H | I | J | \n");
		for (int i = 0; i < mida_vertical; i++) {
			taulell = taulell+("----|---|---|---|---|---|---|---|---|---|---| \n");
			if(i<9) {
				taulell = taulell+" ";
			}
			taulell = taulell+(" " + (i+1) + " |");
			for (int j = 0; j < mida_horitzontal; j++)
			{
				taulell = taulell+(" " + Matriu[i][j] + " |");
			}
			taulell = taulell + "\n";
		}	
		taulell = taulell+("----|---|---|---|---|---|---|---|---|---|---| \n");
		
		
		System.out.print(taulell);
	}

}
