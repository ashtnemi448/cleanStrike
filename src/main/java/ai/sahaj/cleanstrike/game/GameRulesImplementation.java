package ai.sahaj.cleanstrike.game;

import ai.sahaj.cleanstrike.player.Player;

public class GameRulesImplementation 
{
	static public Player chooseWinner(Player player1, Player player2)
	{
		if (player1.getPoints() > player2.getPoints()
				&& (player1.getPoints() >= 5 || player1.getPoints() - player2.getPoints() >= 3))
			return player1;

		if (player2.getPoints() > player1.getPoints()
				&& (player2.getPoints() >= 5 || player2.getPoints() - player1.getPoints() >= 3))
			return player2;

		return null;
	}
	
	static public boolean checkFor3ConsecutiveLoses(Player player) 
	{
		if (player.getConsecutiveLoseCount() == 3) 
		{
			player.setConsecutiveLoseCountToZero();
			return true;
		}
		return false;
	}

	static public boolean checkFor3Fouls(Player player) 
	{
		if (player.getFoul() == 3) 
		{
			player.setFoulCountToZero();
			return true;
		}
		return false;
	}
}
