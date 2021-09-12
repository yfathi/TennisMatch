package yfathi.kata.tennis.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Set {
    private final List<Game> games;
    private final Map<Player,Integer> scoreSet;
    private Score outcome;
    private Player outcomePlayer;
    private boolean ongoing =true;


    public Set() {
    this.games = new ArrayList<>();
    this.scoreSet = new HashMap<>();
    }



    public List<Game> getGames() {
        return games;
    }

    public Map<Player, Integer> getScoreSet() {
        return scoreSet;
    }

    public Score getOutcome() {
        return outcome;
    }

    public Game getCurrentGame() {
        return games.get(games.size()-1);
    }

    public void setCurrentGame(Game currentGame) {
        this.games.add(currentGame);
    }

    public void setOutcome(Score outcome) {
        if(Score.SWIN.equals(outcome)) ongoing =false;
        this.outcome = outcome;
    }

    public Player getOutcomePlayer() {
        return outcomePlayer;
    }

    public void setOutcomePlayer(Player outcomePlayer) {
        this.outcomePlayer = outcomePlayer;
    }

    public Integer addScore(Player player){
        var newScore = scoreSet.get(player)+1;

        scoreSet.put(player,newScore);
        return newScore;
    }

    public boolean isOngoing() {
        return ongoing;
    }

    public void setOngoing(boolean ongoing) {
        this.ongoing = ongoing;
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
        }

        return sb.toString();
    }
}