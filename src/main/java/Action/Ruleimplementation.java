package Action;

import Constant.Color;
import Entities.Coins;
import Entities.Players;

public class Ruleimplementation 
{
	/*
	 * When player pockets 1 coin Assumption - This coin is black coin
	 */
	public void strike(Players player, Coins coins) 
	{
		if (coins.getAvailableBlackCoins() >= 1) 
		{
			player.incrementPoints(1);
			coins.decrement(1, Color.BLACK);
		}
		player.setConsecutiveLoseCountToZero();
	}

	/*
	 * When player pockets more than 1 coin Assumption - pocketed coins are only
	 * black coins
	 */
	public void multiStrike(Players player, Coins coins) 
	{
		if (coins.getAvailableBlackCoins() >= 2) 
		{
			player.incrementPoints(2);
			/*
			 * All, but 2 coins, that were pocketed, get back on to the carrom-board
			 */
			coins.restoreToDefault();
			coins.decrement(2, Color.BLACK);
		}
		player.setConsecutiveLoseCountToZero();
	}

	/*
	 * When player pockets a red coin and 0 or more black coins
	 */
	public void redStrike(Players player, Coins coins) 
	{
		if (coins.getAvailableRedCoins() > 0) 
		{
			player.incrementPoints(3);
			/*
			 * If black coins are pocketed along with red coin in the same turn, black coins
			 * get back on to the carrom-board
			 */
			coins.decrement(1, Color.RED);
		}
		player.setConsecutiveLoseCountToZero();
	}

	/*
	 * When player pockets stricker
	 */
	public void strikerStrick(Players player) 
	{
		player.decrementPoints(1);
		player.incrementFoulCount();
		int curConsecutiveLoseCount = player.getConsecutiveLoseCount();
		player.setConsecutiveLoseCount(++curConsecutiveLoseCount);
	}

	/*
	 * When coin is thrown out of the board Assumption - thrown out coin is Black
	 * coin
	 */
	public void defunctCoin(Players player, Coins coins) 
	{
		if (coins.getAvailableRedCoins() > 0 || coins.getAvailableBlackCoins() > 0)
		{
			player.decrementPoints(2);
			player.incrementFoulCount();
			coins.decrement(1, Color.BLACK);
			int curConsecutiveLoseCount = player.getConsecutiveLoseCount();
			player.setConsecutiveLoseCount(++curConsecutiveLoseCount);
		}
	}
}
