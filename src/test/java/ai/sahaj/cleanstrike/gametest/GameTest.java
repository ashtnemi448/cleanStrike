package ai.sahaj.cleanstrike.gametest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ai.sahaj.cleanstrike.game.Game;
import ai.sahaj.cleanstrike.game.StrikeAction;
import ai.sahaj.cleanstrike.game.GameRulesImplementation;
import ai.sahaj.cleanstrike.input.InputParser;
import ai.sahaj.cleanstrike.carrom.Carrom;
import ai.sahaj.cleanstrike.carrom.StrikeTypes;
import ai.sahaj.cleanstrike.exception.InputException;
import ai.sahaj.cleanstrike.exception.NoAvailableBlackCoinsException;
import ai.sahaj.cleanstrike.player.Player;

class GameTest 
{
	
	@Test
	@DisplayName("This scenario throws file Exception")
	public void mustThrowInputException()
	{
		InputParser inputParser = new InputParser();
		Exception exception=null;
		try 
		{
			inputParser.parseInputTestCase("EmptyTestcase.txt");
		}
		catch (Exception e) 
		{
			exception = e;
		}
		assertNull(exception);
	}
	
	
	@Test
	@DisplayName("This scenario must result in tie")
	public void gameMustResultInDraw() throws IOException
	{
		List<StrikeTypes> queryList = new ArrayList<StrikeTypes>();
		queryList.add(StrikeTypes.REDSTRIKE);
		queryList.add(StrikeTypes.STRIKE);
		queryList.add(StrikeTypes.STRICKERSTRICK);
		queryList.add(StrikeTypes.STRIKE);
		queryList.add(StrikeTypes.MULTISTRIKE);
		queryList.add(StrikeTypes.STRIKE);
		
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		Carrom Carrom = new Carrom(1, 9);
		
		GameRulesImplementation gameRuleImplementation = new GameRulesImplementation();
		Game game = new Game();
		game.startGame(player1, player2, Carrom, queryList);
		
		assertNull(gameRuleImplementation.ruleToChooseWinner(player1, player2));
	}
	
	@Test
	@DisplayName("In this scenario player1 must win")
	public void player1MustBeWinnerOfThisGame() throws IOException
	{
		List<StrikeTypes> queryList = new ArrayList<StrikeTypes>();
		
		queryList.add(StrikeTypes.REDSTRIKE);
		queryList.add(StrikeTypes.DEFUNCTCOIN);
		queryList.add(StrikeTypes.MULTISTRIKE);
		queryList.add(StrikeTypes.REDSTRIKE);
		queryList.add(StrikeTypes.STRIKE);
		queryList.add(StrikeTypes.DEFUNCTCOIN);
		queryList.add(StrikeTypes.MULTISTRIKE);
		queryList.add(StrikeTypes.DEFUNCTCOIN);
		queryList.add(StrikeTypes.DEFUNCTCOIN);
		queryList.add(StrikeTypes.DEFUNCTCOIN);
		
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		Carrom Carrom = new Carrom(1, 9);
		
		GameRulesImplementation gameRuleImplementation = new GameRulesImplementation();
		Game game = new Game();
		game.startGame(player1, player2, Carrom, queryList);
		
		assertEquals(player1,gameRuleImplementation.ruleToChooseWinner(player1, player2));
	}
	
	@Test
	@DisplayName("In this scenario player2 must win")
	public void player2MustBeWinnerOfThisGame() throws IOException
	{
		List<StrikeTypes> queryList = new ArrayList<StrikeTypes>();
		
		queryList.add(StrikeTypes.STRICKERSTRICK) ;
		queryList.add(StrikeTypes.STRICKERSTRICK) ;
		queryList.add(StrikeTypes.STRIKE) ;
		queryList.add(StrikeTypes.STRIKE) ;
		queryList.add(StrikeTypes.STRICKERSTRICK) ;
		queryList.add(StrikeTypes.REDSTRIKE) ;
		queryList.add(StrikeTypes.STRICKERSTRICK) ;
		queryList.add(StrikeTypes.MULTISTRIKE) ;
		queryList.add(StrikeTypes.MULTISTRIKE) ;
		queryList.add(StrikeTypes.STRIKE) ;
		
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		Carrom Carrom = new Carrom(1, 9);
		
		GameRulesImplementation gameRuleImplementation = new GameRulesImplementation();
		Game game = new Game();
		game.startGame(player1, player2, Carrom, queryList);
		
		assertEquals(player2,gameRuleImplementation.ruleToChooseWinner(player1, player2));
	}
}
















