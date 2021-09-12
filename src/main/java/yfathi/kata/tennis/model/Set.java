package yfathi.kata.tennis.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The type Set.
 */
public class Set {
    private final List<Game> games;
    private final Map<Player,Integer> scoreSet;
    private Score outcome;
    private Player outcomePlayer;
    private boolean ongoing =true;
    private boolean tie =false;


    /**
     * Instantiates a new Set.
     */
    public Set() {
    this.games = new ArrayList<>();
    this.scoreSet = new HashMap<>();
    }


    /**
     * Gets games.
     *
     * @return the games
     */
    public List<Game> getGames() {
        return games;
    }

    /**
     * Gets score set.
     *
     * @return the score set
     */
    public Map<Player, Integer> getScoreSet() {
        return scoreSet;
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
     * Gets current game.
     *
     * @return the current game
     */
    public Game getCurrentGame() {
        return games.get(games.size()-1);
    }

    /**
     * Sets current game.
     *
     * @param currentGame the current game
     */
    public void setCurrentGame(Game currentGame) {
        this.games.add(currentGame);
    }

    /**
     * Sets outcome.
     *
     * @param outcome the outcome
     */
    public void setOutcome(Score outcome) {
        if(Score.SWIN.equals(outcome)) ongoing =false;
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
     * Add score integer.
     *
     * @param player the player
     * @return the integer
     */
    public Integer addScore(Player player){
        var newScore = scoreSet.get(player)+1;

        scoreSet.put(player,newScore);
        return newScore;
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

    /**
     * Is tie boolean.
     *
     * @return the boolean
     */
    public boolean isTie() {
        return tie;
    }

    /**
     * Sets tie.
     *
     * @param tie the tie
     */
    public void setTie(boolean tie) {
        this.tie = tie;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(scoreSet.values().stream().map(Object::toString).collect(Collectors.joining("-")));

        if(outcome != null){
            sb.append("\n");
            sb.append(outcome.getLabel());
            sb.append(" for ");
            sb.append(outcomePlayer);
        }else  if(tie){
            sb.append("\n");
            sb.append("Tie-Break");
        }

        return sb.toString();
    }

    /**
     * Gets score.
     *
     * @param key the key
     * @return the score
     */
    public Integer getScore(Object key) {
        return scoreSet.get(key);
    }
}