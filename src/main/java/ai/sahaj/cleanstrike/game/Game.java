package ai.sahaj.cleanstrike.game;

import java.io.IOException;
import java.util.List;
import ai.sahaj.cleanstrike.carrom.StrikeTypes;
import ai.sahaj.cleanstrike.carrom.Carrom;
import ai.sahaj.cleanstrike.player.Player;
import ai.sahaj.cleanstrike.statistics.GameStats;

public class Game
{
	public void startGame(Player player1, Player player2, Carrom Carrom, List<StrikeTypes> query) throws IOException 
	{
		GameUtilities gameUtilities = new GameUtilities();
		GameStats gameStats = new GameStats(player1, player2,Carrom);
		GameRulesImplementation gameRulesImplementation =new GameRulesImplementation();
		
		for (int i = 0; i < query.size(); i++)
		{
			Player currentPlayer = gameUtilities.getCurPlayer(player1, player2);
			StrikeTypes strikeType = query.get(i);

			gameRulesImplementation.ruleForConsecutiveLoses(currentPlayer);
			gameRulesImplementation.ruleForFouls(currentPlayer);
		
			gameUtilities.performStrikeAction(currentPlayer, strikeType, Carrom);
			gameStats.saveStats(currentPlayer, gameUtilities.turn,strikeType);
		}
	}
}
