package yfathi.kafka.tennis.service;

import yfathi.kafka.tennis.model.Game;
import yfathi.kafka.tennis.model.Outcome;
import yfathi.kafka.tennis.model.Player;
import yfathi.kafka.tennis.model.Score;

public interface GameService {
    Game initGame(Player player1, Player player2);

    void winPoint(Game game, Player player);

    String displayGameScore(Game game);

    Score nextScore(Score score);

    Outcome nextOutcome(Score score);
}
