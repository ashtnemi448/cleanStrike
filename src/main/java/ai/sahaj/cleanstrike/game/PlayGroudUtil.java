package ai.sahaj.cleanstrike.game;

import ai.sahaj.cleanstrike.carrom.StrikeType;
import ai.sahaj.cleanstrike.carrom.Coins;
import ai.sahaj.cleanstrike.player.Player;

public class PlayGroudUtil 
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
	
	void performStrikeAction(Player player, StrikeType strikeType, Coins coins) 
	{
		Ruleimplementation ruleimplementation = new Ruleimplementation();
		
		switch (strikeType) 
		{
			case STRIKE:
				ruleimplementation.strike(player, coins);
				break;
	
			case MULTISTRIKE:
				ruleimplementation.multiStrike(player, coins);
				break;
	
			case REDSTRIKE:
				ruleimplementation.redStrike(player, coins);
				break;
	
			case STRICKERSTRICK:
				ruleimplementation.strikerStrick(player);
				break;
	
			case DEFUNCTCOIN:
				ruleimplementation.defunctCoin(player, coins);
				break;
		}
		return;
	}
}
