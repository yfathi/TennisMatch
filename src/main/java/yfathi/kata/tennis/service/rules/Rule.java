package yfathi.kata.tennis.service.rules;

import yfathi.kata.tennis.model.Game;
import yfathi.kata.tennis.model.Player;

/**
 * The interface Rule.
 */
public interface Rule {
    /**
     * Apply boolean.
     *
     * @param game     the game
     * @param player   the player
     * @param opponent the opponent
     * @return the boolean
     */
    boolean apply(Game game, Player player, int opponent);
}
