package yfathi.kata.tennis;

import yfathi.kata.tennis.exceptions.RuleException;
import yfathi.kata.tennis.model.Game;
import yfathi.kata.tennis.model.Player;
import yfathi.kata.tennis.model.Set;
import yfathi.kata.tennis.service.GameService;
import yfathi.kata.tennis.service.GameServiceImpl;
import yfathi.kata.tennis.service.SetService;
import yfathi.kata.tennis.service.SetServiceImpl;

import java.util.List;

public class TennisMatch {


    public static void main(String[] args) throws RuleException {
        //new TennisMatch().gameSample();
        new TennisMatch().setSample();

    }

    public void setSample() throws RuleException {
        Player player1 = new Player("Rafael", "Nadal");
        Player player2 = new Player("Hicham", "Arazi");

        SetService setService = new SetServiceImpl(List.of(player1,player2));
        Set set = setService.init();

        for (int i = 0; i < 20; i++) {
            setService.winPoint(set, 0);
        }
        for (int i = 0; i < 20; i++) {
            setService.winPoint(set, 1);
        }
        for (int i = 0; i < 8; i++) {
            setService.winPoint(set, 0);
        }

    }

    public void gameSample() throws RuleException {
        Player player1 = new Player("Rafael", "Nadal");
        Player player2 = new Player("Hicham", "Arazi");
        GameService gameService = new GameServiceImpl(List.of(player1,player2));
        Game game = gameService.init();

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
