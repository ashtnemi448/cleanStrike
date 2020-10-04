package ai.sahaj.cleanstrike.game;

import java.io.IOException;
import java.util.List;
import ai.sahaj.cleanstrike.carrom.StrikeTypes;
import ai.sahaj.cleanstrike.carrom.Coins;
import ai.sahaj.cleanstrike.player.Player;
import ai.sahaj.cleanstrike.statistics.GameStats;

public class Game implements GameRules 
{
	public Player ruleToChooseWinner(Player player1, Player player2)
	{
		return GameRulesImplementation.chooseWinner(player1,player2);
	}

	public void ruleForConsecutiveLoses(Player player) 
	{
		 GameRulesImplementation.checkFor3ConsecutiveLoses(player) ;
	}

	public void ruleForFouls(Player player) 
	{
		 GameRulesImplementation.checkFor3Fouls(player) ;
	}
	
	public Player startGame(Player player1, Player player2, Coins coins, List<StrikeTypes> query) throws IOException 
	{
		GameUtilities gameUtilities = new GameUtilities();
		GameStats gameStats = new GameStats(player1, player2,coins);
		
		for (int i = 0; i < query.size(); i++)
		{
			Player curPlayer = gameUtilities.getCurPlayer(player1, player2);
			StrikeTypes strikeType = query.get(i);

			ruleForConsecutiveLoses(curPlayer);
			ruleForFouls(curPlayer);
		
			gameUtilities.performStrikeAction(curPlayer, strikeType, coins);
			gameStats.saveStats(curPlayer, gameUtilities.turn,strikeType);
		}
		Player winner = ruleToChooseWinner(player1, player2);
		return winner;
	}
}
