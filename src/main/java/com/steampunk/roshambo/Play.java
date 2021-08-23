package com.steampunk.roshambo;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Scissors cut Paper.
 * Paper covers Rock.
 * Rock crushes Lizard.
 * Lizard poisons Spock.
 * Spock smashes Scissors.
 * Scissors decapitate Lizard.
 * Lizard eats Paper.
 * Paper disproves Spock.
 * Spock vaporizes Rock
 * Rock crushes Scissors.
 */
public enum Play {
    ROCK {
        @Override
        public String beats(final Play other) {
            switch (other) {
                case SCISSORS:
                case LIZARD:
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
                case SPOCK:
                    return "disproves";
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
                case LIZARD:
                    return "decapitates";
                default:
                    return null;
            }
        }
        @Override
        public String toString() {
            return "Scissors";
        }
    },
    LIZARD {
        @Override
        public String beats(final Play other) {
            switch (other) {
                case SPOCK:
                    return "poisons";
                case PAPER:
                    return "eats";
                default:
                    return null;
            }
        }
        @Override
        public String toString() {
            return "Lizard";
        }
    },
    SPOCK {
        @Override
        public String beats(final Play other) {
            switch (other) {
                case SCISSORS:
                    return "smashes";
                case ROCK:
                    return "vaporizes";
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
            case "scissor":
            case "scissors":
                return SCISSORS;
            case "lizard":
                return LIZARD;
            case "spock":
                return SPOCK;
            default:
                return null;
        }
    }

    public static Play random() {
        final int i = ThreadLocalRandom.current().nextInt(0, Play.values().length);
        return Play.values()[i];
    }
}
