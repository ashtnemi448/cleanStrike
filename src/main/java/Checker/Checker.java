package Checker;

import Entities.Players;

public class Checker 
{
	static public boolean checkFor3ConsecutiveLoses(Players player) 
	{
		if (player.getConsecutiveLoseCount() == 3) 
		{
			player.setConsecutiveLoseCountToZero();
			return true;
		}
		return false;
	}

	static public boolean checkFor3Fouls(Players player) 
	{
		if (player.getFoul() == 3) 
		{
			player.setFoulCountToZero();
			return true;
		}
		return false;
	}
}
