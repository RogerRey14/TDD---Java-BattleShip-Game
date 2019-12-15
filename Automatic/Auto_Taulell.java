import static org.junit.Assert.*;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class Auto_Taulell 
{
	@Test
	public void testTraductor()
	{
		//Lectura del archivo
		List<List<String>> listOLists = new ArrayList<List<String>>();
		ArrayList<String> subList = new ArrayList<String>();
		String aux;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("Automatic/testTaulell_traductor.txt"));
			String line = reader.readLine();
			while (line != null) 
			{
				aux = line.substring(1,line.length()-1);
				String[] values = aux.split(",");
				for(int i=0;i<values.length;i++)
				{
					subList.add(values[i]);
				}
				listOLists.add(List.copyOf(subList));
				subList.clear();
				//read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int indeX=0;
		int indeY=0;
		
		//Comenzamos el test
		System.out.println(listOLists.get(indeY).get(indeX));
		System.out.println(listOLists.get(indeY).get(1));
		Taulell taulell = new Taulell(Integer.parseInt((listOLists.get(indeY).get(indeX))), Integer.parseInt((listOLists.get(indeY).get(indeX++))));
		
		indeX=0;
		for(;indeX < listOLists.get(indeY+1).size();indeX++) {
			char c=(listOLists.get(indeY+2).get(indeX)).charAt(0);
			System.out.println(taulell.traductor(Integer.parseInt(listOLists.get(indeY+1).get(indeX))));
			System.out.println(c);
		assertEquals( taulell.traductor(Integer.parseInt(listOLists.get(indeY+1).get(indeX))) , c);
		}
	}
	
}
