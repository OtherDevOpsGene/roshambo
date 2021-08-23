package com.steampunk.roshambo;

import org.junit.jupiter.api.Test;

import java.util.EnumMap;

import static org.junit.jupiter.api.Assertions.*;

class PlayTest {

    public static final int ITERATIONS = 1000;

    @Test
    void parse() {
      assertEquals(Play.ROCK, Play.parse("rock"));
      assertEquals(Play.PAPER, Play.parse("PAPER"));
      assertEquals(Play.SCISSORS, Play.parse("Scissors"));
    }

    @Test
    void random() {
        final EnumMap<Play, Integer> counts = new EnumMap<>(Play.class);
        for (int i = 0; i < ITERATIONS; i++) {
            final Play play = Play.random();
            final int count = counts.getOrDefault(play, 0);
            counts.put(play, count + 1);
        }

        for (Play play: Play.values()) {
            // System.out.format("%8s -> %d%n", play, counts.get(play));
            assertTrue(counts.get(play) > 0, play + " wasn't returned at all.");
        }
    }
}
