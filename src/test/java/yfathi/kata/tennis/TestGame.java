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
    Game game;

    @BeforeAll
    static void preparePlayers(){
         player1 = new Player("Rafael", "Nadal");
         player2 = new Player("Hicham", "Arazi");
    }

    @BeforeEach
    void prepare(){
         gameService = new GameServiceImpl(List.of(player1,player2));
         game = gameService.initGame();
    }

    @Test
    void testOneWinsAll() throws RuleException {
        GameService gameService = new GameServiceImpl(List.of(player1,player2));
        Game game = gameService.initGame();
        Assertions.assertEquals(game.getScore(1), Score.SO);
        gameService.winPoint(game, 1);
        Assertions.assertEquals(game.getScore(1), Score.S15);
        gameService.winPoint(game, 1);
        Assertions.assertEquals(game.getScore(1), Score.S30);
        gameService.winPoint(game, 1);
        Assertions.assertEquals(game.getScore(1), Score.S40);
        gameService.winPoint(game, 1);
        Assertions.assertEquals(game.getOutcome(), Score.WIN);
        Assertions.assertEquals(game.getOutcomePlayer(), player2);
        Assertions.assertEquals(game.getScore(1), Score.S40);
        Assertions.assertEquals(game.getScore(0), Score.SO);
    }
    @Test
    void testDeuce() throws RuleException {
        GameService gameService = new GameServiceImpl(List.of(player1,player2));
        Game game = gameService.initGame();
        gameService.winPoint(game, 1);
        gameService.winPoint(game, 0);
        gameService.winPoint(game, 1);
        gameService.winPoint(game, 0);
        gameService.winPoint(game, 1);
        gameService.winPoint(game, 0);
        Assertions.assertEquals(game.getScore(0), Score.S40);
        Assertions.assertEquals(game.getScore(1), Score.S40);
        gameService.winPoint(game, 0);
        Assertions.assertEquals(game.getOutcome(), Score.ADV);
        Assertions.assertEquals(game.getOutcomePlayer(), player1);
        gameService.winPoint(game, 1);
        Assertions.assertEquals(game.getScore(0), Score.S40);
        Assertions.assertEquals(game.getScore(1), Score.S40);
        Assertions.assertEquals(game.getOutcome(), null);
        gameService.winPoint(game, 1);
        Assertions.assertEquals(game.getOutcome(), Score.ADV);
        Assertions.assertEquals(game.getOutcomePlayer(), player2);
        gameService.winPoint(game, 0);
        gameService.winPoint(game, 0);
        Assertions.assertEquals(game.getOutcome(), Score.ADV);
        gameService.winPoint(game, 0);
        Assertions.assertEquals(game.getOutcome(), Score.WIN);
        Assertions.assertEquals(game.getOutcomePlayer(), player1);




    }


}
