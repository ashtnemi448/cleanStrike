package ai.sahaj.cleanstrike.game;

import ai.sahaj.cleanstrike.carrom.StrikeTypes;
import ai.sahaj.cleanstrike.carrom.Carrom;
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
	
	public void performStrikeAction(Player player, StrikeTypes strikeType, Carrom Carrom) 
	{
		StrikeAction strikeAction = new StrikeAction();
		
		switch (strikeType) 
		{
			case STRIKE:
				strikeAction.strike(player, Carrom);
				break;
	
			case MULTISTRIKE:
				strikeAction.multiStrike(player, Carrom);
				break;
	
			case REDSTRIKE:
				strikeAction.redStrike(player, Carrom);
				break;
	
			case STRICKERSTRICK:
				strikeAction.strikerStrick(player);
				break;
	
			case DEFUNCTCOIN:
				strikeAction.defunctCoin(player, Carrom);
				break;
		}
		return;
	}
}
