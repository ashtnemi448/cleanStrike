package ai.sahaj.cleanstrike.game;

import ai.sahaj.cleanstrike.player.Player;

public interface GameRules
{
	Player ruleToChooseWinner(Player player1, Player player2);
	void ruleForConsecutiveLoses(Player player);
	void ruleForFouls(Player player);
}
