package Main;

import java.io.IOException;
import java.util.List;
import Constant.StrikeType;
import Entities.Coins;
import Entities.Players;
import Playground.Playground;
import Statistics.GameStats;

public class StartApplication 
{
	public static void main(String... args) throws IOException 
	{
		InputParser inputParser = new InputParser();
		Playground playground = new Playground();
		Players player1 = new Players(1);
		Players player2 = new Players(2);
		Coins coins = new Coins(1, 9);

		List<StrikeType> queryList = inputParser.parseInputTestCase("testcase.txt");

		if (queryList == null)
			System.out.println("File is empty");

		Players winner = playground.playUtil(player1, player2, coins, queryList);

		if (winner == null) 
		{
			System.out.println("Its a draw");
			return;
		}
		System.out.print("Winner is Player" + winner.getId());
		
		System.out.println("\n## For Detailed Game Stats look into file \"gameStats.txt\" ##");
		
		return;
	}
}
