// Gavan Bess
// 01/08/2026
// AP CS A
// Lab #6 - Guessing Game
//
// A "Higher/Lower" number guessing game

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static final int MAX_VALUE = 100;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int totalGuesses = 0;
        int totalGames = 0;
        int bestGame = Integer.MAX_VALUE;

        GameLoop:
        while (true) {
            int guesses = playOneGame(random, scanner);

            totalGames++;
            totalGuesses += Math.abs(guesses);

            if (Math.abs(guesses) < bestGame) { bestGame = Math.abs(guesses); }

            if (guesses > 0) {
                break GameLoop;
            }
        }

        printStatistics(totalGuesses, totalGames, bestGame);
    }

    public static int playOneGame(Random random, Scanner scanner) {
        int numGuesses = 0;

        final int secretNumber = random.nextInt(1, MAX_VALUE+1);

        System.out.println("I'm thinking of a number between 1 and "+String.valueOf(MAX_VALUE)+"...");

        GuessingLoop:
        while (true) {
            System.out.print("Your guess? ");
            int guess = scanner.nextInt();

            numGuesses++;

            if (guess == secretNumber) { break GuessingLoop; } else if (guess < secretNumber) {
                System.out.println("It's higher.");
            } else {
                System.out.println("It's lower.");
            }
        }

        System.out.println("You got it right in "+String.valueOf(numGuesses)+((numGuesses > 1) ? " guesses!" : " guess!"));
        System.out.print("Do you want to play again? ");

        String userPlayAgainResponse = scanner.next();

        if (userPlayAgainResponse.startsWith("Y") || userPlayAgainResponse.startsWith("y")) {
            numGuesses *= -1;
        }

        System.out.println();

        return numGuesses;
    }

    public static void printStatistics(int totalGuesses, int totalGames, int bestGame) {
        System.out.println("Overall results:");
        System.out.println("Total games   = "+String.valueOf(totalGames));
        System.out.println("Total guesses = "+String.valueOf(totalGuesses));
        float guessesPerGame = ((float)(totalGuesses*10/totalGames))/10;
        System.out.println("Guesses/game  = "+String.valueOf(guessesPerGame));
        System.out.println("Best game     = "+String.valueOf(bestGame));
    }
}
