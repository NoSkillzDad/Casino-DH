package com.mycasino;

import java.util.Scanner;

public class GameMenu {
    public static int gameChoice() {
        var choice = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("\nGames Menu\n");
        System.out.println("1: High\\Low");
        System.out.println("2: Simple Blackjack");
        System.out.println("3: Low Deck Blackjack");
        System.out.println("4: Slot machines");
        System.out.println("0: Exit");
        System.out.print("\nWhat game would you like to play?: ");
        if (in.hasNextInt()) {
            choice = in.nextInt();
            return choice;
        } else {
            return 9;
        }
    }
}
