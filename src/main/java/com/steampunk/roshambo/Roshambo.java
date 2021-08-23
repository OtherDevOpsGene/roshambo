package com.steampunk.roshambo;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Roshambo {

    private int wins = 0;
    private int losses = 0;
    private int draws = 0;

    public int getWins() {
        return wins;
    }

    void setWins(final int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    void setLosses(final int losses) {
        this.losses = losses;
    }

    public int getDraws() {
        return draws;
    }

    void setDraws(final int draws) {
        this.draws = draws;
    }

    String check(final Play human, final Play computer) {
        final StringBuilder result = new StringBuilder();
        if (computer == human) {
            draws++;
            result.append("Draw.\n");
        } else {
            String beats = human.beats(computer);
            if (null == beats) {
                losses++;
                beats = computer.beats(human);
                result.append(String.format("%s %s %s. You lose.%n", computer, beats, human));
            } else {
                wins++;
                result.append(String.format("%s %s %s. You win.%n", human, beats, computer));
            }
        }
        return result.toString();
    }

    String tally() {
        if (losses > wins) {
            return "The computer wins.";
        } else if (wins > losses) {
            return "You win.";
        } else {
            return "You tied.";
        }
    }

    public static void main(final String[] args) {
        final Roshambo game = new Roshambo();

        final List<String> allPlays = Stream.of(Play.values()).map(Enum::toString).collect(Collectors.toList());
        System.out.print(String.join(", ", allPlays));
        System.out.println(", or anything else to quit.");

        final Scanner in = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            System.out.print("Enter your throw: ");
            final Play human = Play.parse(in.nextLine());
            if (null == human) {
                quit = true;
            } else {
                final Play computer = Play.random();
                final String result = game.check(human, computer);
                System.out.format("Computer throws %s. %s%n", computer, result);
            }
        }
        System.out.format("%nFinal score: %d to %d, %d draws.%n", game.getWins(), game.getLosses(), game.getDraws());
        System.out.println(game.tally());
    }

}
