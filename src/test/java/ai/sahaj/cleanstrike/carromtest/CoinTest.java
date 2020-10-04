package ai.sahaj.cleanstrike.carromtest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
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
	void mustDecrementBlackCoin()
	{
		coins.decrement(1,Colors.BLACK);
		assertEquals(8, coins.getAvailableBlackCoins());
	}
	
	@Test
	void mustDecrementRedCoin()
	{
		coins.decrement(1,Colors.RED);
		assertEquals(0, coins.getAvailableRedCoins());
	}

}
