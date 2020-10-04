package ai.sahaj.cleanstrike.carromtest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ai.sahaj.cleanstrike.carrom.Carrom;
import ai.sahaj.cleanstrike.carrom.Colors;
import ai.sahaj.cleanstrike.carrom.StrikeTypes;

class CoinTest {

	public Carrom Carrom;
	
	@BeforeEach
	void init()
	{
		Carrom = new Carrom(1, 9);
	}
	
	@Test
	@DisplayName("Black coin count must decrease by one")
	void mustDecrementBlackCoin()
	{
		Carrom.decrement(1,Colors.BLACK);
		assertEquals(8, Carrom.getAvailableBlackCoins());
	}
	
	@Test
	@DisplayName("Red coin count must decrease by one")
	void mustDecrementRedCoin()
	{
		Carrom.decrement(1,Colors.RED);
		assertEquals(0, Carrom.getAvailableRedCoins());
	}

}
