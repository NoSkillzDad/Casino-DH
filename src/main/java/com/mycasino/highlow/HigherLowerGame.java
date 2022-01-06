package com.mycasino.highlow;
import java.util.Random;
import java.util.Scanner;

public class HigherLowerGame {
    private boolean playingGame = true;
    private int numberGuesses = 0;
    private int gameDifficulty = 5; // 1 to 20
    private int upperBound = gameDifficulty * 10;
    private int numberToGuess;
    private Scanner input = new Scanner(System.in);
    private int playerGuess;

    //Constructor
    public HigherLowerGame() {}

    public HigherLowerGame(int gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
    }

    //Getters
    public int getNumberGuesses() {
        return numberGuesses;
    }

    //Setters
    public void setGameDifficulty(int gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
    }

    public void playGame() {
        System.out.println("Welcome to the Higher-Lower Game");
        System.out.println("I have a number. See if you can guess it:");

        numberToGuess = new Random().nextInt(upperBound);

        while (playingGame) {
            System.out.println("Enter a number between 1 and " + upperBound + ": ");
            playerGuess = input.nextInt();
            numberGuesses++;
            if (playerGuess > numberToGuess) {
                System.out.println("\n\rToo high, try again: ");
            } else {
                if (playerGuess < numberToGuess) {
                    System.out.println("\n\rToo low, try again: ");
                } else {
                    System.out.println("You got it! It took you: " + numberGuesses + " tries");
                    playingGame = false;
                }
            }
        }
    }
}




