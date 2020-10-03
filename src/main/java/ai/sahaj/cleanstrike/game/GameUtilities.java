package ai.sahaj.cleanstrike.game;

import ai.sahaj.cleanstrike.carrom.StrikeTypes;
import ai.sahaj.cleanstrike.carrom.Coins;
import ai.sahaj.cleanstrike.player.Player;

public class GameUtilities 
{
	int turn = 0;

	Player getCurPlayer(Player player1, Player player2)
	{
		Player curPlayer;
		if (turn % 2 == 0) 
		{
			curPlayer = player1;
		} 
		else 
		{
			curPlayer = player2;
		}
		turn++;
		return curPlayer;
	}
	
	void performStrikeAction(Player player, StrikeTypes strikeType, Coins coins) 
	{
		StrikeAction strikeAction = new StrikeAction();
		
		switch (strikeType) 
		{
			case STRIKE:
				strikeAction.strike(player, coins);
				break;
	
			case MULTISTRIKE:
				strikeAction.multiStrike(player, coins);
				break;
	
			case REDSTRIKE:
				strikeAction.redStrike(player, coins);
				break;
	
			case STRICKERSTRICK:
				strikeAction.strikerStrick(player);
				break;
	
			case DEFUNCTCOIN:
				strikeAction.defunctCoin(player, coins);
				break;
		}
		return;
	}
}
