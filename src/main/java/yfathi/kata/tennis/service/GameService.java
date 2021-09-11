package yfathi.kata.tennis.service;

import yfathi.kata.tennis.exceptions.RuleException;
import yfathi.kata.tennis.model.Game;
import yfathi.kata.tennis.model.Score;

public interface GameService {
    Game initGame();

    boolean winPoint(Game game, int player) throws RuleException;

    String displayGameScore(Game game);

    Score nextScore(int playerId, Game game) throws RuleException;

}
