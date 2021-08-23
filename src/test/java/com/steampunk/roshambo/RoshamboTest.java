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
        assertAll("score",
                () -> assertEquals(1, game.getWins(), "wins don't match"),
                () -> assertEquals(0, game.getLosses(), "losses don't match"),
                () -> assertEquals(0, game.getDraws(), "draws don't match")
        );
    }

    @Test
    void checkPaperVsRock() {
        final String result = game.check(Play.PAPER, Play.ROCK);

        assertTrue(result.contains("Paper covers Rock. You win."));
        assertAll("score",
                () -> assertEquals(1, game.getWins(), "wins don't match"),
                () -> assertEquals(0, game.getLosses(), "losses don't match"),
                () -> assertEquals(0, game.getDraws(), "draws don't match")
        );
    }

    @Test
    void checkScissorsVsPaper() {
        final String result = game.check(Play.SCISSORS, Play.PAPER);

        assertTrue(result.contains("Scissors cut Paper. You win."));
        assertAll("score",
                () -> assertEquals(1, game.getWins(), "wins don't match"),
                () -> assertEquals(0, game.getLosses(), "losses don't match"),
                () -> assertEquals(0, game.getDraws(), "draws don't match")
        );
    }

    @Test
    void checkPaperVsPaper() {
        final String result = game.check(Play.PAPER, Play.PAPER);

        assertTrue(result.contains("Draw."));
        assertAll("score",
                () -> assertEquals(0, game.getWins(), "wins don't match"),
                () -> assertEquals(0, game.getLosses(), "losses don't match"),
                () -> assertEquals(1, game.getDraws(), "draws don't match")
        );
    }

    @Test
    void tallyHumanWins() {
        game.setWins(10);
        game.setLosses(5);

        final String tally = game.tally();

        assertEquals("You win.", tally);
    }

    @Test
    void tallyComputerWins() {
        game.setWins(4);
        game.setLosses(8);

        final String tally = game.tally();

        assertEquals("The computer wins.", tally);
    }

    @Test
    void tallyTie() {
        game.setWins(1);
        game.setLosses(1);

        final String tally = game.tally();

        assertEquals("You tied.", tally);
    }
}
