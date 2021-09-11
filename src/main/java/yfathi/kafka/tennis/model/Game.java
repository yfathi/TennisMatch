package yfathi.kafka.tennis.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Game {
    private final Map<Player,Score> playersScore;
    private Outcome outcome;
    private Player outcomePlayer;


    public Game(Player player1,Player player2) {
        this.playersScore = new HashMap<>();
     this.playersScore.put(player1,Score.SO);
     this.playersScore.put(player2,Score.SO);
    }

    public Score getScore(Object key) {
        return playersScore.get(key);
    }

    public Collection<Score> getScores() {
        return playersScore.values();
    }

    public Score replaceScore(Player key, Score value) {
        return playersScore.replace(key, value);
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
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