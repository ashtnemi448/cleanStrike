package ai.sahaj.cleanstrike.input;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import ai.sahaj.cleanstrike.carrom.StrikeType;

public class RandomizedInput
{

	public List<StrikeType> generateRandomInputList(int size) throws IOException
	{
		List<StrikeType> strikeTypesList = new ArrayList<StrikeType>(Arrays.asList(StrikeType.values()));
		InputParser inputParser = new InputParser();
		Random rand = new Random(); 
		FileWriter fw=new FileWriter("randomInput.txt");    
    
		for (int i = 0; i < size; i++) 
		{
			int itr = rand.nextInt(strikeTypesList.size());
			StrikeType strikeType = strikeTypesList.get(itr);
			fw.write(String.valueOf(strikeType));
			fw.write("\n");
			fw.flush();
		}
		fw.close();
		return inputParser.parseInputTestCase("randomInput.txt");
	}

}
