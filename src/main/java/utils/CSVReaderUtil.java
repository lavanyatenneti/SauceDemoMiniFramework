package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderUtil 
{

	public static List<String[]> readCSV(String filepath)
	{
		List<String[]> data=new ArrayList<>();
		String line;
		
		try(BufferedReader br=new BufferedReader(new FileReader(filepath)))
		{
			br.readLine();
			while((line=br.readLine())!=null)
			{
				data.add(line.split(","));
			}
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		return data;
				
	}
}
