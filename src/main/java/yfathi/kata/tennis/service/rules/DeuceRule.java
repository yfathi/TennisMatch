package yfathi.kata.tennis.service.rules;

import yfathi.kata.tennis.model.Game;
import yfathi.kata.tennis.model.Player;
import yfathi.kata.tennis.model.Score;

/**
 * The type Deuce rule.
 */
public class DeuceRule implements Rule{
    @Override
    public boolean apply(Game game, Player player, int opponent) {
        final Score opponentScore = game.getScore(opponent);
        // You have over 40 and your opponent has advantage
        // Back to Deuce
        if (Score.ADV.equals(game.getOutcome()) && !player.equals(game.getOutcomePlayer())) {
                game.setOutcome(null);
                game.setOutcomePlayer(null);
                return true;
        }
        return false;
    }
}
