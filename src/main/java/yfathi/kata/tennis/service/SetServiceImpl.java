package yfathi.kata.tennis.service;

import yfathi.kata.tennis.exceptions.RuleException;
import yfathi.kata.tennis.model.Game;
import yfathi.kata.tennis.model.Player;
import yfathi.kata.tennis.model.Score;
import yfathi.kata.tennis.model.Set;

import java.util.List;

/**
 * The type Set service.
 */
public class SetServiceImpl implements SetService {

    private final List<Player> players;
    private final GameService gameService;

    /**
     * Instantiates a new Set service.
     *
     * @param players the players
     */
    public SetServiceImpl(List<Player> players) {
        this.players = players;
        this.gameService = new GameServiceImpl(players);
    }


    @Override
    public Set init() {
        Set set = new Set();
        set.getScoreSet().put(players.get(0), 0);
        set.getScoreSet().put(players.get(1), 0);
        set.setCurrentGame(gameService.init());
        return set;
    }


    @Override
    public boolean winPoint(Set set, int player) throws RuleException {

        if (!set.isOngoing())
            throw new RuleException("Set Ended, You can't win points");

        // Win point in current game
        if (set.getCurrentGame().isOngoing()) {
            // same game
            gameService.winPoint(set.getCurrentGame(), player);
        } else {
            // new game
            set.setCurrentGame(gameService.init());
            gameService.winPoint(set.getCurrentGame(), player);

        }

        // compute new score

        computeOutcome(set, player);
        System.out.println(displayScore(set));

        // true if the game still going
        return true;
    }


    @Override
    public String displayScore(Set set) {
        return "Set Score :\n" + set;
    }
    private void computeOutcome(Set set, int player) {
        final Game currentGame = set.getCurrentGame();
        final Player opponent = players.get(player == 1 ? 0 : 1);

        if (!currentGame.isOngoing()) {

            // check for Suit and Tie
            if(set.getScore(players.get(player))==5 && set.getScore(opponent)==6){
                set.setTie(true);
            }

            // set win min points
            final Integer opScore = set.getScoreSet().get(opponent);
            final var minWin = set.isTie()?(opScore+2):opScore < 5 ? 6 : 7;
            // check for win
            if (set.addScore(currentGame.getOutcomePlayer()) == minWin) {
                set.setOutcome(Score.SWIN);
                set.setOutcomePlayer(currentGame.getOutcomePlayer());
            }
        }
    }

}