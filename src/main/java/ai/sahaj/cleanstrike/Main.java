package ai.sahaj.cleanstrike;

import java.io.IOException;
import java.util.List;
import ai.sahaj.cleanstrike.exception.InputException;
import ai.sahaj.cleanstrike.game.Game;
import ai.sahaj.cleanstrike.game.GameRulesImplementation;
import ai.sahaj.cleanstrike.input.InputParser;
import ai.sahaj.cleanstrike.input.RandomizedInput;
import ai.sahaj.cleanstrike.carrom.StrikeTypes;
import ai.sahaj.cleanstrike.carrom.Carrom;
import ai.sahaj.cleanstrike.player.Player;

public class Main 
{
	public static void main(String... args) throws IOException 
	{
		InputParser inputParser = new InputParser();
		Game game = new Game();
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		Carrom Carrom = new Carrom(1, 9);

		RandomizedInput randomizedInput = new RandomizedInput();
		
//		This generates a testcase file "randomInput.txt" inputParser root directory 
//		List<StrikeTypes> queryList = randomizedInput.generateRandomInputList(18);

//		testcase.txt is a sample testcase file
		List<StrikeTypes> queryList = inputParser.parseInputTestCase("SampleTestcase.txt");
		
		game.startGame(player1, player2, Carrom, queryList);
		GameRulesImplementation gameRulesImplementation = new GameRulesImplementation();
		
		Player winner = gameRulesImplementation.ruleToChooseWinner(player1, player2);
				
		System.out.println("##For Detailed Game Stats look into file \"gameStats.txt\" in root directory##");
		System.out.println("\n\nPlayer1 score : "+ player1.getPoints());
		System.out.println("Player1 score : "+ player2.getPoints());
		
		if (winner == null) 
		{
			
			if(player1.getPoints()!=player2.getPoints())
				System.out.println("\nVerdict:- \n\tIts a Tie <According to given rules though points are not same its a tie>");
			else 
				System.out.println("\nVerdict:- \n\tIts a Tie");
			return;
		}
		System.out.print("\nVerdict:-\n\tWinner is Player" + winner.getId());
		return;
	}
}
