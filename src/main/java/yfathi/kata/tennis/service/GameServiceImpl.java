package yfathi.kata.tennis.service;

import yfathi.kata.tennis.exceptions.RuleException;
import yfathi.kata.tennis.model.Game;
import yfathi.kata.tennis.model.Player;
import yfathi.kata.tennis.model.Score;

import java.util.List;

public class GameServiceImpl implements GameService {

    private final List<Player> players;

    public GameServiceImpl(List<Player> players) {
        this.players = players;
    }

    @Override
    public Game init() {
        return new Game();
    }

    @Override
    public void winPoint(Game game, int player) throws RuleException {

        // compute new score
        Score nextScore = this.nextScore(player, game);
        game.replaceScore(player, nextScore);

        System.out.println(displayScore(game));

    }


    @Override
    public String displayScore(Game game) {
        return "Current Game :\n" + game;
    }


    public Score nextScore(int playerId, Game game) throws RuleException {
        if (!game.isOngoing())
        throw new RuleException("Game Ended, You can't win points");

        final Score score = game.getScore(playerId);
        final Player player = players.get(playerId);
        System.out.println("Point for " + player);
        Score next;
        switch (score) {
            case SO:
                next = Score.S15;
                break;
            case S15:
                next = Score.S30;
                break;
            case S30:
                next = Score.S40;
                break;
            case S40:
                computeOutcome(game, player, playerId == 0 ? 1 : 0);

            default:
                next = score;
        }

        return next;
    }

    private void computeOutcome(Game game, Player player, int opponentScore) {
        final Score score = game.getScore(opponentScore);
        final Player opponent = players.get(opponentScore);


        if (score.equals(Score.S40)) {
            // If Deuce Case

            if (player.equals(game.getOutcomePlayer()) ) {
                // Is there already an Advantage ?
                // You win
                game.setOutcome(Score.GWIN);
                game.setOutcomePlayer(player);

            } else if (opponent.equals(game.getOutcomePlayer())) {
                // does the opponent have an Advantage ?
                // go back to deuce
                game.setOutcome(null);
                game.setOutcomePlayer(null);
            }else {
                // Wee have a Deuce you get the advantage
                game.setOutcome(Score.ADV);
                game.setOutcomePlayer(player);
            }

        }else {
            // If no Deuce then WIN
            game.setOutcomePlayer(player);
            game.setOutcome(Score.GWIN);
        }


    }


}