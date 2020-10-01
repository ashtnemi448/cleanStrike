package Action;

import Constant.Color;
import Entities.Coins;
import Entities.Players;

public class Ruleimplementation 
{
	/*
		When player pockets 1 coin
	*/
	void strike(Players player)
	{
		player.incrementPoints(1);
	}
	
	/*
		When player pockets more than 1 coin
	*/
	void multiStrike(Players player,Coins coins)
	{
		player.incrementPoints(2);
		/*
			All, but 2 coins, that were pocketed, 
			get back on to the carrom-board 
		*/
		coins.restoreToDefault();
		coins.decrement(2, Color.BLACK);
	}
	
	/*
		When player pockets a red coin and 
		0 or more black coins
	*/
	void redStrike(Players player,Coins coins)
	{
		player.incrementPoints(3);
		/*
			If black coins are pocketed along
			with red coin in the same turn, black 
			coins get back on to the carrom-board
		*/
		coins.decrement(1,Color.RED);
	}
	
	/*
		When player pockets stricker
	*/
	void strikerStrick(Players player)
	{
		player.decrementPoints(1);
	}
	
	/*
		When coin is thrown out of the board
	*/
	void defunctCoin(Players player,Coins coins)
	{
		player.decrementPoints(1);
		/*
		 	Assumption - only black coin gets thrown out
		*/
		coins.decrement(1,Color.BLACK);
	}
}
