package ai.sahaj.cleanstrike;

import java.io.IOException;
import java.util.List;
import ai.sahaj.cleanstrike.exception.InputException;
import ai.sahaj.cleanstrike.game.Playground;
import ai.sahaj.cleanstrike.input.InputParser;
import ai.sahaj.cleanstrike.input.RandomizedInput;
import ai.sahaj.cleanstrike.carrom.Coins;
import ai.sahaj.cleanstrike.carrom.StrikeType;
import ai.sahaj.cleanstrike.player.Player;

public class Main 
{
	public static void main(String... args) throws IOException 
	{
		InputParser inputParser = new InputParser();
		Playground playground = new Playground();
		Player player1 = new Player(1);
		Player player2 = new Player(2);
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
		
		Player winner = playground.playUtil(player1, player2, coins, queryList);
		
		System.out.println("##For Detailed Game Stats look into file \"gameStats.txt\"##");
		if (winner == null) 
		{
			System.out.println("\nVerdict:- \n\tIts a Tie");
			return;
		}
		System.out.print("\nVerdict:- \n\tWinner is Player" + winner.getId()+" by {"+ player1.getPoints()+"} - {"+player2.getPoints()+"}");
		
		
		return;
	}
}
