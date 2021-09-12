package yfathi.kata.tennis.service;

import yfathi.kata.tennis.exceptions.RuleException;
import yfathi.kata.tennis.model.Game;

public interface GameService {
    Game init();

    void winPoint(Game game, int player) throws RuleException;

    String displayScore(Game game);

}
