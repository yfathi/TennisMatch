package yfathi.kata.tennis.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The type Game.
 */
public class Game {
    private final Map<Integer,Score> playersScore;
    private Score outcome;
    private Player outcomePlayer;
    private boolean ongoing =true;


    /**
     * Instantiates a new Game.
     */
    public Game() {
        this.playersScore = new HashMap<>();
     this.playersScore.put(0,Score.SO);
     this.playersScore.put(1,Score.SO);
    }

    /**
     * Gets score.
     *
     * @param key the key
     * @return the score
     */
    public Score getScore(Integer key) {
        return playersScore.get(key);
    }

    /**
     * Gets scores.
     *
     * @return the scores
     */
    public Collection<Score> getScores() {
        return playersScore.values();
    }

    /**
     * Replace score score.
     *
     * @param key   the key
     * @param value the value
     * @return the score
     */
    public Score replaceScore(Integer key, Score value) {
        return playersScore.replace(key, value);
    }

    /**
     * Reset scores.
     *
     * @param value the value
     */
    public void resetScores(Score value) {
         playersScore.replace(0,value);
         playersScore.replace(1,value);
    }

    /**
     * Gets outcome.
     *
     * @return the outcome
     */
    public Score getOutcome() {
        return outcome;
    }

    /**
     * Sets outcome.
     *
     * @param outcome the outcome
     */
    public void setOutcome(Score outcome) {
        if(Score.GWIN.equals(outcome)) ongoing =false;
        this.outcome = outcome;
    }

    /**
     * Gets outcome player.
     *
     * @return the outcome player
     */
    public Player getOutcomePlayer() {
        return outcomePlayer;
    }


    /**
     * Sets outcome player.
     *
     * @param outcomePlayer the outcome player
     */
    public void setOutcomePlayer(Player outcomePlayer) {
        this.outcomePlayer = outcomePlayer;
    }

    /**
     * Is ongoing boolean.
     *
     * @return the boolean
     */
    public boolean isOngoing() {
        return ongoing;
    }

    /**
     * Sets ongoing.
     *
     * @param ongoing the ongoing
     */
    public void setOngoing(boolean ongoing) {
        this.ongoing = ongoing;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

            sb.append(playersScore.values().stream().map(Score::getLabel).collect(Collectors.joining("-")));
            if(outcome != null){
                sb.append("\n");
            sb.append(outcome.getLabel());
            sb.append(" for ");
            sb.append(outcomePlayer);
        }

        return sb.toString();
    }
}