package yfathi.kafka.tennis.service;

import yfathi.kafka.tennis.model.Game;
import yfathi.kafka.tennis.model.Outcome;
import yfathi.kafka.tennis.model.Player;
import yfathi.kafka.tennis.model.Score;

public class GameServiceImpl implements GameService {
    public GameServiceImpl() {
    }

    @Override
    public Game initGame(Player player1, Player player2) {
        return new Game(player1, player2);
    }

    @Override
    public void winPoint(Game game, Player player) {
        if (Outcome.WIN != game.getOutcome()) {
            Score nextScore = this.nextScore(game.getScore(player));
            game.replaceScore(player, nextScore);
            Outcome nextOutcome = this.nextOutcome(nextScore);
            this.checkOutcome(game, player, nextOutcome);
            this.checkOutcome(game, player, nextOutcome);
            System.out.println("Point for " + player);
        } else {
            System.out.println("Game Ended");
        }

    }

    private void checkOutcome(Game game, Player player, Outcome nextOutcome) {
        if (nextOutcome != null) {
            game.setOutcome(nextOutcome);
            game.setOutcomePlayer(player);
        }

    }


    @Override
    public String displayGameScore(Game game) {
        return "Current Score :\n" + game;
    }

    @Override
    public Score nextScore(Score score) {
        Score next;
        switch(score) {
            case SO:
            next = Score.S15;
            break;
            case S15:
            next = Score.S30;
            break;
            case S30:
            next = Score.S40;
            break;
        default:
            next = score;
        }

        return next;
    }

    @Override
    public Outcome nextOutcome(Score score) {
        Outcome next;
        switch(score) {
            case S40:
                next = Outcome.WIN;
            break;
        default:
            next = null;
        }

        return next;
    }
}