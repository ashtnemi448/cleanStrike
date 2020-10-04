package ai.sahaj.cleanstrike.gametest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ai.sahaj.cleanstrike.player.Player;
import ai.sahaj.cleanstrike.game.GameRulesImplementation;


class GameRuleImplementationTest 
{
	@Test
	@DisplayName("Winner must have atleast 5 points and lead with 3 points")
	public void winnerWithPointsLessThan5MustNotWin()
	{
		Player player1 = new Player(1);
		player1.setPoints(4);
		
		Player player2 = new Player(2);
		player2.setPoints(1);
		assertNull(GameRulesImplementation.chooseWinner(player1, player2));
	} 	

	@Test
	@DisplayName("3 consecutive loses must decrease point by 1")
	public void onePointMustDecreaseForThreeConsecutiveLoses()
	{
		Player player1 = new Player(1);
		player1.setConsecutiveLoseCount(3);
		player1.setPoints(5);
		
		Player player2 = new Player(2);
		player2.setConsecutiveLoseCount(2);
		player2.setPoints(5);
		
		GameRulesImplementation.checkFor3ConsecutiveLoses(player1);
		GameRulesImplementation.checkFor3ConsecutiveLoses(player2);
		
		assertEquals(4,player1.getPoints());
		assertEquals(5,player2.getPoints());
	}
	
	@Test
	@DisplayName("3 fouls must decrease point by 1")
	public void onePointMustDecreaseForThreeFouls()
	{
		Player player1 = new Player(1);
		player1.setFoul(3);
		player1.setPoints(5);
		
		Player player2 = new Player(2);
		player2.setFoul(2);
		player2.setPoints(5);
		
		GameRulesImplementation.checkFor3Fouls(player1);
		GameRulesImplementation.checkFor3Fouls(player2);
		
		assertEquals(4,player1.getPoints());
		assertEquals(5,player2.getPoints());
	}
}
