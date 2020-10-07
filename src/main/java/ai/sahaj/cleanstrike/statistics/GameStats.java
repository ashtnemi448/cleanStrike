package ai.sahaj.cleanstrike.statistics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import ai.sahaj.cleanstrike.player.Player;
import ai.sahaj.cleanstrike.carrom.StrikeTypes;
import ai.sahaj.cleanstrike.carrom.Carrom;


public class GameStats 
{

	File gameStatsFile;
	Player player1;
	Player player2;
	Carrom Carrom;
	public static String commentString=null;

	public GameStats(Player player1, Player player2,Carrom Carrom) throws IOException 
	{
		super();
		this.player1 = player1;
		this.player2 = player2;
		this.Carrom = Carrom;

		gameStatsFile = new File("gameStats.txt");
		FileWriter fr = new FileWriter(gameStatsFile, false);
		fr.write("Game Stats for clean Strike");
		fr.close();
	}

	public void saveStats(Player curPlayer, int turn, StrikeTypes strikeType) throws IOException 
	{
		FileWriter fr = new FileWriter(gameStatsFile, true);

		fr.write("\n\nturnNumber - ");
		fr.write(String.valueOf(turn));
		
		if(commentString!=null)
		{
			fr.write("\nComment - ");
			fr.write(commentString);
			commentString=null;
		}
		
		fr.write("\nCurrent player - Player");
		fr.write(String.valueOf(curPlayer.getId()));
		
		fr.write("\nStrike Type - ");
		fr.write(String.valueOf(strikeType));
		
		fr.write("\nRemaining Black Coins - ");
		fr.write(String.valueOf(Carrom.getAvailableBlackCoins()));
		
		fr.write("\nRemaining Red Coins - ");
		fr.write(String.valueOf(Carrom.getAvailableRedCoins()));

		fr.write("\nPlayer 1 - ");
		fr.write("\n\tPoints -> ");
		fr.write(String.valueOf(player1.getPoints()));
		
		fr.write("\n\tConsecutiveLose - ");
		fr.write(String.valueOf(player1.getConsecutiveLoseCount()));
		
		fr.write("\n\tFouls - ");
		fr.write(String.valueOf(player1.getFoul()));

		
		fr.write("\nPlayer 2 - ");
		fr.write("\n\tPoints -> ");
		fr.write(String.valueOf(player2.getPoints()));
		
		fr.write("\n\tConsecutiveLose - ");
		fr.write(String.valueOf(player2.getConsecutiveLoseCount()));
		
		fr.write("\n\tFouls - ");
		fr.write(String.valueOf(player2.getFoul()));

		fr.close();
	}

}
