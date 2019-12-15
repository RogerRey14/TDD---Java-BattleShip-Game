import static org.junit.Assert.*;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class Auto_aux 
{
	@Test
	public void testTraductor()
	{
		//Lectura del archivo
		List<List<String>> listOLists = new ArrayList<List<String>>();
		ArrayList<String> subList = new ArrayList<String>();
		int index=0;
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
				index++;
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
		System.out.println(listOLists.get(1).get(0));
		Taulell taulell = new Taulell(Integer.parseInt((listOLists.get(indeY).get(indeX))), Integer.parseInt((listOLists.get(indeY).get(indeX++))));
		indeX=2;
		for(;indeX < listOLists.get(indeY+1).size();indeX++) {
			char c=(listOLists.get(indeY+2).get(indeX)).charAt(0);
		assertEquals( taulell.traductor(Integer.parseInt(listOLists.get(indeY+1).get(indeX))) , c);
		}
	}
	
}
