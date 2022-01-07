package com.mycasino;
//import com.mycasino.highlow.HigherLowerGame;

import com.mycasino.blackjack.BlackJackGame;
import com.mycasino.blackjack.LowDeckBlackJack;
import com.mycasino.blackjack.SimpleBlackJack;
import com.mycasino.highlow.HigherLowerGame;
import com.mycasino.slots.SlotMachineGame;

import java.util.Scanner;

import static com.mycasino.GameMenu.gameChoice;

public class MainCasino {
    public static void main(String[] args) {

        int choice = 1;

        while (choice != 0) {
            choice = gameChoice();
            switch (choice) {
                case 1 -> {
                    HigherLowerGame highLowGame = new HigherLowerGame(1);
                    highLowGame.playGame();
                    break;
                }
                case 2 -> {
                    Scanner scannerIn = new Scanner(System.in);
                    BlackJackGame blackJackGame = new SimpleBlackJack(scannerIn);
                    blackJackGame.playGame();
                    break;
                }
                case 3 -> {
                    Scanner scannerIn = new Scanner(System.in);
                    BlackJackGame blackJackGame = new LowDeckBlackJack(scannerIn);
                    blackJackGame.playGame();
                    break;
                }
                case 4 -> {
                    Scanner scannerIn = new Scanner(System.in);
                    SlotMachineGame slotGame = new SlotMachineGame(scannerIn);
                    slotGame.playGame();
                    break;
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
