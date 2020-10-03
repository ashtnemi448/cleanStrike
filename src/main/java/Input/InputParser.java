package Input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Constant.StrikeType;

public class InputParser 
{

	public List<StrikeType> parseInputTestCase(String fileName) throws IOException
	{
		List<StrikeType> queryList = new ArrayList<StrikeType>();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
	    String line;
	    
	    while ((line = br.readLine()) != null) 
	    {
	       StrikeType strikeType = StrikeType.valueOf(line);
	       queryList.add(strikeType);
	    }
	    
		return queryList;
	}
}
