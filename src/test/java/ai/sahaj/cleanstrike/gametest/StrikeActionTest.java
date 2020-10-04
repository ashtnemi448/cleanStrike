package ai.sahaj.cleanstrike.gametest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ai.sahaj.cleanstrike.carrom.Coins;
import ai.sahaj.cleanstrike.exception.NoAvailableBlackCoins;
import ai.sahaj.cleanstrike.game.StrikeAction;
import ai.sahaj.cleanstrike.player.Player;

class StrikeActionTest {

	Player player1; 
	Player player2; 
	Coins coins;
	
	@BeforeEach
	public void init()
	{
		player1 = new Player(1);
		player2 = new Player(2);
		coins = new Coins(1, 9);
	}
	
	@AfterEach
	public void destroy()
	{
		player1 =null;
		player2 =null;
		coins =null;
	}
	
	@Test
	public void mustThrowNoAvailableBlackCoins()
	{
		Exception exception=null;
		try 
		{
			coins.setAvailableBlackCoins(0);
			StrikeAction strikeAction = new StrikeAction();
			strikeAction.strike(player1, coins);
		}
		catch (Exception e) 
		{
			exception = e;
		}
		
		assertNull(exception);
	}
	
	@Test
	@DisplayName("Strike Must increase points by 1 and decrease black coins by 1")
	public void strikeTest() 
	{
		StrikeAction strikeAction = new StrikeAction();
		strikeAction.strike(player1, coins);
		assertEquals(1, player1.getPoints());
		assertEquals(8, coins.getAvailableBlackCoins());
	}
	
	@Test
	@DisplayName("Red Strike Must increase points by 3 and decrease red coins by 1")
	public void  redStrikeTest() 
	{
		StrikeAction strikeAction = new StrikeAction();
		strikeAction.redStrike(player1, coins);
		assertEquals(3, player1.getPoints());
		assertEquals(0, coins.getAvailableRedCoins());
	}

	@Test
	@DisplayName("Multi Strike Must increase points by 3 and decrease red coins by 1")
	public void  multiStrikeTest() 
	{
		StrikeAction strikeAction = new StrikeAction();
		strikeAction.multiStrike(player1, coins);
		assertEquals(2, player1.getPoints());
		assertEquals(7, coins.getAvailableBlackCoins());
	}

}
