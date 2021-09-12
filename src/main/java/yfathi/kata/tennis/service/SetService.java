package yfathi.kata.tennis.service;

import yfathi.kata.tennis.exceptions.RuleException;
import yfathi.kata.tennis.model.Set;

/**
 * The interface Set service.
 */
public interface SetService {
    /**
     * Init set.
     *
     * @return the set
     */
    Set init();

    /**
     * Win point boolean.
     *
     * @param set    the set
     * @param player the player
     * @return the boolean
     * @throws RuleException the rule exception
     */
    boolean winPoint(Set set, int player) throws RuleException;

    /**
     * Display score string.
     *
     * @param set the set
     * @return the string
     */
    String displayScore(Set set);

}
