package Main;

import java.io.IOException;
import java.util.List;

import Constant.StrikeType;
import Entities.Coins;
import Entities.Players;
import Exception.InputException;
import Input.InputParser;
import Input.RandomizedInput;
import Playground.Playground;

public class StartApplication 
{
	public static void main(String... args) throws IOException 
	{
		InputParser inputParser = new InputParser();
		Playground playground = new Playground();
		Players player1 = new Players(1);
		Players player2 = new Players(2);
		Coins coins = new Coins(1, 9);

		RandomizedInput randomizedInput = new RandomizedInput();
		
//		This generates a testcase file "randomInput.txt" inputParser root directory 
		List<StrikeType> queryList = randomizedInput.generateRandomInputList(18);

//		testcase.txt is a sample testcase file
//		List<StrikeType> queryList = inputParser.parseInputTestCase("testcase.txt");
		
		try 
		{
			if (queryList.size()==0)
				throw new InputException("File is empty");
		} catch (Exception e) 
		{
			System.out.println("Exception occured: "+e); 
			return;
		}
		
		Players winner = playground.playUtil(player1, player2, coins, queryList);
		
		System.out.println("##For Detailed Game Stats look into file \"gameStats.txt\"##");
		if (winner == null) 
		{
			System.out.println("\nVerdict:- \n\tIts a Tie");
			return;
		}
		System.out.print("\nVerdict:- \n\tWinner is Player" + winner.getId());
		
		
		return;
	}
}
