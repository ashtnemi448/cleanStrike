package ai.sahaj.cleanstrike.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ai.sahaj.cleanstrike.carrom.StrikeTypes;
import ai.sahaj.cleanstrike.exception.InputException;

public class InputParser 
{
	public List<StrikeTypes> parseInputTestCase(String fileName) throws IOException
	{
		
		List<StrikeTypes> queryList = new ArrayList<StrikeTypes>();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
	    String line;
	    
	    while ((line = br.readLine()) != null) 
	    {
	       StrikeTypes strikeType = StrikeTypes.valueOf(line);
	       queryList.add(strikeType);
	    }
	    
		try 
		{
			if (queryList.size()==0)
				throw new InputException("File is empty");
		} 
		catch (Exception e) 
		{
			//System.out.println("Exception occured: "+e); 
			return null;
		}
		
		return queryList;
	}
}
