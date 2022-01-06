package com.aperalta.casino;

import java.util.Scanner;

public class GameMenu {
    public static int gameChoice() {
        var choice = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("\nGames Menu\n");
        System.out.println("1: High\\Low");
        System.out.println("2: BlackJack");
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
