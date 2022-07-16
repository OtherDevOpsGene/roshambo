package com.steampunk.roshambo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoshamboTest {

    private Roshambo game;

    @BeforeEach
    public void setUp() {
        this.game = new Roshambo();
    }

    @Test
    void checkRockVsScissors() {
        final String result = game.check(Play.ROCK, Play.SCISSORS);

        assertTrue(result.contains("Rock crushes Scissors. You win."));
    }

    @Test
    void checkPaperVsRock() {
        final String result = game.check(Play.PAPER, Play.ROCK);

        assertTrue(result.contains("Paper covers Rock. You win."));
    }

    @Test
    void checkScissorsVsPaper() {
        final String result = game.check(Play.SCISSORS, Play.PAPER);

        assertTrue(result.contains("Scissors cut Paper. You win."));
    }

    @Test
    void checkPaperVsPaper() {
        final String result = game.check(Play.PAPER, Play.PAPER);

        assertTrue(result.contains("Draw."));
    }

    @Test
    void tallyHumanWins() {
        game.setWins(10);
        game.setLosses(5);

        final String tally = game.tally();

        assertEquals("You win.", tally);
    }
}
