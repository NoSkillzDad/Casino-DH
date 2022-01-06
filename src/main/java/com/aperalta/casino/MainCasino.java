package com.aperalta.casino;
//import com.mycasino.highlow.HigherLowerGame;

import com.mycasino.blackjack.BlackJackGame;
import com.mycasino.highlow.HigherLowerGame;

import java.util.Scanner;

import static com.aperalta.casino.GameMenu.gameChoice;

public class MainCasino {
    public static void main(String[] args) {

        int choice = 1;

        while (choice != 0) {
            choice = gameChoice();
            switch (choice) {
                case 1 -> {
                    HigherLowerGame highLowGame = new HigherLowerGame(1);
                    highLowGame.playGame();
                }
                case 2 -> {
                    Scanner scannerIn = new Scanner(System.in);
                    BlackJackGame blackJackGame = new BlackJackGame(scannerIn);
                    blackJackGame.playGame();
                }
                case 3 -> { //HangMan
                }
                case 0 -> {
                    System.out.println("\nHave a good one!");
                    System.exit(0);
                }
                default -> System.out.println("\nThat was not a valid choice. Please try again!");
            }
        }
    }
}
