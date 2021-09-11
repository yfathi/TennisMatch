package yfathi.kata.tennis.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Game {
    private final Map<Integer,Score> playersScore;
    private Score outcome;
    private Player outcomePlayer;


    public Game() {
        this.playersScore = new HashMap<>();
     this.playersScore.put(0,Score.SO);
     this.playersScore.put(1,Score.SO);
    }

    public Score getScore(Integer key) {
        return playersScore.get(key);
    }

    public Collection<Score> getScores() {
        return playersScore.values();
    }

    public Score replaceScore(Integer key, Score value) {
        return playersScore.replace(key, value);
    }

    public void resetScores(Score value) {
         playersScore.replace(0,value);
         playersScore.replace(1,value);
    }

    public Score getOutcome() {
        return outcome;
    }

    public void setOutcome(Score outcome) {
        this.outcome = outcome;
    }

    public Player getOutcomePlayer() {
        return outcomePlayer;
    }


    public void setOutcomePlayer(Player outcomePlayer) {
        this.outcomePlayer = outcomePlayer;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        if(outcome == null){
            sb.append(playersScore.values().stream().map(Score::getLabel).collect(Collectors.joining("-")));

        }else{
            sb.append(outcome.getLabel());
            sb.append(" for ");
            sb.append(outcomePlayer);
        }

        return sb.toString();
    }
}