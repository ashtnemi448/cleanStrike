package Playground;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import Action.Ruleimplementation;
import Checker.Checker;
import Constant.StrikeType;
import Entities.Coins;
import Entities.Players;
import Statistics.GameStats;

public class Playground {

	Players getWinner(Players player1, Players player2)
	{
		if (player1.getPoints() > player2.getPoints()
				&& (player1.getPoints() >= 5 || player1.getPoints() - player2.getPoints() >= 3))
			return player1;

		if (player2.getPoints() > player1.getPoints()
				&& (player2.getPoints() >= 5 || player2.getPoints() - player1.getPoints() >= 3))
			return player2;

		return null;
	}

	public Players playUtil(Players player1, Players player2, Coins coins, List<StrikeType> query) throws IOException 
	{
		PlayGroudUtil playGroudUtil = new PlayGroudUtil();
		GameStats gameStats = new GameStats(player1, player2,coins);
		
		for (int i = 0; i < query.size(); i++)
		{
			Players curPlayer = playGroudUtil.getCurPlayer(player1, player2);
			StrikeType strikeType = query.get(i);

			if (Checker.checkFor3ConsecutiveLoses(curPlayer) == true) 
			{
				curPlayer.decrementPoints(1);
			}

			if (Checker.checkFor3Fouls(curPlayer) == true) 
			{
				curPlayer.decrementPoints(1);
			}
			playGroudUtil.performStrikeAction(curPlayer, strikeType, coins);
			gameStats.saveStats(curPlayer, playGroudUtil.turn,strikeType);
		}
		Players winner = getWinner(player1, player2);
		return winner;
	}

}
