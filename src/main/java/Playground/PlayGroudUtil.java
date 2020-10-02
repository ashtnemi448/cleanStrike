package Playground;

import Action.Ruleimplementation;
import Constant.StrikeType;
import Entities.Coins;
import Entities.Players;

public class PlayGroudUtil 
{
	int turn = 0;

	Players getCurPlayer(Players player1, Players player2)
	{
		Players curPlayer;
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
	
	void performStrikeAction(Players player, StrikeType strikeType, Coins coins) 
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
