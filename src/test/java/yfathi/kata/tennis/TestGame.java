package yfathi.kata.tennis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yfathi.kata.tennis.exceptions.RuleException;
import yfathi.kata.tennis.model.Game;
import yfathi.kata.tennis.model.Player;
import yfathi.kata.tennis.model.Score;
import yfathi.kata.tennis.service.GameService;
import yfathi.kata.tennis.service.GameServiceImpl;

import java.util.List;

public class TestGame {

    static Player player1;
    static Player player2;
    GameService gameService;

    @BeforeAll
    static void preparePlayers(){
         player1 = new Player("Rafael", "Nadal");
         player2 = new Player("Hicham", "Arazi");
    }

    @BeforeEach
    void prepare(){
         gameService = new GameServiceImpl(List.of(player1,player2));
    }

    @Test
    void testOneWinsAll() throws RuleException {
        Game game = gameService.init();
        Assertions.assertEquals( Score.SO,game.getScore(1));
        gameService.winPoint(game, 1);
        Assertions.assertEquals(Score.S15,game.getScore(1));
        gameService.winPoint(game, 1);
        Assertions.assertEquals( Score.S30,game.getScore(1));
        gameService.winPoint(game, 1);
        Assertions.assertEquals(Score.S40,game.getScore(1));
        gameService.winPoint(game, 1);
        Assertions.assertEquals(Score.GWIN,game.getOutcome() );
        Assertions.assertEquals(player2,game.getOutcomePlayer() );
        Assertions.assertEquals(Score.S40,game.getScore(1) );
        Assertions.assertEquals(Score.SO,game.getScore(0) );
    }
    @Test
    void testDeuce() throws RuleException {
        Game game = gameService.init();
        gameService.winPoint(game, 1);
        gameService.winPoint(game, 0);
        gameService.winPoint(game, 1);
        gameService.winPoint(game, 0);
        gameService.winPoint(game, 1);
        gameService.winPoint(game, 0);
        Assertions.assertEquals(Score.S40,game.getScore(0) );
        Assertions.assertEquals(Score.S40,game.getScore(1));
        gameService.winPoint(game, 0);
        Assertions.assertEquals(Score.ADV,game.getOutcome());
        Assertions.assertEquals(player1,game.getOutcomePlayer() );
        gameService.winPoint(game, 1);
        Assertions.assertEquals( Score.S40,game.getScore(0));
        Assertions.assertEquals(Score.S40,game.getScore(1) );
        Assertions.assertNull(game.getOutcome());
        gameService.winPoint(game,1);
        Assertions.assertEquals(Score.ADV,game.getOutcome() );
        Assertions.assertEquals(player2,game.getOutcomePlayer());
        gameService.winPoint(game, 0);
        gameService.winPoint(game, 0);
        Assertions.assertEquals(Score.ADV,game.getOutcome() );
        gameService.winPoint(game, 0);
        Assertions.assertEquals(Score.GWIN,game.getOutcome()) ;
        Assertions.assertEquals(player1,game.getOutcomePlayer());




    }


}
