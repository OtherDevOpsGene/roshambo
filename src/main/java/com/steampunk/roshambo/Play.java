package com.steampunk.roshambo;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Rock crushes scissors. Paper covers rock. Scissors cut paper.
 */
public enum Play {

    ROCK {
        @Override
        public String beats(final Play other) {
            switch (other) {
                case SCISSORS:
                    return "crushes";
                default:
                    return null;
            }
        }
        @Override
        public String toString() {
            return "Rock";
        }
    },
    PAPER {
        @Override
        public String beats(final Play other) {
            switch (other) {
                case ROCK:
                    return "covers";
                default:
                    return null;
            }
        }
        @Override
        public String toString() {
            return "Paper";
        }
    },
    SCISSORS {
        @Override
        public String beats(final Play other) {
            switch (other) {
                case PAPER:
                    return "cut";
                default:
                    return null;
            }
        }
        @Override
        public String toString() {
            return "Scissors";
        }
    };

    public abstract String beats(final Play other);

    public static Play parse(final String in) {
        final String value = in.toLowerCase().trim();
        switch (value) {
            case "rock":
                return ROCK;
            case "paper":
                return PAPER;
            case "scissors":
                return SCISSORS;
            default:
                return null;
        }
    }

    public static Play random() {
        final int i = ThreadLocalRandom.current().nextInt(0, Play.values().length);
        return Play.values()[i];
    }
}
