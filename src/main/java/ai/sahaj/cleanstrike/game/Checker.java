package ai.sahaj.cleanstrike.game;

import ai.sahaj.cleanstrike.player.Player;
public class Checker 
{
	static public boolean checkFor3ConsecutiveLoses(Player player) 
	{
		if (player.getConsecutiveLoseCount() == 3) 
		{
			player.setConsecutiveLoseCountToZero();
			return true;
		}
		return false;
	}

	static public boolean checkFor3Fouls(Player player) 
	{
		if (player.getFoul() == 3) 
		{
			player.setFoulCountToZero();
			return true;
		}
		return false;
	}
}
