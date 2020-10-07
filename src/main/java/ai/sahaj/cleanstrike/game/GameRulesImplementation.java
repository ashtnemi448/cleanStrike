package ai.sahaj.cleanstrike.game;

import ai.sahaj.cleanstrike.player.Player;

public class GameRulesImplementation implements GameRules
{
	
	public Player ruleToChooseWinner(Player player1, Player player2) 
	{
		if (player1.getPoints() > player2.getPoints()
				&& (player1.getPoints() >= 5 && player1.getPoints() - player2.getPoints() >= 3))
			return player1;
	
		if (player2.getPoints() > player1.getPoints()
				&& (player2.getPoints() >= 5 && player2.getPoints() - player1.getPoints() >= 3))
			return player2;
	
		return null;
	}

	public void ruleForConsecutiveLoses(Player player)
	{
		if (player.getConsecutiveLoseCount() == 3) 
		{
			player.decrementPoints(1);
			player.setConsecutiveLoseCountToZero();
			
		}
	}

	public void ruleForFouls(Player player) 
	{
		if (player.getFoul() == 3) 
		{
			player.decrementPoints(1);
			player.setFoulCountToZero();
			
		}
	}
}
