package Action;

import static org.junit.Assert.*;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Entities.Coins;
import Entities.Players;


public class RuleImplementationTest {

	Players player1; 
	Players player2; 
	Coins coins; 
	
	@BeforeEach
	public void init()
	{
		player1 = new Players(1);
		player2 = new Players(2);
		coins = new Coins(1, 9);
	}
	
	@Test
	public void  strikeTest() 
	{
		Ruleimplementation ruleimplementation = new Ruleimplementation();
		ruleimplementation.strike(player1, coins);

		assertEquals(1, player1.getPoints());
		assertEquals(8, coins.getAvailableBlackCoins());
	}
	
	@Test
	public void  redStrikeTest() 
	{
		Ruleimplementation ruleimplementation = new Ruleimplementation();
		ruleimplementation.redStrike(player1, coins);

		assertEquals(3, player1.getPoints());
		assertEquals(9, coins.getAvailableBlackCoins());
		assertEquals(1, coins.getAvailableRedCoins());
	}

}
