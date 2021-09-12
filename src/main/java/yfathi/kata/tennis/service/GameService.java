package yfathi.kata.tennis.service;

import yfathi.kata.tennis.exceptions.RuleException;
import yfathi.kata.tennis.model.Game;

/**
 * The interface Game service.
 */
public interface GameService {
    /**
     * Init game.
     *
     * @return the game
     */
    Game init();

    /**
     * Win point.
     *
     * @param game   the game
     * @param player the player
     * @throws RuleException the rule exception
     */
    void winPoint(Game game, int player) throws RuleException;

    /**
     * Display score string.
     *
     * @param game the game
     * @return the string
     */
    String displayScore(Game game);

}
