package ai.sahaj.cleanstrike.game;

import ai.sahaj.cleanstrike.carrom.Colors;
import ai.sahaj.cleanstrike.exception.InputException;
import ai.sahaj.cleanstrike.exception.NoAvailableBlackCoinsException;
import ai.sahaj.cleanstrike.exception.NoAvailableRedCoinsException;
import ai.sahaj.cleanstrike.exception.NoCoinsOnBoardException;
import ai.sahaj.cleanstrike.carrom.Carrom;
import ai.sahaj.cleanstrike.player.Player;
import ai.sahaj.cleanstrike.statistics.GameStats;

public class StrikeAction 
{
	/*
	 * When player pockets 1 coin Assumption - This coin is black coin
	 */
	public void strike(Player player, Carrom Carrom) 
	{
		if (Carrom.getAvailableBlackCoins() >= 1) 
		{
			player.incrementPoints(1);
			Carrom.decrement(1, Colors.BLACK);
		}
		else
		{
			try
			{
				throw new NoAvailableBlackCoinsException("Chance wasted as sufficient black Carrom are not available");
			} 
			catch (Exception e) 
			{
				GameStats.commentString = e.getLocalizedMessage();
			}
		}
		player.setConsecutiveLoseCountToZero();
	}

	/*
	 * When player pockets more than 1 coin Assumption - pocketed Carrom are only
	 * black Carrom
	 */
	public void multiStrike(Player player, Carrom Carrom) 
	{
		if (Carrom.getAvailableBlackCoins() >= 2) 
		{
			player.incrementPoints(2);
			/*
			 * All, but 2 Carrom, that were pocketed, get back on to the Carrom-board
			 */
			Carrom.restoreToDefault();
			Carrom.decrement(2, Colors.BLACK);
		}
		else
		{
			try
			{
				throw new NoAvailableBlackCoinsException("Chance wasted as sufficient black Carrom are not available");
			} 
			catch (Exception e) 
			{
				GameStats.commentString = e.getLocalizedMessage();
			}
		}
		player.setConsecutiveLoseCountToZero();
	}

	/*
	 * When player pockets a red coin and 0 or more black Carrom
	 */
	public void redStrike(Player player, Carrom Carrom) 
	{
		if (Carrom.getAvailableRedCoins() > 0) 
		{
			player.incrementPoints(3);
			/*
			 * If black Carrom are pocketed along with red coin in the same turn, black Carrom
			 * get back on to the Carrom-board
			 */
			Carrom.decrement(1, Colors.RED);
		}
		else
		{
			try
			{
				throw new NoAvailableRedCoinsException("Chance wasted as sufficient red Carrom are not available");
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
	public void defunctCoin(Player player, Carrom Carrom) 
	{
		if ( Carrom.getAvailableBlackCoins() > 0)
		{
			player.decrementPoints(2);
			player.incrementFoulCount();
			Carrom.decrement(1, Colors.BLACK);
			int curConsecutiveLoseCount = player.getConsecutiveLoseCount();
			player.setConsecutiveLoseCount(++curConsecutiveLoseCount);
		}
		else
		{
			try
			{
				throw new NoCoinsOnBoardException("Chance wasted as sufficient black Carrom are not available");
			} 
			catch (Exception e) 
			{
				GameStats.commentString = e.getLocalizedMessage();
			}
		}
	}
}
