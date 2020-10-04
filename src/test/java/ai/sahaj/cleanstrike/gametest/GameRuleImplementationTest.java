package ai.sahaj.cleanstrike.gametest;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.ReadOnlyBufferException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ai.sahaj.cleanstrike.player.Player;
import ai.sahaj.cleanstrike.carrom.Carrom;
import ai.sahaj.cleanstrike.carrom.StrikeTypes;
import ai.sahaj.cleanstrike.game.GameRulesImplementation;
import ai.sahaj.cleanstrike.game.GameUtilities;


class GameRuleImplementationTest 
{
	Carrom Carrom;
	
	@BeforeEach
	void init()
	{
		Carrom = new Carrom(1, 9);
	}
	
	@Test
	@DisplayName("Winner must have atleast 5 points and lead with 3 points")
	public void winnerWithPointsLessThan5MustNotWin()
	{
		Player player1 = new Player(1);
		player1.setPoints(4);
		
		Player player2 = new Player(2);
		player2.setPoints(1);

		GameRulesImplementation gameRulesImplementation = new GameRulesImplementation();
		
		assertNull(gameRulesImplementation.ruleToChooseWinner(player1, player2));
	} 	

	@Test
	@DisplayName("3 consecutive loses must decrease point by 1")
	public void onePointMustDecreaseForThreeConsecutiveLoses()
	{
		GameUtilities gameUtilities = new GameUtilities();
		
//		3 consecutive loses
		Player player1 = new Player(1);
		player1.setPoints(5);
		gameUtilities.performStrikeAction(player1, StrikeTypes.STRICKERSTRICK, Carrom);
		gameUtilities.performStrikeAction(player1, StrikeTypes.STRICKERSTRICK, Carrom);
		gameUtilities.performStrikeAction(player1, StrikeTypes.STRICKERSTRICK, Carrom);
		
		
		
//		Only 2 consecutive loses
		Player player2 = new Player(2);
		player2.setPoints(5);
		gameUtilities.performStrikeAction(player2, StrikeTypes.STRICKERSTRICK, Carrom);
		gameUtilities.performStrikeAction(player2, StrikeTypes.STRICKERSTRICK, Carrom);
		gameUtilities.performStrikeAction(player2, StrikeTypes.STRIKE, Carrom);
		
		
		GameRulesImplementation gameRulesImplementation = new GameRulesImplementation();
		
		gameRulesImplementation.ruleForConsecutiveLoses(player1);
		gameRulesImplementation.ruleForConsecutiveLoses(player2);
		
		assertEquals(1,player1.getPoints());
		assertEquals(4,player2.getPoints());
	}
	
	@Test
	@DisplayName("3 fouls must decrease point by 1")
	public void onePointMustDecreaseForThreeFouls()
	{
		GameUtilities gameUtilities = new GameUtilities();
		
		//this result in 1 foul
		Player player1 = new Player(1);
		player1.setPoints(5);
		gameUtilities.performStrikeAction(player1, StrikeTypes.STRICKERSTRICK, Carrom);
		gameUtilities.performStrikeAction(player1, StrikeTypes.STRICKERSTRICK, Carrom);
		gameUtilities.performStrikeAction(player1, StrikeTypes.STRICKERSTRICK, Carrom);
		
		//This results in no foul
		Player player2 = new Player(2);
		player2.setPoints(5);
		gameUtilities.performStrikeAction(player2, StrikeTypes.STRICKERSTRICK, Carrom);
		gameUtilities.performStrikeAction(player2, StrikeTypes.STRICKERSTRICK, Carrom);
		
		GameRulesImplementation gameRulesImplementation = new GameRulesImplementation();
		
		gameRulesImplementation.ruleForFouls(player1);
		gameRulesImplementation.ruleForFouls(player2);
		
		assertEquals(1,player1.getPoints());
		assertEquals(3,player2.getPoints());
	}
}
