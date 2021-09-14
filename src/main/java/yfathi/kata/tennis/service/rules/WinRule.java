package yfathi.kata.tennis.service.rules;

import yfathi.kata.tennis.model.Game;
import yfathi.kata.tennis.model.Player;
import yfathi.kata.tennis.model.Score;

/**
 * The type Win rule.
 */
public class WinRule implements Rule{
    @Override
    public boolean apply(Game game, Player player, int opponent) {
        final Score opponentScore = game.getScore(opponent);
        // You have over 40 and your oponnet has not then you WIN
        if (!opponentScore.equals(Score.S40) || player.equals(game.getOutcomePlayer()) ) {
                game.setOutcome(Score.GWIN);
                game.setOutcomePlayer(player);
            return true;
        }
        return false;
    }
}
