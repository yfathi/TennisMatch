package yfathi.kata.tennis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yfathi.kata.tennis.exceptions.RuleException;
import yfathi.kata.tennis.model.Player;
import yfathi.kata.tennis.model.Score;
import yfathi.kata.tennis.model.Set;
import yfathi.kata.tennis.service.SetService;
import yfathi.kata.tennis.service.SetServiceImpl;

import java.util.List;

public class TestSet {

    static Player player1;
    static Player player2;
    SetService setService;


    @BeforeAll
    static void preparePlayers(){
         player1 = new Player("Rafael", "Nadal");
         player2 = new Player("Hicham", "Arazi");
    }

    @BeforeEach
    void prepare(){
         setService = new SetServiceImpl(List.of(player1,player2));
    }

    @Test
    void testOneWinsAll() throws RuleException {
        Set set = setService.init();

        // Rafael always wins
        for (int i = 0; i < 24; i++) {
            setService.winPoint(set, 0);
        }
        Assertions.assertEquals(Score.SWIN,set.getOutcome());
        Assertions.assertEquals(player1,set.getOutcomePlayer());
    }

    @Test
    void test6SimpleRule() throws RuleException {
        Set set = setService.init();
        // Rafal get to 5
        for (int i = 0; i < 20; i++) {
            setService.winPoint(set, 0);
        }
        // Big come back for Arazi
        for (int i = 0; i < 20; i++) {
            setService.winPoint(set, 1);
        }
        // He could've win but rafael has 5 , Arazi should get to 7
        Assertions.assertNull(set.getOutcome());

        // Arazi get to 6
        for (int i = 0; i < 4; i++) {
            setService.winPoint(set, 1);
        }
        Assertions.assertNull(set.getOutcome());
        // Arazi wins with 7 - 5
        for (int i = 0; i < 4; i++) {
            setService.winPoint(set, 1);
        }
       Assertions.assertEquals(Score.SWIN,set.getOutcome() );
        Assertions.assertEquals(player2,set.getOutcomePlayer());

    }
    @Test
    void testTieBreakRule() throws RuleException {
        Set set = setService.init();
        // Rafal get to 5
        for (int i = 0; i < 20; i++) {
            setService.winPoint(set, 0);
        }
        // Big come back for Arazi again 6 in a row !!!!!
        for (int i = 0; i < 20; i++) {
            setService.winPoint(set, 1);
        }
        // Game for Nadal
        for (int i = 0; i < 4; i++) {
            setService.winPoint(set, 0);
        }
        // Game for Arazi
        for (int i = 0; i < 4; i++) {
            setService.winPoint(set, 1);
        }

        // Tie Beak rule activated
        Assertions.assertTrue(set.isTie());
        // with 6-6 each
        Assertions.assertEquals(6,set.getScore(player1));
        Assertions.assertEquals(6,set.getScore(player2));

        // Rafael get to 7
        for (int i = 0; i < 4; i++) {
            setService.winPoint(set, 0);
        }
        // Too bad it's a Tie-Break , can't win with 7
        Assertions.assertNull(set.getOutcome());


        // Arazi get to 7
        for (int i = 0; i < 4; i++) {
            setService.winPoint(set, 1);
        }

        // Still a Tie-Break
        Assertions.assertNull(set.getOutcome());
        Assertions.assertNull(set.getOutcome());


        // Rafael get a talking too from his coach and have
        // a wonderful comeback two games on a row
        for (int i = 0; i < 8; i++) {
            setService.winPoint(set, 0);
        }

        // Wonderful Set and Match for Rafael Nadal
        Assertions.assertEquals(Score.SWIN,set.getOutcome() );
        Assertions.assertEquals(player1,set.getOutcomePlayer());

    }



}
