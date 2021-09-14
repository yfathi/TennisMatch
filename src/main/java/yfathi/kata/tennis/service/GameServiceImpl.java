package yfathi.kata.tennis.service;

import yfathi.kata.tennis.exceptions.RuleException;
import yfathi.kata.tennis.model.Game;
import yfathi.kata.tennis.model.Player;
import yfathi.kata.tennis.model.Score;
import yfathi.kata.tennis.service.rules.RuleEngine;

import java.util.List;

/**
 * The type Game service.
 */
public class GameServiceImpl implements GameService {

    private final List<Player> players;
    private final RuleEngine ruleEngine;

    /**
     * Instantiates a new Game service.
     *
     * @param players the players
     */
    public GameServiceImpl(List<Player> players) {
        this.players = players;
        this.ruleEngine = new RuleEngine();
    }

    @Override
    public Game init() {
        return new Game();
    }

    @Override
    public void winPoint(Game game, int player) throws RuleException {

        // compute new score
        Score nextScore = this.nextScore(player, game);
        game.replaceScore(player, nextScore);
        System.out.println(displayScore(game));

    }


    @Override
    public String displayScore(Game game) {
        return "Current Game :\n" + game;
    }


    /**
     * Next score score.
     *
     * @param playerId the player id
     * @param game     the game
     * @return the score
     * @throws RuleException the rule exception
     */
    public Score nextScore(int playerId, Game game) throws RuleException {
        if (!game.isOngoing())
        throw new RuleException("Game Ended, You can't win points");

        final Score score = game.getScore(playerId);
        final Player player = players.get(playerId);
        System.out.println("--------------------------");

        System.out.println("Point for " + player);
        Score next;
        switch (score) {
            case SO:
                next = Score.S15;
                break;
            case S15:
                next = Score.S30;
                break;
            case S30:
                next = Score.S40;
                break;
            case S40:
                ruleEngine.runOutcome(game, player, playerId == 0 ? 1 : 0);
            default:
                next = score;
        }

        return next;
    }


}