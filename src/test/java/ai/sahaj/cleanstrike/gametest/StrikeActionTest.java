package ai.sahaj.cleanstrike.gametest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ai.sahaj.cleanstrike.carrom.Carrom;
import ai.sahaj.cleanstrike.exception.NoAvailableBlackCoinsException;
import ai.sahaj.cleanstrike.game.StrikeAction;
import ai.sahaj.cleanstrike.player.Player;

class StrikeActionTest {

	Player player1; 
	Player player2; 
	Carrom Carrom;
	
	@BeforeEach
	public void init()
	{
		player1 = new Player(1);
		player2 = new Player(2);
		Carrom = new Carrom(1, 9);
	}
	
	@Test
	@DisplayName("Must throw NoAvailableRedCoinsException exception if no black Carrom on board")
	public void mustThrowNoAvailableBlackCoinsException()
	{
		Exception exception=null;
		try 
		{
			Carrom.setAvailableBlackCoins(0);
			StrikeAction strikeAction = new StrikeAction();
			strikeAction.strike(player1, Carrom);
		}
		catch (Exception e) 
		{
			exception = e; //null is returned by strike() when exception occurs
		}
		
		assertNull(exception);
	}
	
	@Test
	@DisplayName("Must throw NoAvailableRedCoinsException exception if no red Carrom on board")
	public void mustThrowNoAvailableRedCoins()
	{
		Exception exception=null;
		try 
		{
			Carrom.setAvailableRedCoins(0);
			StrikeAction strikeAction = new StrikeAction();
			strikeAction.redStrike(player1, Carrom);
		}
		catch (Exception e) 
		{
			exception = e;//null is returned by redStrike() when exception occurs
		}
		
		assertNull(exception);
	}
	
	@Test
	@DisplayName("Strike Must increase points by 1 and decrease black Carrom by 1")
	public void strikeTest() 
	{
		StrikeAction strikeAction = new StrikeAction();
		strikeAction.strike(player1, Carrom);
		assertEquals(1, player1.getPoints());
		assertEquals(8, Carrom.getAvailableBlackCoins());
	}
	
	@Test
	@DisplayName("Red Strike Must increase points by 3 and decrease red Carrom by 1")
	public void  redStrikeTest() 
	{
		StrikeAction strikeAction = new StrikeAction();
		strikeAction.redStrike(player1, Carrom);
		assertEquals(3, player1.getPoints());
		assertEquals(0, Carrom.getAvailableRedCoins());
	}

	@Test
	@DisplayName("Multi Strike Must increase points by 3 and decrease red Carrom by 1")
	public void  multiStrikeTest() 
	{
		StrikeAction strikeAction = new StrikeAction();
		strikeAction.multiStrike(player1, Carrom);
		assertEquals(2, player1.getPoints());
		assertEquals(7, Carrom.getAvailableBlackCoins());
	}
	
	@Test
	@DisplayName("Stricker Strike Must decrease points by 1 and should not decrease any Carrom")
	public void  strikerStrickTest() 
	{
		StrikeAction strikeAction = new StrikeAction();
		strikeAction.strikerStrick(player1);
		assertEquals(-1, player1.getPoints());
		
		assertEquals(9, Carrom.getAvailableBlackCoins());
		assertEquals(1, Carrom.getAvailableRedCoins());
	}
	
	@Test
	@DisplayName("Defunct Coin Must decrease points by 2 and should decrease black Carrom by 1")
	public void  defunctCoinTest() 
	{
		StrikeAction strikeAction = new StrikeAction();
		strikeAction.defunctCoin(player1, Carrom);
		assertEquals(-2, player1.getPoints());
		assertEquals(8, Carrom.getAvailableBlackCoins());
		assertEquals(1, Carrom.getAvailableRedCoins());
	}

}
