package yfathi.kata.tennis;

import yfathi.kata.tennis.exceptions.RuleException;
import yfathi.kata.tennis.model.Game;
import yfathi.kata.tennis.model.Player;
import yfathi.kata.tennis.service.GameService;
import yfathi.kata.tennis.service.GameServiceImpl;

import java.util.List;

public class TennisMatch {
    public TennisMatch() {
    }

    public static void main(String[] args) throws RuleException {
        Player player1 = new Player("Rafael", "Nadal");
        Player player2 = new Player("Hicham", "Arazi");
        GameService gameService = new GameServiceImpl(List.of(player1,player2));
        Game game = gameService.initGame();

        gameService.winPoint(game, 0);
        gameService.winPoint(game, 1);
        gameService.winPoint(game, 0);
        gameService.winPoint(game, 1);
        gameService.winPoint(game, 0);
        gameService.winPoint(game, 1);
        gameService.winPoint(game, 1);
        gameService.winPoint(game, 0);
        gameService.winPoint(game, 0);
        gameService.winPoint(game, 1);
        gameService.winPoint(game, 0);
        gameService.winPoint(game, 1);
        gameService.winPoint(game, 1);
        gameService.winPoint(game, 1);


    }
}
