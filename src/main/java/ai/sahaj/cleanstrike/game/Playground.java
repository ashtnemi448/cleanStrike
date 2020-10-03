package ai.sahaj.cleanstrike.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import ai.sahaj.cleanstrike.carrom.Coins;
import ai.sahaj.cleanstrike.carrom.StrikeType;
import ai.sahaj.cleanstrike.player.Player;
import ai.sahaj.cleanstrike.statistics.GameStats;

public class Playground {

	Player getWinner(Player player1, Player player2)
	{
		if (player1.getPoints() > player2.getPoints()
				&& (player1.getPoints() >= 5 || player1.getPoints() - player2.getPoints() >= 3))
			return player1;

		if (player2.getPoints() > player1.getPoints()
				&& (player2.getPoints() >= 5 || player2.getPoints() - player1.getPoints() >= 3))
			return player2;

		return null;
	}

	public Player playUtil(Player player1, Player player2, Coins coins, List<StrikeType> query) throws IOException 
	{
		PlayGroudUtil playGroudUtil = new PlayGroudUtil();
		GameStats gameStats = new GameStats(player1, player2,coins);
		
		for (int i = 0; i < query.size(); i++)
		{
			Player curPlayer = playGroudUtil.getCurPlayer(player1, player2);
			StrikeType strikeType = query.get(i);

			if (Checker.checkFor3ConsecutiveLoses(curPlayer)) 
			{
				curPlayer.decrementPoints(1);
			}

			if (Checker.checkFor3Fouls(curPlayer)) 
			{
				curPlayer.decrementPoints(1);
			}
			playGroudUtil.performStrikeAction(curPlayer, strikeType, coins);
			gameStats.saveStats(curPlayer, playGroudUtil.turn,strikeType);
		}
		Player winner = getWinner(player1, player2);
		return winner;
	}

}
