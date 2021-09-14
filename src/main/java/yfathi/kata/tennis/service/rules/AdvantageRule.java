package yfathi.kata.tennis.service.rules;

import yfathi.kata.tennis.model.Game;
import yfathi.kata.tennis.model.Player;
import yfathi.kata.tennis.model.Score;

/**
 * The type Advantage rule.
 */
public class AdvantageRule implements Rule{
    @Override
    public boolean apply(Game game, Player player, int opponent) {
        final Score opponentScore = game.getScore(opponent);
        // You have over 40 and you had Deuce Activated
        if (opponentScore.equals(Score.S40) &&game.getOutcome()==null ) {
            game.setOutcome(Score.ADV);
            game.setOutcomePlayer(player);
            return true;
        }
        return false;
    }
}
