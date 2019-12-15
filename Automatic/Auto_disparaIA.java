import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Auto_disparaIA 
{

	@Test
	public void testdisparaIA()
	{
		//Lectura del archivo
		List<List<String>> listOLists = new ArrayList<List<String>>();
		ArrayList<String> subList = new ArrayList<String>();
		int index=0;
		String aux;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("Automatic/testTaulell_disparaIA.txt"));
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
		Taulell j1 = new Taulell(Integer.parseInt((listOLists.get(indeY).get(indeX))), Integer.parseInt((listOLists.get(indeY).get(indeX++))));
		indeY++;
		Taulell ia = new Taulell(Integer.parseInt((listOLists.get(indeY).get(indeX))), Integer.parseInt((listOLists.get(indeY).get(indeX++))));
		indeY++;
		for(int i=0; i<10; i++)
		{
			indeX=0;
			for(int u=0; u<10;u++,indeX++)
			{
				j1.modificaMatriu(Integer.parseInt((listOLists.get(indeY).get(indeX))), i, u);
			}
			indeY++;	
		}
		indeX=0;
		while(indeY<16)
		{
			j1.colocaVaixell(Integer.parseInt(listOLists.get(indeY).get(indeX)), Integer.parseInt(listOLists.get(indeY).get(indeX+1)), Integer.parseInt(listOLists.get(indeY).get(indeX+2)), Boolean.parseBoolean(listOLists.get(indeY).get(indeX+3)));
			indeY++;
		}
		MockNumAleatori rand = new MockNumAleatori();
		MockNumAleatori pos = new MockNumAleatori();
		ia.setRandom(rand);
		ia.creaTaulellIA();
		ia.setRandom(pos);
		System.out.println(listOLists.get(indeY-1));
		indeX=0;
		while(indeY<index)
		{
			System.out.println(listOLists.get(indeY).get(indeX));
			//System.out.println(listOLists.get(indeY).get(indeX+1));
			//System.out.println(listOLists.get(indeY+1).get(indeX));
			assertEquals(ia.IAdispara(j1), Boolean.parseBoolean(listOLists.get(indeY).get(indeX)));
			indeY++;
		}	
	}

}
