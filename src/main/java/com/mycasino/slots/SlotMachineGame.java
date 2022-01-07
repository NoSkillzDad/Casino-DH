package com.mycasino.slots;

import com.mycasino.slots.machines.SlotMachine;
import com.mycasino.slots.machines.fivereeler.FiveReeler;
import com.mycasino.slots.machines.highroller.HighRoller;
import com.mycasino.slots.machines.penny.Penny;

import java.util.Scanner;

public class SlotMachineGame {
    private final Scanner scannerIn;
    private final SlotMachine[] slotMachines;
    private SlotMachine activeMachine;

    private boolean isGameRunning;
    private int startCoins;
    private int currentCoins;

    public SlotMachineGame(Scanner scannerIn) {
        this.scannerIn = scannerIn;
//        slotMachines = new SlotMachine[] { new Penny(), new FiveReeler(), new HighRoller()};
        slotMachines = new SlotMachine[] { new Penny(), new HighRoller(), new FiveReeler() };
    }

    public void playGame() {
        isGameRunning = true;
        startCoins = 100;
        currentCoins = startCoins;

        activeMachine = pickMachine(currentCoins);
        activeMachine.renderIntro();
        while (isGameRunning) {
            runGameLoop();
        }
    }

    private void runGameLoop() {
        if (currentCoins < activeMachine.getRollPrice()) {
            System.out.println("You dont have enough coins to play this game!");
            isGameRunning = false;
        }
        var move = getNextMove();
        if (move.equals("s")) {
            System.out.printf("Thank you for playing. Your balance is %d coins", currentCoins);
            isGameRunning = false;
        } else {
            this.currentCoins = currentCoins - activeMachine.getRollPrice();
            int winnings = activeMachine.roll();
            this.currentCoins = currentCoins + winnings;
            System.out.println(activeMachine.render());
            System.out.printf("You won %d coins\n", winnings);
            System.out.printf("Your current balance is %d\n", currentCoins);

            if (currentCoins < activeMachine.getRollPrice()) {
                System.out.println("You dont have enough coins to play this game!");
                isGameRunning = false;
            }
        }
    }

    private SlotMachine pickMachine(int coins) {
        while (true) {
            System.out.println("Pick your game: (0 = Penny Machine, 1 = High Roller, 2 = Five Reeler)");
            int index = scannerIn.nextInt();

            if (index >=0 && index <= 2) {
                var machine = slotMachines[index];
                if (machine.getRollPrice() <= coins) {
                    return machine;
                } else {
                    System.out.printf("You dont have enough coins to play on this machine, you need %d and you have %d\n",
                            machine.getRollPrice(), coins);
                }
            }
        }
    }

    private String getNextMove() {
        while (true) {
            System.out.println("Hit r to roll or s to stop playing");

            if (scannerIn.hasNext()) {
                String move = scannerIn.nextLine();
                if (move.equals("r") || move.equals("s")) {
                    return move;
                }
            }
        }
    }
}
