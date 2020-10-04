package ai.sahaj.cleanstrike.carromtest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ai.sahaj.cleanstrike.carrom.Coins;
import ai.sahaj.cleanstrike.carrom.Colors;
import ai.sahaj.cleanstrike.carrom.StrikeTypes;

class CoinTest {

	public Coins coins;
	
	@BeforeEach
	void init()
	{
		coins = new Coins(1, 9);
	}
	
	@Test
	@DisplayName("Black coin count must decrease by one")
	void mustDecrementBlackCoin()
	{
		coins.decrement(1,Colors.BLACK);
		assertEquals(8, coins.getAvailableBlackCoins());
	}
	
	@Test
	@DisplayName("Red coin count must decrease by one")
	void mustDecrementRedCoin()
	{
		coins.decrement(1,Colors.RED);
		assertEquals(0, coins.getAvailableRedCoins());
	}

}
