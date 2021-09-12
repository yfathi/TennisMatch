package yfathi.kata.tennis.service;

import yfathi.kata.tennis.exceptions.RuleException;
import yfathi.kata.tennis.model.Set;

public interface SetService {
    Set init();

    boolean winPoint(Set set, int player) throws RuleException;

    String displayScore(Set set);

}
