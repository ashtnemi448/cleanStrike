package ai.sahaj.cleanstrike.game;

import ai.sahaj.cleanstrike.player.Player;

public interface GameRules
{
	public Player ruleToChooseWinner(Player player1, Player player2);
	public void ruleForConsecutiveLoses(Player player);
	public void ruleForFouls(Player player);
}
