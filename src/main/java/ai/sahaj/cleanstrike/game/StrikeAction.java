package ai.sahaj.cleanstrike.game;

import ai.sahaj.cleanstrike.carrom.Colors;
import ai.sahaj.cleanstrike.exception.InputException;
import ai.sahaj.cleanstrike.exception.NoAvailableBlackCoins;
import ai.sahaj.cleanstrike.exception.NoAvailableRedCoins;
import ai.sahaj.cleanstrike.exception.NoCoinsOnBoard;
import ai.sahaj.cleanstrike.carrom.Coins;
import ai.sahaj.cleanstrike.player.Player;
import ai.sahaj.cleanstrike.statistics.GameStats;

public class StrikeAction 
{
	/*
	 * When player pockets 1 coin Assumption - This coin is black coin
	 */
	public void strike(Player player, Coins coins) 
	{
		if (coins.getAvailableBlackCoins() >= 1) 
		{
			player.incrementPoints(1);
			coins.decrement(1, Colors.BLACK);
		}
		else
		{
			try
			{
				throw new NoAvailableBlackCoins("Chance wasted as sufficient black coins are not available");
			} 
			catch (Exception e) 
			{
				GameStats.commentString = e.getLocalizedMessage();
			}
		}
		player.setConsecutiveLoseCountToZero();
	}

	/*
	 * When player pockets more than 1 coin Assumption - pocketed coins are only
	 * black coins
	 */
	public void multiStrike(Player player, Coins coins) 
	{
		if (coins.getAvailableBlackCoins() >= 2) 
		{
			player.incrementPoints(2);
			/*
			 * All, but 2 coins, that were pocketed, get back on to the carrom-board
			 */
			coins.restoreToDefault();
			coins.decrement(2, Colors.BLACK);
		}
		else
		{
			try
			{
				throw new NoAvailableBlackCoins("Chance wasted as sufficient black coins are not available");
			} 
			catch (Exception e) 
			{
				GameStats.commentString = e.getLocalizedMessage();
			}
		}
		player.setConsecutiveLoseCountToZero();
	}

	/*
	 * When player pockets a red coin and 0 or more black coins
	 */
	public void redStrike(Player player, Coins coins) 
	{
		if (coins.getAvailableRedCoins() > 0) 
		{
			player.incrementPoints(3);
			/*
			 * If black coins are pocketed along with red coin in the same turn, black coins
			 * get back on to the carrom-board
			 */
			coins.decrement(1, Colors.RED);
		}
		else
		{
			try
			{
				throw new NoAvailableRedCoins("Chance wasted as sufficient red coins are not available");
			} 
			catch (Exception e) 
			{
				GameStats.commentString = e.getLocalizedMessage();
			}
		}
		player.setConsecutiveLoseCountToZero();
	}

	/*
	 * When player pockets stricker
	 */
	public void strikerStrick(Player player) 
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
	public void defunctCoin(Player player, Coins coins) 
	{
		if ( coins.getAvailableBlackCoins() > 0)
		{
			player.decrementPoints(2);
			player.incrementFoulCount();
			coins.decrement(1, Colors.BLACK);
			int curConsecutiveLoseCount = player.getConsecutiveLoseCount();
			player.setConsecutiveLoseCount(++curConsecutiveLoseCount);
		}
		else
		{
			try
			{
				throw new NoCoinsOnBoard("Chance wasted as sufficient black coins are not available");
			} 
			catch (Exception e) 
			{
				GameStats.commentString = e.getLocalizedMessage();
			}
		}
	}
}
