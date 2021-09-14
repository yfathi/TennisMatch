package yfathi.kata.tennis.service.rules;

import yfathi.kata.tennis.model.Game;
import yfathi.kata.tennis.model.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Rule engine.
 */
public class RuleEngine {


    private final List<Rule> rules ;


    /**
     * Instantiates a new Rule engine.
     */
    public RuleEngine() {
        this.rules =  new ArrayList<>();
        rules.add(new DeuceRule());
        rules.add(new WinRule());
        rules.add(new AdvantageRule());
    }

    /**
     * Run outcome.
     *
     * @param game     the game
     * @param player   the player
     * @param opponent the opponent
     */
    public void runOutcome(Game game, Player player, int opponent){
        for (Rule rule:rules) {
            if (rule.apply(game,player,opponent)) return;
        }
    }
}
