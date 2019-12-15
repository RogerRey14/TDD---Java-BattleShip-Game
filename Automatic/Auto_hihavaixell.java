import static org.junit.Assert.*;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class Auto_hihavaixell 
{
	@Test
	public void testhihavaixell()
	{
		//Lectura del archivo
		List<List<String>> listOLists = new ArrayList<List<String>>();
		ArrayList<String> subList = new ArrayList<String>();
		int index=0;
		String aux;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("Automatic/testTaulell_hihaVaixell.txt"));
			String line = reader.readLine();
			while (line != null) 
			{
				//System.out.println(line);
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
		Taulell taulell = new Taulell(Integer.parseInt((listOLists.get(indeY).get(indeX))), Integer.parseInt((listOLists.get(indeY).get(indeX++))));
		indeY++;
		for(int i=0; i<10; i++)
		{
			indeX=0;
			for(int u=0; u<10;u++,indeX++)
			{
				taulell.modificaMatriu(Integer.parseInt((listOLists.get(indeY).get(indeX))), i, u);
			}
			indeY++;	
		}
		indeX=0;
		while(indeY<index)
		{
			System.out.println(listOLists.get(indeY).get(indeX));
			System.out.println(listOLists.get(indeY).get(indeX+1));
			System.out.println(listOLists.get(indeY+1).get(indeX));
			assertEquals( taulell.hihaVaixell(Integer.parseInt(listOLists.get(indeY).get(indeX)), Integer.parseInt(listOLists.get(indeY).get(indeX+1))) , Boolean.parseBoolean(listOLists.get(indeY+1).get(indeX)));
			indeY=2+indeY;
		}
	}
	
}
