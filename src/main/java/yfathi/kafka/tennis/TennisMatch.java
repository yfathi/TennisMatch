package yfathi.kafka.tennis;

import yfathi.kafka.tennis.model.Game;
import yfathi.kafka.tennis.model.Player;
import yfathi.kafka.tennis.service.GameService;
import yfathi.kafka.tennis.service.GameServiceImpl;

public class TennisMatch {
    public TennisMatch() {
    }

    public static void main(String[] args) {
        Player player1 = new Player("Rafael", "Nadal");
        Player player2 = new Player("Hicham", "Arazi");
        GameService gameService = new GameServiceImpl();
        Game game = gameService.initGame(player1, player2);
        gameService.winPoint(game, player1);
        System.out.println(gameService.displayGameScore(game));
        gameService.winPoint(game, player1);
        System.out.println(gameService.displayGameScore(game));
        gameService.winPoint(game, player1);
        System.out.println(gameService.displayGameScore(game));
        gameService.winPoint(game, player1);
        System.out.println(gameService.displayGameScore(game));
    }
}
